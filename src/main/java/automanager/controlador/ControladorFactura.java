package automanager.controlador;

import automanager.modelo.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControladorFactura {
    private Sistema sistema;

    public ControladorFactura(Sistema sistema) {
        this.sistema= sistema;
    }

    public Factura generarFactura(String idCliente, int anio, int mes) {
        Factura factura=null;

        for (OrdenServicio orden : sistema.getOrdenes()) {
            if (orden.getCliente().getId().equals(idCliente) &&
                orden.getFecha().getYear() == anio &&
                orden.getFecha().getMonthValue() == mes) {
                
                if (orden.getCliente().getTipo() != TipoCliente.EMPRESARIAL) return null;
                factura = new Factura(orden.getCliente(), LocalDate.of(anio, mes,orden.getFecha().getDayOfMonth()));
                factura.agregarOrden(orden);
            }
        }

        return factura;
    }

    public String generarDetalleFactura(Factura factura) {
        if (factura == null) {
            return "No se encontraron órdenes para ese cliente empresarial en el período especificado.";
        }

        StringBuilder detalle = new StringBuilder();
        detalle.append("Empresa: ").append(factura.getCliente().getNombre()).append("\n");
        detalle.append("Periodo de facturación: ").append(
                factura.getFechaEmision().getMonth().name().substring(0, 1)
                        + factura.getFechaEmision().getMonth().name().substring(1).toLowerCase()
        ).append(" ").append(factura.getFechaEmision().getYear()).append("\n");
        detalle.append("Detalle de servicios:\n");
        detalle.append(String.format("%-10s %-10s %-12s %-25s %-10s %-10s\n",
                "#Placa", "Fecha", "Tipo", "Servicio", "Cantidad", "Total"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");

        for (OrdenServicio orden : factura.getOrdenes()) {
            String placa = orden.getVehiculo().getPlaca();
            String fecha = orden.getFecha().format(formatter);
            String tipo = orden.getVehiculo().getTipo().name();

            for (ItemOrdenServicio item : orden.getItems()) {
                String servicio = item.getServicio().getNombre();
                int cantidad = item.getCantidad();
                double subtotal = item.calcularSubtotal();

                detalle.append(String.format("%-10s %-10s %-12s %-25s %-10d $%-10.2f\n",
                        placa, fecha, tipo, servicio, cantidad, subtotal));
            }
        }

        detalle.append("\nTotal a pagar: $").append(String.format("%.2f", factura.calcularTotal()));
        return detalle.toString();
    }

}
