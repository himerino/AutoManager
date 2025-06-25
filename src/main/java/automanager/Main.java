package automanager;
import java.util.Scanner;

import automanager.vista.VistaUsuario;

public class Main {
    public static void main(String[] args) {
        VistaUsuario vista = new VistaUsuario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // consumir el salto de línea

            switch (opcion) {
                case 1 -> vista.administrarClientes();
        	case 2 -> vista.administrarProveedores();
        	case 3 -> vista.administrarTecnicos();
        	case 4 -> vista.administrarServicios();
        	case 5 -> vista.generarOrdenServicio();
        	case 6 -> vista.registrarFaltaInsumo();
        	case 7 -> vista.generarFacturaEmpresarial();
        	case 8 -> vista.mostrarReporteIngresos();
        	case 9 -> vista.mostrarReporteTecnicos();
        	case 10 -> System.out.println("Saliendo de la aplicación...");
        	default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
	    System.out.println();

        } while (opcion != 10);

        scanner.close();
    }
}