
package fabrica_de_sillas;

import java.util.*;
public class Producto {
        private Map<String, Double> precios;
    private Map<String, String> color;
    private Map<String, String> material;
    private Map<String, String> detalles;

    public Producto() {
        precios = new HashMap<>();
        color = new HashMap<>();
        material = new HashMap<>();
        detalles = new HashMap<>();

        // Agrega precios y detalles para cada tipo de silla
        precios.put("Gamer", 970.00);
        color.put("Gamer", "Rojo, Azul, Verde");
        material.put("Gamer", "Plástico y Metal");
        detalles.put("Gamer", "Una silla Gamer cómoda y ergonómica.");

        precios.put("Comedor", 350.00);
        color.put("Comedor", "Negro, Café, Corinto");
        material.put("Comedor", "Madera y plástico");
        detalles.put("Comedor", "Una silla de comedor elegante y resistente.");

        precios.put("Patio", 110.00);
        color.put("Patio", "Negro, Gris y Verde");
        material.put("Patio", "Plástico");
        detalles.put("Patio", "Una silla de patio resistente a la intemperie.");

        precios.put("Oficina", 550.00);
        color.put("Oficina", "Negro y Gris");
        material.put("Oficina", "Plástico y Metal");
        detalles.put("Oficina", "Una silla de oficina ergonómica y funcional.");

        precios.put("Sencilla", 65.00);
        color.put("Sencilla", "Verde, Azul, Negro, Gris");
        material.put("Sencilla", "Plástico");
        detalles.put("Sencilla", "Una silla sencilla y versátil.");
    }

    public double obtenerPrecio(String tipoSilla) {
        return precios.getOrDefault(tipoSilla, 0.0);
    }

    public String obtenerDetallesSilla(String tipoSilla) {
        return detalles.getOrDefault(tipoSilla, "No se encontraron detalles para esta silla.");
    }

    public String obtenerColorSilla(String tipoSilla) {
        return color.getOrDefault(tipoSilla, "No se encontraron detalles de color para esta silla.");
    }

    public String obtenerMaterialSilla(String tipoSilla) {
        return material.getOrDefault(tipoSilla, "No se encontraron detalles de material para esta silla.");
    }

    public Map<String, Double> getPrecios() {
        return precios;
    }
    
}
    /*private Map<String, Double> precios;
    private Map<String, String> color;
    private Map<String, String> material;
    private Map<String, String> detalles;

    public Producto() {
        precios = new HashMap<>();
        color = new HashMap<>();
        material = new HashMap<>();
        detalles = new HashMap<>();
        
        // Agrega precios y detalles para cada tipo de silla
        precios.put("Gamer", 970.00);
        color.put("Gamer", "Rojo, Azul, Verde");
        material.put("Gamer", "Plastico y Metal");
        detalles.put("Gamer", "Una silla Gamer comoda y ergonomica.");
        
        precios.put("Comedor", 350.00);
        color.put("Comedor", "Negro, Cafe, Corinto");
        material.put("Comedor", "Madera y plastico");
        detalles.put("Comedor", "Una silla de comedor elegante y resistente.");
        
        precios.put("Patio", 110.00);
        color.put("Patio", "Negro, gris y verde");
        material.put("Patio", "Plastico");
        detalles.put("Patio", "Una silla de patio resistente a la intemperie.");
        
        precios.put("Oficina", 550.00);
        color.put("Oficina", "Negro y Gris");
        material.put("Oficina", "Plastico y Metal");
        detalles.put("Oficina", "Una silla de oficina ergonomica y funcional.");
        
        precios.put("Sencilla", 65.00);
        color.put("Sencilla", "Verde, azul, negro, gris");
        material.put("Sencilla", "Plastico");
        detalles.put("Sencilla", "Una silla sencilla y versatil.");
    }

    public double obtenerPrecio(String tipoSilla) {
        return precios.getOrDefault(tipoSilla, 0.0);
    }

    public String obtenerDetallesSilla(String tipoSilla) {
        return detalles.getOrDefault(tipoSilla, "No se encontraron detalles para esta silla.");
    }

    public String obtenerColorSilla(String tipoSilla) {
        return color.getOrDefault(tipoSilla, "No se encontraron detalles de color para esta silla.");
    }
    
    public String obtenerMaterialSilla(String tipoSilla){
        return material.getOrDefault(tipoSilla, "No se encontraron detalles de color para esta silla");
    }

    public Map<String, Double> getPrecios() {
        return precios;
    }
}*/

