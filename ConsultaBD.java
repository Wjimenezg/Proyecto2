
package fabrica_de_sillas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaBD {
    //private ConexionBD conexionBD;
            // Crea una instancia de la clase ConexionBD
           ConexionBD conexionBD = new ConexionBD();
        
    

    public void insertarUsuario(int IdProducto, String color ,int precio ,String material) {
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
            String sql = "SELECT * FROM usuarios";
            ResultSet resultados = conexionBD.consultar(sql);

            // Itera sobre los resultados
            while (resultados.next()) {
                // Obtiene el valor de cada campo
                int id = resultados.getInt("id");
                String nombre = resultados.getString("nombre");
                int edad = resultados.getInt("edad");

                // Imprime los valores
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + edad);
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
