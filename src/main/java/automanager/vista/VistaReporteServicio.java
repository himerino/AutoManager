package automanager.vista;

import automanager.controlador.ControladorReporteServicio;
import java.util.Map;
import java.util.Scanner;

public class VistaReporteServicio {
    
    private ControladorReporteServicio controlador;
    private Scanner scanner;

    public VistaReporteServicio(ControladorReporteServicio controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    public void iniciar() {
        System.out.println("\n--- Reporte de Ingresos por Servicio ---");
        System.out.println();
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = scanner.nextInt();
        System.out.println();

        Map<String, Double> reporte = controlador.generarReporteServicio(mes, anio);

        System.out.printf("%-30s %-10s\n", "Servicio", "Total");
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, Double> entry : reporte.entrySet()) {
            System.out.printf("%-30s $%.2f\n", entry.getKey(), entry.getValue());
        }
    }

}
