package automanager.vista;

import automanager.controlador.ControladorProveedor;
import automanager.modelo.Proveedor;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaProveedor {

    private ControladorProveedor controlador;
    private Scanner scanner;

    public VistaProveedor(ControladorProveedor controlador) {
        this.controlador = controlador; // Para poder acceder a la instancia de controlador de proveedor creada en la clase VistaPrincipal 
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    // Metodo para poder navegar entre las opciones para administrar proveedores
    public void iniciar() {
        int opcion;
        do {
            mostrarProveedores();
            mostrarSubmenu();
            opcion = scanner.nextInt();
            System.out.println();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarProveedor();
                case 2 -> System.out.println("Regresando al menú principal...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 2);
    }

    // Mostrar los proveedores existentes en el sistema
    private void mostrarProveedores() {
        ArrayList<Proveedor> proveedores = controlador.getListaProveedores();
        if (proveedores.isEmpty()) {
            System.out.println("\nNo hay proveedores registrados.\n");
        } else {
            System.out.printf("\n%-15s %-20s %-15s %-30s\n", "Identificación", "Nombre", "Teléfono", "Descripción");
            System.out.println("-".repeat(85));
            for (Proveedor p : proveedores) {
                System.out.printf("%-15s %-20s %-15s %-30s\n",
                        p.getId(), p.getNombre(), p.getTelefono(), p.getDescripcion());
            }
            System.out.println();
        }
    }

    // Mostrar submenu de las opciones para administrar proveedores
    private void mostrarSubmenu() {
        System.out.println("===== Menú de Proveedores =====");
        System.out.println();
        System.out.println("1. Agregar Proveedor");
        System.out.println("2. Regresar al menú principal");
        System.out.println();
        System.out.print("\nSeleccione una opción: ");
    }

    // Pedir datos al usuario para agregar proveedor al sistema a traves del controlador del porveedor
    private void agregarProveedor() {
        System.out.print("Identificación: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        MensajeUsuario mensaje = controlador.agregarProveedor(id, nombre, telefono, descripcion);
        if (mensaje != null) {
            mostrarMensaje(mensaje.toString());
        } else {
            mostrarMensaje("Proveedor agregado exitosamente.");
        }
    }

    // Mostrar mensaje al usuario
    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
