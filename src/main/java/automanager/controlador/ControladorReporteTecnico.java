package automanager.controlador;

import automanager.modelo.OrdenServicio;
import automanager.modelo.Sistema;

import java.util.*;

public class ControladorReporteTecnico {
    
    private Sistema sistema;

    public ControladorReporteTecnico(Sistema sistema) {
        this.sistema = sistema;
    }

    public Map<String, Double> generarReporteTecnico(int mes, int anio) {
        Map<String, Double> ingresosPorTecnico = new HashMap<>();

        for (OrdenServicio orden : sistema.getOrdenes()) {
            if (orden.getFecha().getMonthValue() == mes && orden.getFecha().getYear() == anio) {
                String nombreTecnico = orden.getTecnico().getNombre();
                double total = orden.calcularTotal();
                ingresosPorTecnico.put(nombreTecnico, ingresosPorTecnico.getOrDefault(nombreTecnico, 0.0) + total);
            }
        }
        return ingresosPorTecnico;
    }

}
