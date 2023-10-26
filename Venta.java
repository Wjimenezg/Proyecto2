
package fabrica_de_sillas;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Venta {
        private String tipoSilla;
    private String color;
    private double costoTotal;
    private Connection conexion;

    private Scanner scanner = new Scanner(System.in);
    private Inventario inventario;
    private Proceso proceso;
    private Producto producto;
    private ArrayList<Factura> facturas = new ArrayList<>();
    private final ConexionBD conexionBD;

    public Venta(ConexionBD conexionBD, String tipoSilla, String color, double costoTotal, Proceso proceso, Inventario inventario, Producto producto) {
        this.tipoSilla = tipoSilla;
        this.color = color;
        this.costoTotal = costoTotal;
        this.proceso = proceso;
        this.inventario = inventario;
        this.producto = producto;
        this.conexionBD = conexionBD;
    }

    public String getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(String tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public boolean venderSilla(String tipoSilla, int cantidad) {
        int cantidadDisponible = inventario.getCantidadSilla(tipoSilla);
        double precioSilla = producto.obtenerPrecio(tipoSilla);
        double costoTotal = precioSilla * cantidad;

        if (cantidadDisponible >= cantidad) {
            inventario.actualizarCantidadSilla(tipoSilla, -cantidad);

            System.out.println("¡Venta realizada!");

            Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);

            // Guardar factura en la base de datos
            try {
                factura.guardarEnBaseDeDatos(conexionBD);
                System.out.println("Factura guardada en la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al guardar la factura en la base de datos. Venta no realizada.");
            }

            return true;
        } else {
            System.out.println("No hay suficientes sillas en el inventario.");
            System.out.println("¿Desea fabricar " + cantidad + " sillas " + tipoSilla + "? (Sí/No)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                proceso.fabricarSilla(tipoSilla, cantidad);

                System.out.println("¡Venta realizada!");

                double costoTotalDespuesFabricacion = precioSilla * cantidad;

                Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotalDespuesFabricacion);

                // Guardar factura en la base de datos
                try {
                    factura.guardarEnBaseDeDatos(conexionBD);
                    System.out.println("Factura guardada en la base de datos.");
                } catch (SQLException e) {
                    System.out.println("Error al guardar la factura en la base de datos. Venta no realizada.");
                }

                return true;
            } else {
                System.out.println("Venta cancelada.");
                return false;
            }
        }
    }
}
    /*private String tipoSilla;
    private String color;
    private double costoTotal;
    private Connection conexion;

    private Scanner scanner = new Scanner(System.in);
    private Inventario inventario;
    private Proceso proceso;
    private Producto producto;
    private ArrayList<Factura> facturas = new ArrayList<>();
    private final ConexionBD conexionBD;

    public Venta(ConexionBD conexionBD, String tipoSilla, String color, double costoTotal, Proceso proceso, Inventario inventario, Producto producto) {
        this.tipoSilla = tipoSilla;
        this.color = color;
        this.costoTotal = costoTotal;
        this.proceso = proceso;
        this.inventario = inventario;
        this.producto = producto;
        this.conexionBD = conexionBD;
    }

    public String getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(String tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public boolean venderSilla(String tipoSilla, int cantidad) {
        int cantidadDisponible = inventario.getCantidadSilla(tipoSilla);
        double precioSilla = producto.obtenerPrecio(tipoSilla);
        double costoTotal = precioSilla * cantidad;

        if (cantidadDisponible >= cantidad) {
            inventario.actualizarCantidadSilla(tipoSilla, -cantidad);

            System.out.println("¡Venta realizada!");

            Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);

            // Guardar factura en la base de datos
            try {
                factura.guardarEnBaseDeDatos(conexionBD);
                System.out.println("Factura guardada en la base de datos.");
            } catch (SQLException e) {
                System.out.println("Error al guardar la factura en la base de datos. Venta no realizada.");
            }

            return true;
        } else {
            System.out.println("No hay suficientes sillas en el inventario.");
            System.out.println("¿Desea fabricar " + cantidad + " sillas " + tipoSilla + "? (Sí/No)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                proceso.fabricarSilla(tipoSilla, cantidad, producto);

                System.out.println("¡Venta realizada!");

                double costoTotalDespuesFabricacion = precioSilla * cantidad;

                Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotalDespuesFabricacion);

                // Guardar factura en la base de datos
                try {
                    factura.guardarEnBaseDeDatos(conexionBD);
                    System.out.println("Factura guardada en la base de datos.");
                } catch (SQLException e) {

                    System.out.println("Error al guardar la factura en la base de datos. Venta no realizada.");
                }

                return true;
            } else {
                System.out.println("Venta cancelada.");
                return false;
            }
        }
    }
}*/
    
    
   /* private String tipoSilla;
    private String color;
    private double costoTotal;
    private Connection conexion;
    

    private Scanner scanner = new Scanner(System.in);
    private Inventario inventario;
    private Proceso proceso;
    private Producto producto;
    private ArrayList<Factura> facturas = new ArrayList<>();
    private final ConexionBD conexionBD;


    public Venta(ConexionBD conexionBD, String tipoSilla, String color, double costoTotal, Proceso proceso, Inventario inventario, Producto producto) {
        this.tipoSilla = tipoSilla;
        this.color = color;
        this.costoTotal = costoTotal;
        this.proceso = proceso;
        this.inventario = inventario;
        this.producto = producto;
        this.conexionBD = conexionBD;
    }


    public String getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(String tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public boolean venderSilla(String tipoSilla, int cantidad) {
        int cantidadDisponible = inventario.getCantidadSilla(tipoSilla);

        // Obtener el precio de la silla del objeto Producto
        double precioSilla = producto.obtenerPrecio(tipoSilla);

        // Calcular el costo total
        double costoTotal = precioSilla * cantidad;

        if (cantidadDisponible >= cantidad) {
            // Hay suficientes sillas disponibles en el inventario.
            inventario.actualizarCantidadSilla(tipoSilla, -cantidad);
            
            // Crear la factura antes de la compra

            Factura facturaAntesCompra = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);
            facturas.add(facturaAntesCompra);

            System.out.println("¡Venta realizada!");
            return true;
        } else {
            // No hay suficientes sillas disponibles en el inventario.
            System.out.println("No hay suficientes sillas en el inventario.");

            // Solicitar al usuario la cantidad de sillas a fabricar.
            System.out.println("¿Desea fabricar " + cantidad + " sillas " + tipoSilla + "? (Sí/No)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                proceso.fabricarSilla(tipoSilla, cantidad, producto);
                System.out.println("¡Venta realizada!");
                return true; // Devuelve true para indicar que la venta fue exitosa después de fabricar sillas.
            } else {
                System.out.println("Venta cancelada.");
                return false; // Devuelve false para indicar que la venta fue cancelada.
            }
        }
    }

}*/

    /*private int idVenta;
    private String tipoSilla;
    private String color;
    private double costoTotal;
    
    private Scanner scanner = new Scanner(System.in);
    //private Inventario inventario;
    private Proceso proceso;
    private Producto producto;
    private Factura factura;

    public Venta(int idVenta, String tipoSilla, String color, double costoTotal, Proceso proceso) {
    this.idVenta = idVenta;
    this.tipoSilla = tipoSilla;
    this.color = color;
    this.costoTotal = costoTotal;
    this.inventario = inventario;  // Esto debería ser "this.proceso = proceso;" en lugar de "this.inventario = inventario;".
    this.proceso = proceso;
        
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getTipoSilla() {
        return tipoSilla;
    }

    public void setTipoSilla(String tipoSilla) {
        this.tipoSilla = tipoSilla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    
    private Inventario inventario; // Asegúrate de tener una referencia al Inventario.

    public Venta(Inventario inventario) {
        this.inventario = inventario;
    }

    
        public boolean venderSilla(Proceso proceso, String tipoSilla, int cantidad) {
        int cantidadDisponible = inventario.getCantidadSilla(tipoSilla);
        
                // Obtener el precio de la silla del objeto Producto
        double precioSilla = producto.obtenerPrecio(tipoSilla);
                    Factura facturaAntesCompra = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);
                // Calcular el costo total
        double costoTotal = precioSilla * cantidad;
        if (cantidadDisponible >= cantidad) {
            // Hay suficientes sillas disponibles en el inventario.
            inventario.actualizarCantidadSilla(tipoSilla, -cantidad); // Resta la cantidad especificada del inventario.
            // Registrar la factura antes de la compra

            facturas.add(facturaAntesCompra);
            System.out.println("¡Venta realizada!");
            return true; // Devuelve true para indicar que la venta fue exitosa.
        } else {
            // No hay suficientes sillas disponibles en el inventario.
            System.out.println("No hay suficientes sillas en el inventario.");

            // Solicitar al usuario la cantidad de sillas a fabricar.
            System.out.println("¿Desea fabricar " + cantidad + " sillas " + tipoSilla + "? (Sí/No)");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("si")) {
                proceso.fabricarSilla(tipoSilla, cantidad);
                System.out.println("¡Venta realizada!");
                return true; // Devuelve true para indicar que la venta fue exitosa después de fabricar sillas.
            } else {
                System.out.println("Venta cancelada.");
                return false; // Devuelve false para indicar que la venta fue cancelada.
            }
        }
        
        
        }*/

    
    

    
    

