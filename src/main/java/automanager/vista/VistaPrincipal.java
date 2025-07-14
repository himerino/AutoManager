package automanager.vista;

import automanager.Sistema;
import automanager.controlador.*;

import java.util.Scanner;

public class VistaPrincipal {

    private Scanner scanner;
    private Sistema sistema; 

    public VistaPrincipal(Sistema sistema) {
        this.sistema=sistema; // Para poder acceder a la instancia de sistema creada en la clase Main
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    // Método para poder navegar entre las opciones del menú 
    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("Administrar clientes...");
                    ControladorCliente controladorCliente = new ControladorCliente(sistema);
                    new VistaCliente(controladorCliente);
                    break;
                case 2:
                    System.out.println("Administrar proveedores...");
                    ControladorProveedor controladorProveedor = new ControladorProveedor(sistema);
                    new VistaProveedor(controladorProveedor);
                    break;
                case 3:
                    System.out.println("Administrar técnicos...");
                    ControladorTecnico controladorTecnico = new ControladorTecnico(sistema);
                    new VistaTecnico(controladorTecnico);
                    break;
                case 4:
                    System.out.println("Administrar servicios...");
                    ControladorServicio controladorServicio = new ControladorServicio(sistema);
                    new VistaServicio(controladorServicio);
                    break;
                case 5:
                    System.out.println("Generar orden de servicios...");
                    ControladorOrdenServicio controladorOrdenServicio = new ControladorOrdenServicio(sistema);
                    new VistaOrdenServicio(controladorOrdenServicio);
                    break;
                case 6:
                    System.out.println("Registrar falta de insumos...");
                    ControladorFaltaInsumo controladorFaltaInsumo = new ControladorFaltaInsumo(sistema);
                    new VistaFaltaInsumo(controladorFaltaInsumo);
                    break;
                case 7:
                    System.out.println("Generar facturas a empresas...");
                    ControladorFactura controladorFactura= new ControladorFactura(sistema);
                    new VistaFactura(controladorFactura);
                    break;
                case 8:
                    System.out.println("Reporte de ingresos por servicios...");
                    ControladorReporteServicio controladorReporteServicio = new ControladorReporteServicio(sistema);
                    new VistaReporteServicio(controladorReporteServicio);
                    break;
                case 9:
                    System.out.println("Reporte de atenciones por técnico...");
                    ControladorReporteTecnico controladorReporteTecnico = new ControladorReporteTecnico(sistema);
                    new VistaReporteTecnico(controladorReporteTecnico);
                    break;
                case 10:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 10);
        scanner.close();
    }

    // Mostrar el menú     
    private void mostrarMenu() {
        System.out.println("\n========= MENÚ PRINCIPAL =========");
        System.out.println();
        System.out.println("1. Administrar clientes");
        System.out.println("2. Administrar proveedores");
        System.out.println("3. Administrar técnicos");
        System.out.println("4. Administrar servicios");
        System.out.println("5. Generar orden de servicios");
        System.out.println("6. Registrar falta de insumos");
        System.out.println("7. Generar facturas a empresas");
        System.out.println("8. Reporte de ingresos por servicios");
        System.out.println("9. Reporte de atenciones por técnico");
        System.out.println("10. Salir");
        System.out.println();
        System.out.print("Seleccione una opción: ");
    }

}
