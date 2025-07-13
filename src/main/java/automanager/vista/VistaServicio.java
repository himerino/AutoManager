package automanager.vista;

import java.util.Scanner;
import java.util.ArrayList;

import automanager.controlador.ControladorServicio;
import automanager.modelo.Servicio;

public class VistaServicio {
    private ControladorServicio controlador;
    private Scanner scanner;

    public VistaServicio(ControladorServicio controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Administración de Servicios ---");
            listarServicios();
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar Servicio");
            System.out.println("2. Editar Servicio");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarServicio();
                    break;
                case 2:
                    editarServicio();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }

    private void listarServicios() {
        ArrayList<Servicio> servicios = controlador.obtenerServicios();
        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados.");
            return;
        }
        System.out.println("\nCódigo | Nombre | Precio");
        for (Servicio s : servicios) {
            System.out.printf("%s | %s | %.2f\n", s.getCodigo(), s.getNombre(), s.getPrecioActual());
        }
    }

    private void agregarServicio() {
        System.out.println("\n--- Agregar Nuevo Servicio ---");
        System.out.print("Nombre del servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del servicio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        Servicio nuevo = controlador.agregarServicio(nombre, precio);
        System.out.println("Servicio agregado exitosamente con código: " + nuevo.getCodigo());
    }

    private void editarServicio() {
        System.out.println("\n--- Editar Servicio (Precio) ---");
        System.out.print("Ingrese el código del servicio: ");
        String codigo = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = Double.parseDouble(scanner.nextLine());

        boolean actualizado = controlador.editarPrecioServicio(codigo, nuevoPrecio);
        if (actualizado) {
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("Servicio no encontrado.");
        }
    }
}
