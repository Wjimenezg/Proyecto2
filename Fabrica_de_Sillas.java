package fabrica_de_sillas;

import java.util.*;

import java.sql.SQLException;
public class Fabrica_de_Sillas {
    public static void main(String[] args) throws SQLException  {
        ConexionBD conexionBD = null;
        Inventario inventario = null;
        ConsultaBD consulta = null;
        Producto producto = new Producto();
        Proceso proceso = null;
        consulta.insertarUsuario(1,"Prueba", 2,"Prueba");
        try {
            // Realiza la conexión a la base de datos
            conexionBD = new ConexionBD("localhost", "3306", "tubasededatos", "root", "S3g23.");
            // Inicializa el inventario
            inventario = new Inventario(conexionBD);
            // Inicializa el proceso
            proceso = new Proceso(inventario, producto);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al conectar a la base de datos.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver Producto");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Vender Silla");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
case 1:
    // Mostrar detalles del producto
    System.out.println("Detalles del Producto:");

    // Pregunta al usuario qué tipo de silla desea ver
    System.out.println("Elija el tipo de silla (Gamer, Comedor, Patio, Oficina, Sencilla):");
    String tipoSilla = scanner.next();

    // Llama a los métodos de la clase Producto para obtener los detalles
    String detalles = producto.obtenerDetallesSilla(tipoSilla);
    String color = producto.obtenerColorSilla(tipoSilla);
    String material = producto.obtenerMaterialSilla(tipoSilla);

    // Muestra los detalles
    System.out.println("Tipo de silla: " + tipoSilla);
    System.out.println("Detalles: " + detalles);
    System.out.println("Colores disponibles: " + color);
    System.out.println("Material: " + material);
    break;
case 2:
    // Mostrar cantidad de sillas y materiales disponibles
    System.out.println("Inventario:");

    // Puedes llamar a métodos de la clase Inventario para obtener las cantidades
    System.out.println("Cantidad de sillas Gamer en inventario: " + inventario.getCantidadSilla("Gamer"));
    System.out.println("Cantidad de sillas Comedor en inventario: " + inventario.getCantidadSilla("Comedor"));
    System.out.println("Cantidad de sillas Patio en inventario: " + inventario.getCantidadSilla("Patio"));
    System.out.println("Cantidad de sillas Oficina en inventario: " + inventario.getCantidadSilla("Oficina"));
    System.out.println("Cantidad de sillas Sencilla en inventario: " + inventario.getCantidadSilla("Sencilla"));

    // Aquí debes llamar a métodos para mostrar la cantidad de materiales disponibles
    // Puedes hacerlo de manera similar a cómo se mostró la cantidad de sillas

    break;
case 3:
    // Vender silla
    System.out.println("¿Qué tipo de silla desea?");
    // Lee el tipo de silla
    String tipoSillaVenta = scanner.next();

    System.out.println("¿Cuántas sillas desea?");
    // Lee la cantidad de sillas
    int cantidad = scanner.nextInt();
    consulta.insertarUsuario(1,"Prueba", 2,"Prueba");
    int cantidadDisponible = inventario.getCantidadSilla(tipoSillaVenta);

    if (cantidadDisponible >= cantidad) {
        // Hay suficientes sillas en el inventario
        System.out.println("¡Venta realizada!");

        // Pide los datos de facturación
        System.out.println("Ingrese los datos para facturar:");
        System.out.println("Nombre del cliente: ");
        String nombreCliente = scanner.next();
        System.out.println("Dirección del cliente: ");
        String direccionCliente = scanner.next();

        // Calcula el costo total
        //double precioUnitario = producto.obtenerPrecio(tipoSilla);
        //double costoTotal = precioUnitario * cantidad;

        // Guarda la factura en la base de datos
        //Factura factura = new Factura(tipoSilla, cantidad, precioUnitario, costoTotal);
        //factura.guardarEnBaseDeDatos(conexionBD);

        System.out.println("Venta realizada y factura guardada en la base de datos.");
    } else {
        // No hay suficientes sillas en el inventario
        //System.out.println("No hay suficientes sillas " + tipoSilla + " en el inventario.");
        //System.out.println("¿Desea fabricar " + cantidad + " sillas " + tipoSilla + "? (Sí/No)");
        //String respuesta = scanner.next().toLowerCase().trim();
        //if (respuesta.equals("si")) {
            System.out.println("¿De qué material desea fabricar las sillas? (Madera/Plástico/Metal/Tela)");
            String materialVenta = scanner.next();
            System.out.println("¿De qué color desea las sillas? ");
            String colorVenta = scanner.next();
            // Puedes agregar más preguntas según tus necesidades

            // Aquí puedes llamar al proceso de fabricación y obtener el costo total de la fabricación
            //double costoTotalFabricacion = proceso.fabricarSilla(tipoSilla, cantidad, producto, material, color);

            // Pide los datos de facturación
            System.out.println("Ingrese los datos para facturar:");
            System.out.println("Nombre del cliente: ");
            String nombreCliente = scanner.next();
            System.out.println("Dirección del cliente: ");
            String direccionCliente = scanner.next();

            // Calcula el costo total
            //double precioUnitario = producto.obtenerPrecio(tipoSilla);
            //double costoTotal = costoTotalFabricacion;

            // Guarda la factura en la base de datos
            //Factura factura = new Factura(tipoSilla, cantidad, precioUnitario, costoTotal);
            //factura.guardarEnBaseDeDatos(conexionBD);

            System.out.println("Venta realizada y factura guardada en la base de datos.");
        //} else {
            System.out.println("Venta cancelada.");
        }
    }
    break;
                //case 4:
                    // Salir del programa
                    //System.out.println("Saliendo...");
                    // Cierra la conexión a la base de datos
                    //try {
                        //if (conexionBD != null) {
                            //conexionBD.cerrar();
                        //}
                    //} catch (SQLException e) {
                        //e.printStackTrace();
                        //System.out.println("Error al cerrar la conexión a la base de datos.");
                    //}
                    //System.exit(0);
                    //break;
                //default:
                    //System.out.println("Opción no válida. Por favor, elige nuevamente.");
            }
        }
    }
//}

   
