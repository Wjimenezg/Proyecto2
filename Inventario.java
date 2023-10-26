
package fabrica_de_sillas;

import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
public class Inventario {
    
    private ConexionBD conexionBD;
     HashMap<String, Integer> tiposSillas;
     HashMap<String, HashMap<String, Integer>> materiales;


    public Inventario(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        tiposSillas = new HashMap<>();
        materiales = new HashMap<>();
        inicializarInventario();
    }

    private void inicializarInventario() {
        // Inicializar el inventario con tipos de sillas disponibles y cantidades iniciales
        tiposSillas.put("Gamer", 50);
        tiposSillas.put("Comedor", 50);
        tiposSillas.put("Patio", 50);
        tiposSillas.put("Oficina", 50);
        tiposSillas.put("Sencilla", 50);

        // Inicializar el inventario con materiales disponibles y cantidades iniciales
        materiales.put("Madera", new HashMap<>());
        materiales.put("Plástico", new HashMap<>());
        materiales.put("Metal", new HashMap<>());
        materiales.put("Clavos", new HashMap<>());
        materiales.put("Tornillos", new HashMap<>());
        materiales.put("Pegamento", new HashMap<>());
        materiales.put("Pintura", new HashMap<>());
        materiales.put("Tela", new HashMap<>());
    }

// Método para agregar material al inventario
public void agregarMaterial(String tipo, String tamano, int cantidad) {
    if (materiales.containsKey(tipo)) {
        Map<String, Integer> tamanoCantidad = materiales.get(tipo);
        tamanoCantidad.put(tamano, tamanoCantidad.getOrDefault(tamano, 0) + cantidad);
    } else {
        // Si el tipo de material no existe, crear un nuevo HashMap para tamaños.
        HashMap<String, Integer> tamanoCantidad = new HashMap<>();
        tamanoCantidad.put(tamano, cantidad);
        materiales.put(tipo, tamanoCantidad);
    }
}
    
        // Método para verificar la existencia de material
    public boolean validarExistencia(String tipo, String tamano, int cantidadRequerida) {
        if (materiales.containsKey(tipo)) {
            Map<String, Integer> tamanoCantidad = materiales.get(tipo);
            if (tamanoCantidad.containsKey(tamano)) {
                int cantidadDisponible = tamanoCantidad.get(tamano);
                return cantidadDisponible >= cantidadRequerida;
            }
        }
        return false;
    }
    
    // Actualizar la cantidad de una silla en el inventario
        public void actualizarCantidadSilla(String tipoSilla, int cantidad) {
         if (tiposSillas.containsKey(tipoSilla)) {
        int cantidadActual = tiposSillas.get(tipoSilla);
        tiposSillas.put(tipoSilla, cantidadActual + cantidad);
        // Llama al método para actualizar la base de datos.
        actualizarInventarioEnBaseDeDatos(tipoSilla, cantidadActual + cantidad);
    }
}
    
        public void actualizarInventarioEnBaseDeDatos(String tipoSilla, int cantidad) {
        try {
            // Actualiza la cantidad de sillas en la base de datos.
            Object[] datos = new Object[]{tipoSilla, cantidad};
            conexionBD.insertar("inventario", datos);
            System.out.println("Inventario actualizado en la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al actualizar el inventario en la base de datos.");
        }
    }

// Actualizar la cantidad de un material en el inventario
public void actualizarCantidadMaterial(String material, String tamano, int cantidad) {
    if (materiales.containsKey(material)) {
        HashMap<String, Integer> tamanoCantidad = materiales.get(material);
        tamanoCantidad.put(tamano, tamanoCantidad.getOrDefault(tamano, 0) + cantidad);
    } else {
        // Si el tipo de material no existe, crear un nuevo HashMap para tamaños.
        HashMap<String, Integer> tamanoCantidad = new HashMap<>();
        tamanoCantidad.put(tamano, cantidad);
        materiales.put(material, tamanoCantidad);
    }
}

public boolean verificarMaterialesSuficientes(String tipoSilla, int cantidad) {
    // Define los requerimientos de materiales para cada tipo de silla (ajusta estos valores según tus necesidades).
    Map<String, Integer> requerimientos = new HashMap<>();
    requerimientos.put("Gamer", 5);    // Ejemplo: 5 unidades de madera para una silla Gamer
    requerimientos.put("Comedor", 6);  // Ejemplo: 6 unidades de madera para una silla de comedor
    // Agrega otros tipos de sillas y sus requerimientos aquí.

    // Verifica si los materiales requeridos están disponibles en el inventario.
    if (tiposSillas.containsKey(tipoSilla)) {
        int cantidadRequerida = requerimientos.getOrDefault(tipoSilla, 0) * cantidad;
        Map<String, Integer> tamanoCantidad = materiales.get(tipoSilla);
        if (tamanoCantidad != null) {
            for (String material : tamanoCantidad.keySet()) {
                int cantidadDisponible = tamanoCantidad.get(material);
                if (cantidadRequerida > cantidadDisponible) {
                    return false; // No hay suficientes materiales.
                }
            }
        } else {
            return false; // El tipo de silla no tiene definidos los materiales requeridos.
        }
    } else {
        return false; // El tipo de silla no se encuentra en el inventario.
    }

    return true; // Si llegamos aquí, hay suficientes materiales.
}

    // Obtener la cantidad de un tipo de silla en el inventario
    public int getCantidadSilla(String tipoSilla) {
        if (tiposSillas.containsKey(tipoSilla)) {
            return tiposSillas.get(tipoSilla);
        }
        return 0; // Si el tipo de silla no se encuentra en el inventario.
    }

public int getCantidadMaterial(String material) {
    if (materiales.containsKey(material)) {
        int cantidadTotal = 0;
        HashMap<String, Integer> tamanoCantidad = materiales.get(material);
        for (int cantidad : tamanoCantidad.values()) {
            cantidadTotal += cantidad;
        }
        return cantidadTotal;
    }
    return 0; // Si el material no se encuentra en el inventario.
}
}
