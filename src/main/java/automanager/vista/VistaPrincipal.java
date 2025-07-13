package automanager.vista;

import automanager.Sistema;
import automanager.controlador.*;

import java.util.Scanner;

public class VistaPrincipal {

    private Scanner scanner;
    private Sistema sistema;

    public VistaPrincipal(Sistema sistema) {
        this.sistema=sistema;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("Administrar clientes...");
                    ControladorCliente cc = new ControladorCliente(sistema);
                    new VistaCliente(cc);
                    break;
                case 2:
                    System.out.println("Administrar proveedores...");
                    ControladorProveedor cp = new ControladorProveedor(sistema);
                    new VistaProveedor(cp);
                    break;
                case 3:
                    System.out.println("Administrar técnicos...");
                    ControladorTecnico ct = new ControladorTecnico(sistema);
                    new VistaTecnico(ct);
                    break;
                case 4:
                    System.out.println("Administrar servicios...");
                    ControladorServicio cs = new ControladorServicio(sistema);
                    new VistaServicio(cs);
                    break;
                case 5:
                    System.out.println("Generar orden de servicios...");
                    ControladorOrdenServicio co = new ControladorOrdenServicio(sistema);
                    new VistaOrdenServicio(co);
                    break;
                case 6:
                    System.out.println("Registrar falta de insumos...");
                    // llamar a VistaFaltaInsumo
                    break;
                case 7:
                    System.out.println("Generar facturas a empresas...");
                    ControladorFactura cf= new ControladorFactura(sistema);
                    new VistaFactura(cf);
                    break;
                case 8:
                    System.out.println("Reporte de ingresos por servicios...");
                    ControladorReporteServicio crs = new ControladorReporteServicio(sistema);
                    new VistaReporteServicio(crs);
                    break;
                case 9:
                    System.out.println("Reporte de atenciones por técnico...");
                    ControladorReporteTecnico crt = new ControladorReporteTecnico(sistema);
                    new VistaReporteTecnico(crt);
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
