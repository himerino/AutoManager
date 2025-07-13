package automanager.controlador;

import java.util.ArrayList;

import automanager.modelo.Servicio;
import automanager.vista.MensajeUsuario;
import automanager.Sistema;

public class ControladorServicio {
    private Sistema sistema;

    public ControladorServicio(Sistema sistema) {
        this.sistema = sistema;
    }

    public ArrayList<Servicio> getListaServicios() {
        return sistema.getServicios();
    }

    public MensajeUsuario agregarServicio(String nombre, double precio){
        for (Servicio s : sistema.getServicios()){
            if (s.getNombre().equals(nombre)) return new MensajeUsuario("Agregar Servicio", "Ya existe un servicio con ese nombre.");
        }
        String codigo = generarCodigoServicio();
        Servicio servicio = new Servicio(codigo, nombre, precio);
        sistema.agregarServicio(servicio);
        return null;
    }

    public MensajeUsuario editarPrecioServicio(String codigo, double nuevoPrecio) {
        Servicio servicio = sistema.buscarServicio(codigo);
        if (servicio == null) return new MensajeUsuario("Editar Precio del Servicio", "Servicio no encontrado.");
        servicio.registrarPrecioEnHistorial(servicio.getPrecioActual());
        servicio.setPrecioActual(nuevoPrecio);
        return null;
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
