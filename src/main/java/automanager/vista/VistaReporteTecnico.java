package automanager.vista;

import automanager.controlador.ControladorReporteTecnico;
import java.util.Map;
import java.util.Scanner;

public class VistaReporteTecnico {
    
    private ControladorReporteTecnico controlador;
    private Scanner scanner;

    public VistaReporteTecnico(ControladorReporteTecnico controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    public void iniciar() {
        System.out.println("\n--- Reporte de Ingresos por Técnico ---");
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        System.out.print("Ingrese el mes: ");
        int mes = scanner.nextInt();

        Map<String, Double> reporte = controlador.generarReporteTecnico(mes, anio);

        System.out.printf("%-30s %-10s\n", "Técnico", "Total");
        System.out.println("-------------------------------------------");
        for (Map.Entry<String, Double> entry : reporte.entrySet()) {
            System.out.printf("%-30s $%.2f\n", entry.getKey(), entry.getValue());
        }
    }

}
