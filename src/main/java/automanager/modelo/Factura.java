package automanager.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private LocalDate fechaEmision;
    private ArrayList<OrdenServicio> ordenes;
    private static final double CARGO_FIJO_EMPRESARIAL = 50.0;

    public Factura(Cliente cliente, LocalDate fechaEmision) {
        this.cliente = cliente;
        this.fechaEmision = fechaEmision;
        this.ordenes = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    public void agregarOrden(OrdenServicio orden) {
        if (orden != null) {
            ordenes.add(orden);
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (OrdenServicio orden : ordenes) {
            total += orden.calcularTotal();
        }
        if (cliente.getTipo() == TipoCliente.EMPRESARIAL) {
            total += CARGO_FIJO_EMPRESARIAL;
        }
        return total;
    }

    public String generarDetalleFactura() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empresa: ").append(cliente.getNombre()).append("\n");
        sb.append("Periodo de facturación: ").append(fechaEmision.getMonth()).append(" ").append(fechaEmision.getYear()).append("\n");
        sb.append("Detalle de servicios:\n");
        sb.append(String.format("%-10s %-12s %-10s %-25s %-8s %-8s\n", "Placa", "Fecha", "Tipo", "Servicio", "Cant", "Total"));

        for (OrdenServicio orden : ordenes) {
            for (ItemOrdenServicio item : orden.getItems()) {
                sb.append(String.format(
                    "%-10s %-12s %-10s %-25s %-8d %-8.2f\n",
                    orden.getVehiculo().getPlaca(),
                    orden.getFecha(),
                    orden.getVehiculo().getTipo(),
                    item.getServicio().getNombre(),
                    item.getCantidad(),
                    item.calcularSubtotal()
                ));
            }
        }
        sb.append("Total a pagar: ").append(calcularTotal()).append("\n");
        return sb.toString();
    }
}
