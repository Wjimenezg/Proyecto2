package fabrica_de_sillas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
        private Connection conexion;

    public ConexionBD() throws SQLException {
        try {
            // Registrar el controlador de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");

            // URL de conexión para MariaDB
            String url = "jdbc:mariadb://" + "127.0.0.1" + ":" + "3306" + "/" + "tubasededatos";

            this.conexion = DriverManager.getConnection(url, "root", "S3g23.");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador de MariaDB: " + e.getMessage());
        }
    }



    public void insertar(String tabla, Object[] datos) throws SQLException {
        // Utiliza PreparedStatement para evitar SQL Injection
        String sql = "INSERT INTO " + tabla + " VALUES (";
        for (int i = 0; i < datos.length; i++) {
            sql += (i == 0 ? "?" : ", ?");
        }
        sql += ")";

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            for (int i = 0; i < datos.length; i++) {
                sentencia.setObject(i + 1, datos[i]);
            }
            sentencia.executeUpdate();
        }
    }

    public void modificar(String tabla, String campo, Object valor, String condicion) throws SQLException {
        // Utiliza PreparedStatement para evitar SQL Injection
        String sql = "UPDATE " + tabla + " SET " + campo + " = ? WHERE " + condicion;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.setObject(1, valor);
            sentencia.executeUpdate();
        }
    }

    public void eliminar(String tabla, String condicion) throws SQLException {
        // Utiliza PreparedStatement para evitar SQL Injection
        String sql = "DELETE FROM " + tabla + " WHERE " + condicion;

        try (PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            sentencia.executeUpdate();
        }
    }

    public ResultSet consultar(String sql) throws SQLException {
        Statement sentencia = conexion.createStatement();
        return sentencia.executeQuery(sql);
    }

    public Connection getConnection() {
        return conexion;
    }

    public void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
    
