package automanager.controlador;

import java.time.LocalDate;

import automanager.Sistema;
import automanager.modelo.ItemOrdenServicio;
import automanager.modelo.OrdenServicio;
import automanager.modelo.Vehiculo;
import automanager.modelo.Servicio;

public class ControladorOrdenServicio {
    private Sistema sistema;

    public ControladorOrdenServicio(Sistema sistema){
        this.sistema = sistema;

    }

    public OrdenServicio generaOrdenServicio(String id, LocalDate fecha, Vehiculo vehiculo){
        if (sistema.buscarCliente(id)==null) return null;
        OrdenServicio orden = new OrdenServicio(sistema.buscarCliente(id), vehiculo, fecha);
        return orden;
    }

    public Servicio buscarServicioPorCodigo(String codigo){
        for (Servicio s : sistema.getServicios()) {
                if (s.getCodigo().equals(codigo)) return s;
            }
            return null;
    }

    public ItemOrdenServicio agregarItemOrdenServicio(String codigo, int cantidad){
        Servicio servicio = sistema.buscarServicio(codigo.toUpperCase());
        if (servicio == null) return null;
        ItemOrdenServicio item = new ItemOrdenServicio(servicio, cantidad);
        return item;
    }

    public void agregarOrdenServicio(OrdenServicio orden){
        sistema.agregarOrdenServicio(orden);
    }
    
}
