
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
    
    

    
    

