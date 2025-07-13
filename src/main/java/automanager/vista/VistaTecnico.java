package automanager.vista;

import automanager.controlador.ControladorTecnico;
import automanager.modelo.Tecnico;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaTecnico {
    private ControladorTecnico controlador;
    private Scanner scanner;

    public VistaTecnico(ControladorTecnico controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarTecnicos();
            mostrarSubmenu();
            opcion = scanner.nextInt();
            System.out.println();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarTecnico();
                    break;
                case 2:
                    eliminarTecnico();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private void mostrarTecnicos() {
        ArrayList<Tecnico> tecnicos = controlador.getListaTecnicos();
        if (tecnicos.isEmpty()) {
            System.out.println("\nNo hay técnicos registrados.\n");
        } else {
            System.out.printf("\n%-15s %-20s %-15s %-25s\n", "Identificación", "Nombre", "Teléfono", "Especialidad");
            System.out.println("-".repeat(80));
            for (Tecnico t : tecnicos) {
                System.out.printf("%-15s %-20s %-15s %-25s\n",
                        t.getId(), t.getNombre(), t.getTelefono(), t.getEspecialidad());
            }
            System.out.println();
        }
    }

    private void mostrarSubmenu() {
        System.out.println("===== Menú de Técnicos =====");
        System.out.println();
        System.out.println("1. Agregar Técnico");
        System.out.println("2. Eliminar Técnico");
        System.out.println("3. Regresar al menú principal");
        System.out.println();
        System.out.print("\nSeleccione una opción: ");
    }

    private void agregarTecnico() {
        System.out.print("Identificación: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        MensajeUsuario mensaje = controlador.agregarTecnico(id, nombre, telefono, especialidad);
        if (mensaje != null) {
            mostrarMensaje(mensaje.toString());
        } else {
            mostrarMensaje("Técnico agregado exitosamente.");
        }
    }

    private void eliminarTecnico() {
        System.out.print("Ingrese la identificación del técnico a eliminar: ");
        String id = scanner.nextLine();
        Tecnico tecnico = controlador.buscarTecnicoPorId(id);

        if (tecnico == null) {
            mostrarMensaje("No se encontró un técnico con esa identificación.");
        }else{
            System.out.println("\nTécnico encontrado:");
            System.out.println();
            System.out.printf("Nombre: %s\nTeléfono: %s\nEspecialidad: %s\n", 
            tecnico.getNombre(), tecnico.getTelefono(), tecnico.getEspecialidad());
            System.out.println();
            System.out.print("¿Está seguro que desea eliminar este técnico? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                controlador.eliminarTecnico(id);
                mostrarMensaje("Técnico eliminado exitosamente.");
            } else {
                mostrarMensaje("Operación cancelada.");
            }
        }
    }

    private void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje + "\n");
    }
}
