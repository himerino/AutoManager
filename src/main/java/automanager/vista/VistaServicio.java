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
        iniciar();
    }
    
    public void iniciar() {
        int opcion;
        do {
            mostrarServicios();
            mostrarSubmenu();
            opcion = scanner.nextInt();
            System.out.println();
            scanner.nextLine();

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

    private void mostrarSubmenu(){
        System.out.println("===== Menú de Servicios =====");
            System.out.println();
            System.out.println("1. Agregar Servicio");
            System.out.println("2. Editar Servicio");
            System.out.println("3. Regresar al menú principal");
            System.out.println();
            System.out.print("Seleccione una opción: ");
    }

    private void mostrarServicios() {
        ArrayList<Servicio> servicios = controlador.getListaServicios();
        if (servicios.isEmpty()) {
            System.out.println("\nNo hay servicios registrados.\n");
            return;
        }
        System.out.printf("\n%-10s %-25s %-10s\n", "Código", "Nombre", "Precio");
        System.out.println("-".repeat(45));
        for (Servicio s : servicios) {
            System.out.printf("%-10s %-25s $%.2f\n", s.getCodigo(), s.getNombre(), s.getPrecioActual());
        }
        System.out.println();
    }

    private void agregarServicio() {
        System.out.print("Nombre del servicio: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio del servicio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        MensajeUsuario mensaje = controlador.agregarServicio(nombre, precio);
        if (mensaje != null){
            mostrarMensaje(mensaje.toString());
        }else{
            mostrarMensaje("Servicio agregado exitosamente.");
        }
    }
    
    private void editarServicio() {
        System.out.print("Ingrese el código del servicio: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el nuevo precio: ");
        double nuevoPrecio = Double.parseDouble(scanner.nextLine());

        MensajeUsuario mensaje = controlador.editarPrecioServicio(codigo, nuevoPrecio);
        if (mensaje != null){
            mostrarMensaje(mensaje.toString());
        }else{
            System.out.println("Precio actualizado correctamente.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
