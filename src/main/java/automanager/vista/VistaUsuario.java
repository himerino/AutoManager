package grupo4.vista;  

public class VistaUsuario {
    public void mostrarMenu() {
        System.out.println("\n===== Menú Principal =====");
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
        System.out.print("Seleccione una opción: ");
    }

    public void administrarClientes() {
        System.out.println("Navegando a: Administrar Clientes...");
    }

    public void administrarProveedores() {
        System.out.println("Navegando a: Administrar Proveedores...");
    }

    public void administrarTecnicos() {
        System.out.println("Navegando a: Administrar Técnicos...");
    }

    public void administrarServicios() {
        System.out.println("Navegando a: Administrar Servicios...");
    }

    public void generarOrdenServicio() {
        System.out.println("Navegando a: Generar Orden de Servicios...");
    }

    public void registrarFaltaInsumo() {
        System.out.println("Navegando a: Registrar Falta de Insumos...");
    }

    public void generarFacturaEmpresarial() {
        System.out.println("Navegando a: Generar Facturas a Empresas...");
    }

    public void mostrarReporteIngresos() {
        System.out.println("Navegando a: Reporte de Ingresos por Servicios...");
    }

    public void mostrarReporteTecnicos() {
        System.out.println("Navegando a: Reporte de Atenciones por Técnico...");
    }


}
