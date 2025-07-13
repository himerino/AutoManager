package automanager.controlador;

import java.util.ArrayList;

import automanager.modelo.Servicio;
import automanager.Sistema;

public class ControladorServicio {
    private Sistema sistema;

    public ControladorServicio(Sistema sistema) {
        this.sistema = sistema;
    }

    public ArrayList<Servicio> obtenerServicios() {
        return sistema.getServicios();
    }

    public Servicio agregarServicio(String nombre, double precio) {
        String nuevoCodigo = generarCodigoServicio();
        Servicio nuevoServicio = new Servicio(nuevoCodigo, nombre, precio);
        sistema.agregarServicio(nuevoServicio);
        return nuevoServicio;
    }

    public boolean editarPrecioServicio(String codigo, double nuevoPrecio) {
        Servicio servicio = sistema.buscarServicio(codigo);
        if (servicio != null) {
            servicio.registrarPrecioEnHistorial(servicio.getPrecioActual());
            servicio.setPrecioActual(nuevoPrecio);
            return true;
        }
        return false;
    }

    private String generarCodigoServicio() {
        ArrayList<Servicio> servicios = sistema.getServicios();
        int max = 0;
        for (Servicio servicio : servicios) {
            int numero = Integer.parseInt(servicio.getCodigo().substring(1));
            if (numero > max) {
                max = numero;
            }
        }
        return "S" + String.format("%03d", max + 1);
    }
}
