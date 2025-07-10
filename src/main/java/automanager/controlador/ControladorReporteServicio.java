package automanager.controlador;

import automanager.modelo.OrdenServicio;
import automanager.modelo.Servicio;
import automanager.modelo.Sistema;

import java.util.*;

public class ControladorReporteServicio {
    private Sistema sistema;
    public ControladorReporteServicio(Sistema sistema) {
        this.sistema = sistema;
    }

    public Map<String, Double> generarReporteServicio(int mes, int anio) {
        Map<String, Double> ingresosPorServicio = new HashMap<>();

        for (OrdenServicio orden : sistema.getOrdenes()) {
            if (orden.getFecha().getMonthValue() == mes && orden.getFecha().getYear() == anio) {
                orden.getItems().forEach(item -> {
                    Servicio s = item.getServicio();
                    String nombre = s.getNombre();
                    double subtotal = item.calcularSubtotal();
                    ingresosPorServicio.put(nombre, ingresosPorServicio.getOrDefault(nombre, 0.0) + subtotal);
                });
            }
        }
        return ingresosPorServicio;
    }

}
