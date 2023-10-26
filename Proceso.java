
package fabrica_de_sillas;

import java.util.*;
public class Proceso {
        private Inventario inventario;
    private Producto producto;
    private Scanner scanner = new Scanner(System.in);

    public Proceso(Inventario inventario, Producto producto) {
        this.inventario = inventario;
        this.producto = producto;
    }

    public void insertar() {
        // Agregar materiales al inventario al inicio del programa
        inventario.agregarMaterial("Madera", "Modelo1", 500);
        inventario.agregarMaterial("Plástico", "Modelo2", 500);
        inventario.agregarMaterial("Metal", "Modelo3", 500);
        inventario.agregarMaterial("Tela", "Modelo4", 500);
        inventario.agregarMaterial("Clavos", "Modelo1", 500);
        inventario.agregarMaterial("Tornillos", "Modelo2", 500);
        inventario.agregarMaterial("Pegamento", "Modelo3", 500);
        inventario.agregarMaterial("Pintura", "Modelo4", 500);
    }

    public void fabricarSillas() {
        System.out.println("Bienvenido a la fábrica de sillas");
        while (true) {
            System.out.println("¿Qué tipo de silla deseas fabricar?");
            System.out.println("1. Gamer");
            System.out.println("2. Comedor");
            System.out.println("3. Patio");
            System.out.println("4. Oficina");
            System.out.println("5. Sencilla");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("Saliendo...");
                break;
            }

            String tipoSilla = "";

            switch (opcion) {
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
                    System.out.println("Opción no válida. Por favor, elige nuevamente.");
                    continue;
            }

            System.out.println("¿Cuántas sillas deseas fabricar?");
            int cantidad = scanner.nextInt();

            fabricarSilla(tipoSilla, cantidad);
        }
    }

    public boolean fabricarSilla(String tipoSilla, int cantidad) {
        int cantidadDisponible = inventario.getCantidadSilla(tipoSilla);

        if (cantidadDisponible < cantidad) {
            // No hay suficientes sillas en el inventario, así que verificamos materiales y fabricaremos más.
            if (verificarMaterialesSuficientes(tipoSilla, cantidad)) {
                System.out.println("No hay suficientes sillas en el inventario. Verificando materiales...");

                // Lógica de verificación de materiales
                if (verificarMaterialesSuficientes(tipoSilla, cantidad)) {
                    System.out.println("Materiales suficientes. Fabricando sillas...");

                    System.out.println("Paso 1: Juntando materiales...");
                    sleep(3000);

                    System.out.println("Paso 2: Cortando materiales...");
                    sleep(3000);

                    System.out.println("Paso 3: Ensamblado de la silla...");
                    sleep(3000);

                    System.out.println("Paso 4: Preparando la silla...");
                    sleep(3000);
                } else {
                    System.out.println("No hay suficientes materiales para fabricar las sillas.");
                    return false; // Fabricación fallida debido a la falta de materiales.
                }
            }

            // Actualizar la cantidad de sillas en el inventario después de la fabricación.
            inventario.actualizarCantidadSilla(tipoSilla, cantidad);
        } else {
            // Si hay suficientes sillas en el inventario, no es necesario fabricar.
            System.out.println("Suficientes sillas disponibles en el inventario.");
        }

        // Restar la cantidad solicitada por el usuario.
        inventario.actualizarCantidadSilla(tipoSilla, -cantidad);

        System.out.println(cantidad + " sillas fabricadas.");
        
        // Calcular el costo total de la venta
        double costoTotalVenta = cantidad * producto.obtenerPrecio(tipoSilla);

        return true; // Fabricación exitosa.
    }

    public boolean verificarMaterialesSuficientes(String tipoSilla, int cantidad) {
        // Calcula la cantidad de cada material necesario por silla
        int maderaRequerida = cantidad * calcularMaterialesNecesarios(tipoSilla, "Madera");
        int plasticoRequerido = cantidad * calcularMaterialesNecesarios(tipoSilla, "Plástico");
        int metalRequerido = cantidad * calcularMaterialesNecesarios(tipoSilla, "Metal");
        int telaRequerida = cantidad * calcularMaterialesNecesarios(tipoSilla, "Tela");
        // Y así sucesivamente para los demás materiales...

        // Verifica si hay suficientes materiales en el inventario
        return inventario.getCantidadMaterial("Madera") >= maderaRequerida &&
               inventario.getCantidadMaterial("Plástico") >= plasticoRequerido &&
               inventario.getCantidadMaterial("Metal") >= metalRequerido &&
               inventario.getCantidadMaterial("Tela") >= telaRequerida;
    }

    public int calcularMaterialesNecesarios(String tipoSilla, String material) {
        // Implementa la lógica para calcular la cantidad de materiales necesarios
        // según el tipo de silla
        int cantidadMaterialesNecesarios = 0;

        // Lógica de cálculo por silla...
        if ("Gamer".equals(tipoSilla)) {
            cantidadMaterialesNecesarios = 5; // Ejemplo, ajusta según tus necesidades.
        } else if ("Comedor".equals(tipoSilla)) {
            cantidadMaterialesNecesarios = 6; // Ejemplo, ajusta según tus necesidades.
        } else if ("Patio".equals(tipoSilla)) {
            cantidadMaterialesNecesarios = 4; // Ejemplo, ajusta según tus necesidades.
        } // y así sucesivamente...

        return cantidadMaterialesNecesarios;
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    /*private Inventario inventario;
    private Producto producto;
    private Scanner scanner = new Scanner(System.in);

    public Proceso(Inventario inventario, Producto producto) {
        this.inventario = inventario;
        this.producto = producto;
    }

    public void insertar() {
        // Agregar materiales al inventario al inicio del programa
        inventario.agregarMaterial("Madera", "Modelo1", 500);
        inventario.agregarMaterial("Plástico", "Modelo2", 500);
        inventario.agregarMaterial("Metal", "Modelo3", 500);
        inventario.agregarMaterial("Tela", "Modelo4", 500);
        inventario.agregarMaterial("Clavos", "Modelo1", 500);
        inventario.agregarMaterial("Tornillos", "Modelo2", 500);
        inventario.agregarMaterial("Pegamento", "Modelo3", 500);
        inventario.agregarMaterial("Pintura", "Modelo4", 500);
    }

    public void fabricarSillas() {
        System.out.println("Bienvenido a la fábrica de sillas");
        while (true) {
            System.out.println("¿Qué tipo de silla deseas fabricar?");
            System.out.println("1. Gamer");
            System.out.println("2. Comedor");
            System.out.println("3. Patio");
            System.out.println("4. Oficina");
            System.out.println("5. Sencilla");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();

            if (opcion == 6) {
                System.out.println("Saliendo...");
                break;
            }

            String tipoSilla = "";

            switch (opcion) {
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
                    System.out.println("Opción no válida. Por favor, elige nuevamente.");
                    continue;
            }

            System.out.println("¿Cuántas sillas deseas fabricar?");
            int cantidad = scanner.nextInt();

            fabricarSilla(tipoSilla, cantidad,producto);
        }
    }
    
public boolean fabricarSilla(String tipoSilla, int cantidad, Producto producto) {
    int cantidadDisponible = inventario.getCantidadSilla(tipoSilla);

    if (cantidadDisponible < cantidad) {
        // No hay suficientes sillas en el inventario, así que verificamos materiales y fabricaremos más.
        if (verificarMaterialesSuficientes(tipoSilla, cantidad)) {
            System.out.println("No hay suficientes sillas en el inventario. Verificando materiales...");

            // Lógica de verificación de materiales
            if (verificarMaterialesSuficientes(tipoSilla, cantidad)) {
                System.out.println("Materiales suficientes. Fabricando sillas...");

                System.out.println("Paso 1: Juntando materiales...");
                sleep(3000);

                System.out.println("Paso 2: Cortando materiales...");
                sleep(3000);

                System.out.println("Paso 3: Ensamblado de la silla...");
                sleep(3000);

                System.out.println("Paso 4: Preparando la silla...");
                sleep(3000);
            } else {
                System.out.println("No hay suficientes materiales para fabricar las sillas.");
                return false; // Fabricación fallida debido a la falta de materiales.
            }
        }

        // Actualizar la cantidad de sillas en el inventario después de la fabricación.
        inventario.actualizarCantidadSilla(tipoSilla, cantidad);
    } else {
        // Si hay suficientes sillas en el inventario, no es necesario fabricar.
        System.out.println("Suficientes sillas disponibles en el inventario.");
    }

    // Restar la cantidad solicitada por el usuario.
    inventario.actualizarCantidadSilla(tipoSilla, -cantidad);

    System.out.println(cantidad + " sillas fabricadas.");

    return true; // Fabricación exitosa.
}
    

    
public boolean verificarMaterialesSuficientes(String tipoSilla, int cantidad) {
    // Calcula la cantidad de cada material necesario por silla
    int maderaRequerida = cantidad * calcularMaterialesNecesarios(tipoSilla, "Madera");
    int plasticoRequerido = cantidad * calcularMaterialesNecesarios(tipoSilla, "Plástico");
    int metalRequerido = cantidad * calcularMaterialesNecesarios(tipoSilla, "Metal");
    int telaRequerida = cantidad * calcularMaterialesNecesarios(tipoSilla, "Tela");
    // Y así sucesivamente para los demás materiales...

    // Verifica si hay suficientes materiales en el inventario
    return inventario.getCantidadMaterial("Madera") >= maderaRequerida &&
           inventario.getCantidadMaterial("Plástico") >= plasticoRequerido &&
           inventario.getCantidadMaterial("Metal") >= metalRequerido &&
           inventario.getCantidadMaterial("Tela") >= telaRequerida;
}



    public int calcularMaterialesNecesarios(String tipoSilla, String material) {
        // Implementa la lógica para calcular la cantidad de materiales necesarios
        // según el tipo de silla
        int cantidadMaterialesNecesarios = 0;

        // Lógica de cálculo por silla...
        if ("Gamer".equals(tipoSilla)) {
            cantidadMaterialesNecesarios = 5; // Ejemplo, ajusta según tus necesidades.
        } else if ("Comedor".equals(tipoSilla)) {
            cantidadMaterialesNecesarios = 6; // Ejemplo, ajusta según tus necesidades.
        } else if ("Patio".equals(tipoSilla)) {
            cantidadMaterialesNecesarios = 4; // Ejemplo, ajusta según tus necesidades.
        } // y así sucesivamente...

        return cantidadMaterialesNecesarios;
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}*/
    


