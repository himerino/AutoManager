package automanager.modelo;

public class ItemOrdenServicio {
    private Servicio servicio;
    private int cantidad;

    public ItemOrdenServicio(Servicio servicio, int cantidad) {
        this.servicio = servicio;
        this.cantidad = cantidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return servicio.getPrecioActual() * cantidad;
    }
}
