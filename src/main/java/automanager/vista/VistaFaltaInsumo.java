package automanager.vista;

import automanager.controlador.ControladorFaltaInsumo;
import automanager.modelo.Proveedor;

import java.util.Scanner;

public class VistaFaltaInsumo {

    private ControladorFaltaInsumo controlador;
    private Scanner scanner;

    public VistaFaltaInsumo(ControladorFaltaInsumo controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    // Pedir datos al usuario para registrar la falta de insumos en el sitema a traves del controlador
    public void iniciar() {
        System.out.println("\n--- REGISTRAR FALTA DE INSUMOS ---");
        System.out.println();

        System.out.print("Ingrese descripción del insumo faltante: ");
        String descripcion = scanner.nextLine();
        System.out.println("Seleccione proveedor:");
        System.out.println();
        mostrarProveedores();
        
        System.out.print("Ingrese la identificación del proveedor: ");
        String idProveedor = scanner.nextLine();
        System.out.println();

        MensajeUsuario mensaje = controlador.registrarFalta(descripcion, idProveedor);
        if (mensaje != null) {
            mostrarMensaje(mensaje.toString());
        } else {
            mostrarMensaje("Falta de insumo registrada exitosamente.");
        }
    }

    // Mostrar la lista de proveedores del sistema
    public void mostrarProveedores(){
        System.out.printf("\n%-15s %-20s %-15s %-30s\n", "Identificación", "Nombre", "Teléfono", "Descripción");
        System.out.println("-".repeat(85));
        for (Proveedor p : controlador.getProveedores()) {
            System.out.printf("%-15s %-20s %-15s %-30s\n",
                p.getId(), p.getNombre(), p.getTelefono(), p.getDescripcion());
        }
        System.out.println();
    }

    // Sirve para mostrar mensajes al cliente
    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}

