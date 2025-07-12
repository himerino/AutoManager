package automanager.vista;

import automanager.controlador.ControladorFactura;
import automanager.modelo.Factura;

import java.util.Scanner;

public class VistaFactura {
    private ControladorFactura controlador;
    private Scanner scanner;

    public VistaFactura(ControladorFactura controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    public void iniciar() {
        System.out.println("\n--- GENERAR FACTURA EMPRESARIAL ---");
        System.out.println();

        System.out.print("Ingrese la identificación del cliente: ");
        String idCliente = scanner.nextLine();

        System.out.print("Ingrese el año (YYYY): ");
        int anio = scanner.nextInt();

        System.out.print("Ingrese el mes (1-12): ");
        int mes = scanner.nextInt();

        Factura factura = controlador.generarFactura(idCliente, anio, mes);

        System.out.println();
        System.out.println(controlador.generarDetalleFactura(factura));
    }

}
