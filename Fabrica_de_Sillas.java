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
               /*ConexionBD conexionBD = null;
        Scanner scanner = new Scanner(System.in);

        try {
            conexionBD = new ConexionBD("localhost", "3306", "tubasededatos", "root", "S3g23.");

            Producto producto = new Producto();
            Inventario inventario = new Inventario(conexionBD);
            Proceso proceso = new Proceso(inventario, producto);

            while (true) {
                System.out.println("--------------------------------------");
                System.out.println("| Bienvenido a la Fábrica de Sillas   |");
                System.out.println("| Elija una opción:                   |");
                System.out.println("| 1. Ver Producto                     |");
                System.out.println("| 2. Ver Inventario                   |");
                System.out.println("| 3. Vender Silla                     |");
                System.out.println("| 4. Salir                            |");
                System.out.println("--------------------------------------");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        System.out.println("Detalles de los Productos Disponibles:");
                        for (String tipoSilla : producto.getPrecios().keySet()) {
                            double precio = producto.obtenerPrecio(tipoSilla);

                            System.out.println("Tipo de Silla: " + tipoSilla);
                            System.out.println("Precio: Q" + precio);
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.println("Inventario de Sillas:");
                        System.out.println("Tipo de silla - Cantidad");
                        for (String tipoSilla : inventario.tiposSillas.keySet()) {
                            int cantidad = inventario.getCantidadSilla(tipoSilla);
                            System.out.println(tipoSilla + " - " + cantidad);
                        }

                        System.out.println("Inventario de Materiales:");
                        System.out.println("Material - Cantidad");
                        for (String material : inventario.materiales.keySet()) {
                            int cantidad = inventario.getCantidadMaterial(material);
                            System.out.println(material + " - " + cantidad);
                        }
                        break;
                       /* case 3:
    System.out.println("Venta de Silla:");
    System.out.println("Elija el tipo de silla a vender:");
    for (String tipoSilla : producto.getPrecios().keySet()) {
        System.out.println(producto.obtenerPrecio(tipoSilla) + ". " + tipoSilla);
    }

    int opcionSilla = scanner.nextInt();
    scanner.nextLine(); // Consumir la nueva línea

    String tipoSilla = "";
    double precioSilla = 0.0;

    for (String tipo : producto.getPrecios().keySet()) {
        if (producto.obtenerPrecio(tipo) == opcionSilla) {
            tipoSilla = tipo;
            precioSilla = producto.obtenerPrecio(tipo);
        }
    }

    System.out.println("Ingrese la cantidad de sillas a vender:");
    int cantidad = scanner.nextInt();
    scanner.nextLine(); // Consumir la nueva línea

    if (inventario.getCantidadSilla(tipoSilla) >= cantidad) {
        // Suficientes sillas disponibles en el inventario.
        inventario.actualizarCantidadSilla(tipoSilla, -cantidad);

        // Aquí solicitamos los datos del cliente.
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();

        System.out.println("Ingrese la dirección del cliente:");
        String direccionCliente = scanner.nextLine();

        // Calcular el costo total.
        double costoTotal = precioSilla * cantidad;

        // Creamos la factura.
        Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);

        // Mostrar y guardar la factura en la base de datos.
        System.out.println("¡Venta realizada!");
        factura.imprimirFactura();
        factura.guardarEnBaseDeDatos(conexionBD, nombreCliente, direccionCliente);
    } else {
        System.out.println("No hay suficientes sillas en el inventario.");

        // Preguntar si se desean fabricar las sillas faltantes
        System.out.println("¿Desea fabricar las sillas faltantes? (Sí/No)");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        if (respuesta.equals("si")) {
            proceso.fabricarSilla(tipoSilla, cantidad, producto);

            // Aquí solicitamos los datos del cliente después de la fabricación.
            System.out.println("Ingrese el nombre del cliente:");
            String nombreCliente = scanner.nextLine();

            System.out.println("Ingrese la dirección del cliente:");
            String direccionCliente = scanner.nextLine();

            // Calcular el costo total después de la fabricación.
            double costoTotal = precioSilla * cantidad;

            // Creamos la factura.
            Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);

            // Mostrar y guardar la factura en la base de datos.
            System.out.println("¡Venta realizada!");
            factura.imprimirFactura();
            factura.guardarEnBaseDeDatos(conexionBD, nombreCliente, direccionCliente);
        } else {
            System.out.println("Venta cancelada.");
        }
    }
    break;*/
                    /*case 3:
                        System.out.println("Venta de Silla:");
                        System.out.println("Elija el tipo de silla a vender:");
                        for (String tipoSilla : producto.getPrecios().keySet()) {
                            System.out.println(producto.obtenerPrecio(tipoSilla) + ". " + tipoSilla);
                        }

                        int opcionSilla = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea

                        String tipoSilla = "";
                        double precioSilla = 0.0;

                        for (String tipo : producto.getPrecios().keySet()) {
                            if (producto.obtenerPrecio(tipo) == opcionSilla) {
                                tipoSilla = tipo;
                                precioSilla = producto.obtenerPrecio(tipo);
                            }
                        }

                        System.out.println("Ingrese la cantidad de sillas a vender:");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea

                        if (inventario.getCantidadSilla(tipoSilla) >= cantidad) {
                            // Suficientes sillas disponibles en el inventario.
                            inventario.actualizarCantidadSilla(tipoSilla, -cantidad);
                        } else {
                            System.out.println("No hay suficientes sillas en el inventario.");

                            // Preguntar si se desean fabricar las sillas faltantes
                            System.out.println("¿Desea fabricar las sillas faltantes? (Sí/No)");
                            String respuesta = scanner.nextLine().trim().toLowerCase();
                            if (respuesta.equals("si")) {
                                proceso.fabricarSilla(tipoSilla, cantidad, producto);

                                System.out.println("¡Sillas fabricadas!");
                            } else {
                                System.out.println("Venta cancelada.");
                                break;
                            }
                        }

                        // Aquí podrías solicitar los datos para facturar y guardarlos en la base de datos.
                        // Ejemplo: Nombre del cliente, dirección, etc.
                        // Luego, puedes calcular el costo total.
                      //  double precioSilla=producto.obtenerPrecio(tipoSilla);
                        double costoTotal=precioSilla*cantidad;
                        Factura factura = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);
                        // Guardar factura en la base de datos

                        System.out.println("¡Venta realizada!");
                        break;
                    case 4:
                        System.out.println("¡Gracias por visitar la Fábrica de Sillas!");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, elija nuevamente.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conexionBD != null) {
                conexionBD.cerrar();
            }
        }
    }*/
    //}
       /* ConexionBD conexionBD = null;
        Scanner scanner = new Scanner(System.in);
        
        List<Factura> facturas = new ArrayList<>();
        
        try{
            conexionBD = new ConexionBD("localhost", "3306", "tubasededatos", "root", "S3g23.");

            // Crear instancias de las clases que interactuarán con la base de datos
            Producto producto = new Producto();
            Inventario inventario = new Inventario(conexionBD);
            Proceso proceso = new Proceso(inventario, producto); 
            Venta venta = new Venta(conexionBD, tipoSilla, color, costoTotal, proceso, inventario, producto);
                  
        proceso.insertar(); // Agregar materiales al inventario al inicio del programa

        while (true) {
            System.out.println("--------------------------------------");
            System.out.println("| Bienvenido a la Fábrica de Sillas   |");
            System.out.println("| Elija una opción:                   |");
            System.out.println("| 1. Ver Producto                     |");
            System.out.println("| 2. Ver Inventario                   |");
            System.out.println("| 3. Vender Silla                     |");
            System.out.println("| 4. Salir                            |");
            System.out.println("--------------------------------------");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Detalles de los Productos Disponibles:");
                    for (String tipoSilla : producto.getPrecios().keySet()) {
                        String detalles = producto.obtenerDetallesSilla(tipoSilla);
                        String color=producto.obtenerColorSilla(tipoSilla);
                        String material=producto.obtenerMaterialSilla(tipoSilla);
                        double precio = producto.obtenerPrecio(tipoSilla);

                        System.out.println("Tipo de Silla: " + tipoSilla);
                        System.out.println("Precio: Q" + precio);
                        System.out.println("Color: "+ color);
                        System.out.println("Material: "+ material);
                        System.out.println("Detalles: " + detalles);
                        System.out.println(); // Separador entre productos
                    }
                    break;
                case 2:
                    System.out.println("Inventario de Sillas:");
                    System.out.println("Tipo de silla - Cantidad");

                    // Recorre los tipos de sillas disponibles e imprime su cantidad en el inventario.
                    for (String tipoSilla : inventario.tiposSillas.keySet()) {
                        int cantidad = inventario.getCantidadSilla(tipoSilla);
                        System.out.println(tipoSilla + " - " + cantidad);
                    }

                    System.out.println("Inventario de Materiales:");
                    System.out.println("Material - Cantidad");

                    // Recorre los materiales disponibles e imprime su cantidad en el inventario.
                    for (String material : inventario.materiales.keySet()) {
                        int cantidad = inventario.getCantidadMaterial(material);
                        System.out.println(material + " - " + cantidad);
                    }
                    break;
                case 3:
                    System.out.println("Venta de Silla:");
                    System.out.println("Elija el tipo de silla a vender:");
                    System.out.println("1. Gamer");
                    System.out.println("2. Comedor");
                    System.out.println("3. Patio");
                    System.out.println("4. Oficina");
                    System.out.println("5. Sencilla");
                    int opcionSilla = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    String tipoSilla = "";

                    switch (opcionSilla) {
                        case 1:
                            tipoSilla = "Gamer";
                            break;
                        case 2:
                            tipoSilla = "Comedor";
                            break;
                        case 3:
                            tipoSilla = "Patio";
                            break;
                        case 4:
                            tipoSilla = "Oficina";
                            break;
                        case 5:
                            tipoSilla = "Sencilla";
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, elija nuevamente.");
                            continue;
                    }

                    System.out.println("Ingrese la cantidad de sillas a vender:");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    boolean ventaExitosa = venta.venderSilla( tipoSilla, cantidad);

                    if (ventaExitosa) {
                        // Crear una factura antes de la compra
                        double precioSilla = producto.obtenerPrecio(tipoSilla);
                        double costoTotal=precioSilla*cantidad;
                        Factura facturaAntesCompra = new Factura(tipoSilla, cantidad, precioSilla, costoTotal);
                        facturas.add(facturaAntesCompra);
                        System.out.println("¡Venta realizada!");
                    } else {
                        System.out.println("No hay suficientes sillas en el inventario.");

                        // Verificar si se deben fabricar sillas
                        System.out.println("¿Desea fabricar " + cantidad + " sillas " + tipoSilla + "? (Sí/No)");
                        String respuesta = scanner.nextLine().trim().toLowerCase();
                        if (respuesta.equals("si")) {
                            boolean fabricacionExitosa = proceso.fabricarSilla(tipoSilla, cantidad,producto);

                            if (fabricacionExitosa) {
                                System.out.println("¡Venta realizada!");
                            } else {
                                System.out.println("No se pudo realizar la venta.");
                            }
                        } else {
                            System.out.println("Venta cancelada.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("¡Gracias por visitar la Fábrica de Sillas!");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        }
    
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conexionBD != null) {
                conexionBD.cerrar();
            }
        }*/
   