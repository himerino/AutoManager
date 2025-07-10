package automanager.vista;

import automanager.controlador.ControladorCliente;
import automanager.modelo.Cliente;
import automanager.modelo.TipoCliente;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaCliente {

    private ControladorCliente controlador;
    private Scanner sc;

    public VistaCliente(ControladorCliente controlador) {
        this.controlador=controlador;
        this.sc = new Scanner(System.in);
        iniciar();
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarClientes();
            mostrarSubmenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> agregarCliente();
                case 2 -> System.out.println("Regresando al menú principal...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 2);
    }

    private void mostrarClientes() {
        ArrayList<Cliente> clientes = controlador.getListaClientes();
        if (clientes.isEmpty()) {
            System.out.println("\nNo hay clientes registrados.\n");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
            System.out.println();
        }
    }

    private void mostrarSubmenu() {
        System.out.println("===== Menú de Clientes =====");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
    }


    private void agregarCliente() {
        System.out.print("Identificación: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        TipoCliente tipo = leerTipoCliente();

        MensajeUsuario mensaje = controlador.agregarCliente(id, nombre, direccion, telefono, tipo);
        if (mensaje != null) {
            mostrarMensaje(mensaje.toString());
        } else {
            mostrarMensaje("Cliente agregado exitosamente.");
        }
    }


    private TipoCliente leerTipoCliente() {
        while (true) {
            System.out.print("Tipo de cliente (1. PERSONAL, 2. EMPRESARIAL): ");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1 -> { return TipoCliente.PERSONAL; }
                case 2 -> { return TipoCliente.EMPRESARIAL; }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }


    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }


}
