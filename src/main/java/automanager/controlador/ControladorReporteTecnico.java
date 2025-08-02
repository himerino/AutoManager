package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.OrdenServicio;
import automanager.modelo.Tecnico; 
import java.util.*;

public class ControladorReporteTecnico {
    
    private Sistema sistema;

    public ControladorReporteTecnico(Sistema sistema) {
        this.sistema = sistema; // Para poder acceder a la instancia del sistema creada en la clase Main
    }

    // Generar el reporte de atenciones por tecnicos correspondientes al mes y año ingresados por el usuario en la clase VistaReporteTecnio

    
    public Map<String, Double> generarReporteTecnico(int mes, int anio) {
        Map<String, Double> ingresosPorTecnico = new HashMap<>();

        // AQUI SE CAMBIA PARA QUE SE MUESTREN TODOS LOS TECNICOS ASI NO TENGA ORDENES PARA ESE MES Y AÑO

        for (Tecnico tecnico : sistema.getTecnicos()){
            String nombreTecnico = tecnico.getNombre();
            double total = 0.0;

            for (OrdenServicio orden : sistema.getOrdenes()) {
                if (orden.getFecha().getMonthValue() == mes && 
                    orden.getFecha().getYear() == anio && 
                    (orden.getTecnico().getNombre()).equals(nombreTecnico)) {
                    total += orden.calcularTotal();}
            }

            ingresosPorTecnico.put(nombreTecnico, ingresosPorTecnico.getOrDefault(nombreTecnico, 0.0) + total);
        }

        // ESTE BLOQUE YA NO VA
        /* 
        for (OrdenServicio orden : sistema.getOrdenes()) {
            if (orden.getFecha().getMonthValue() == mes && orden.getFecha().getYear() == anio) {
                String nombreTecnico = orden.getTecnico().getNombre();
                double total = orden.calcularTotal();
                ingresosPorTecnico.put(nombreTecnico, ingresosPorTecnico.getOrDefault(nombreTecnico, 0.0) + total);
            }
        }*/

        return ingresosPorTecnico;
    }

}
