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
        this.sistema = sistema; // Para poder acceder a la instancia del sistema creada en la clase Main

    }

    // Crear orden de servicio a partir de los datos ingresados por el usuario en la clase VistaOrdenServicio
    public OrdenServicio generaOrdenServicio(String id, LocalDate fecha, Vehiculo vehiculo){
        if (sistema.buscarCliente(id)==null) return null; // Si el cliente no existe de vuelve nulo
        OrdenServicio orden = new OrdenServicio(sistema.buscarCliente(id), vehiculo, fecha);
        return orden;
    }

    // Crear item para la orden a partir del codigo del servicio correspondiente y la cantidad requerida
    public ItemOrdenServicio generarItemOrdenServicio(String codigo, int cantidad){
        Servicio servicio = sistema.buscarServicio(codigo.toUpperCase()); // Buscar el servicio en la lista de servicios del sistema
        if (servicio == null) return null; // si el servicio no existe retorna item nulo
        ItemOrdenServicio item = new ItemOrdenServicio(servicio, cantidad);
        return item;
    }

    // Agregar la orden de servicio a la lista de ordenes de servicio del sistema
    public void agregarOrdenServicio(OrdenServicio orden){
        sistema.agregarOrdenServicio(orden);
    }
    
}
