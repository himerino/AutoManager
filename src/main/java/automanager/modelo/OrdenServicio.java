package automanager.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdenServicio {
    
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Tecnico tecnico;
    private LocalDate fecha;
    private EstadoOrden estado;
    private ArrayList<ItemOrdenServicio> items;

    public OrdenServicio(Cliente cliente, Vehiculo vehiculo, Tecnico tecnico, LocalDate fecha, EstadoOrden estado) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.tecnico = tecnico;
        this.fecha = fecha;
        this.estado = EstadoOrden.PENDIENTE;
        this.items = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public ArrayList<ItemOrdenServicio> getItems() {
        return items;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public void agregarItem(ItemOrdenServicio item) {
        items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemOrdenServicio item : items) {
            total += item.calcularSubtotal();
        }
        return total;
    }

}
