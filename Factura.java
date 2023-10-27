
package fabrica_de_sillas;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
public class Factura {
        private String modeloSilla;
    private int cantidad;
    private double precio;
    private double total;

    public Factura(String modeloSilla, int cantidad, double precio, double total) {
        this.modeloSilla = modeloSilla;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public String getModeloSilla() {
        return modeloSilla;
    }

    public void setModeloSilla(String modeloSilla) {
        this.modeloSilla = modeloSilla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void guardarEnBaseDeDatos(ConexionBD conexionBD) throws SQLException {
        Connection connection = conexionBD.getConnection();
        String query = "INSERT INTO facturas (modelo_silla, cantidad, precio_unitario, total) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, modeloSilla);
            preparedStatement.setInt(2, cantidad);
            preparedStatement.setDouble(3, precio);
            preparedStatement.setDouble(4, total);

            preparedStatement.executeUpdate();
        }
    }

    public void imprimirFactura() {
        System.out.println("Modelo de Silla: " + modeloSilla);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: " + precio);
        System.out.println("Total: " + total);
        System.out.println();
    }
}
