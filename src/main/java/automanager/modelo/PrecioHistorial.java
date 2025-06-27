package automanager.modelo;

import java.time.LocalDate;

public class PrecioHistorial {
    private LocalDate fecha;
    private double precio;

    public PrecioHistorial(LocalDate fecha, double precio) {
        this.fecha = fecha;
        this.precio = precio;
    }

    public LocalDate getFecha() { return fecha; }
    public double getPrecio() { return precio; }
}
