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

}
