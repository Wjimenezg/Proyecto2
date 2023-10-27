
package fabrica_de_sillas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaBD {
    private ConexionBD conexionBD;

    public ConsultaBD() {
        try {
            conexionBD = new ConexionBD(); // Inicializa la conexión en el constructor
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarUsuario(int IdProducto, String color ,double precio ,String material) {
        try {
            // Inserta un registro en la tabla usuarios
            Object[] datos = new Object[]{IdProducto, color, precio, material};
            conexionBD.insertar("producto", datos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarNombreUsuario(int id, String nuevoNombre) {
        try {
            // Modifica el campo nombre de un registro en la tabla usuarios
            String condicion = "id = " + id;
            conexionBD.modificar("usuarios", "nombre", nuevoNombre, condicion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id) {
        try {
            // Elimina un registro en la tabla usuarios
            String condicion = "id = " + id;
            conexionBD.eliminar("usuarios", condicion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarUsuarios() {
        try {
            // Consulta todos los registros de la tabla usuarios
            String sql = "SELECT * FROM inventario";
            ResultSet resultados = conexionBD.consultar(sql);

            // Itera sobre los resultados
            while (resultados.next()) {
                // Obtiene el valor de cada campo
                int IdProducto = resultados.getInt("IdProducto");
                String tipoSilla = resultados.getString("tipoSilla");
                int cantidad = resultados.getInt("cantidad");

                // Imprime los valores
                System.out.print("Producto: " + IdProducto +" ");
                System.out.print("tipoSilla: " + tipoSilla +" ");
                System.out.println("cantidad: " + cantidad );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarCantidad(int cantidadDeseada) {
    try {
        // Consulta los registros de la tabla Inventario que cumplen con la condición
        String sql = "SELECT * FROM Inventario WHERE cantidad = ?";
        
        PreparedStatement statement = conexionBD.getConnection().prepareStatement(sql);
        statement.setInt(1, cantidadDeseada);

        ResultSet resultados = statement.executeQuery();

        // Variable para rastrear si se encontró al menos un resultado
        boolean encontrado = false;

        // Itera sobre los resultados
        while (resultados.next()) {
            // Obtiene el valor de cada campo
            int IdProducto = resultados.getInt("IdProducto");
            String tipoSilla = resultados.getString("tipoSilla");
            int cantidad = resultados.getInt("cantidad");

            // Imprime los valores
            System.out.print("Producto: " + IdProducto +" ");
            System.out.print("tipoSilla: " + tipoSilla +" ");
            System.out.println("cantidad: " + cantidad);
            encontrado = true;
        }

        // Verifica si no se encontró ninguna cantidad y muestra un mensaje
        if (!encontrado) {
            System.out.println("No se encontró ninguna cantidad igual a " + cantidadDeseada + " en la base de datos.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public void cerrarConexion() {
        try {
            // Cierra la conexión a la base de datos
            conexionBD.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
