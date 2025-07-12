package automanager.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Servicio {

    private String codigo;
    private String nombre;
    private double precioActual;
    private ArrayList<PrecioHistorial> historialPrecios;

    public Servicio(String codigo, String nombre, double precioActual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioActual = precioActual;
        this.historialPrecios = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public ArrayList<PrecioHistorial> getHistorialPrecios() {
        return historialPrecios;
    }

    public void setPrecioActual(double nuevoPrecio) {
        this.precioActual = nuevoPrecio;
    }

    public void registrarPrecioEnHistorial(double precio) {
        PrecioHistorial nuevoRegistro = new PrecioHistorial(LocalDate.now(), precio);
        historialPrecios.add(nuevoRegistro);
    }
    
}
