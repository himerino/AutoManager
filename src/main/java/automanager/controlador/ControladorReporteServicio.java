package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.OrdenServicio;
import automanager.modelo.Servicio;

import java.util.*;

public class ControladorReporteServicio {
    
    private Sistema sistema; 

    public ControladorReporteServicio(Sistema sistema) {
        this.sistema = sistema; // Para poder acceder a la instancia del sistema creada en la clase Main
    }

    // Generar el reporte de ingresos por servicios correspondientes al mes y año ingresados por el usuario en la clase VistaReporteServicio
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
