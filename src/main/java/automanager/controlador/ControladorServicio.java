package automanager.controlador;

import java.util.ArrayList;

import automanager.modelo.Servicio;
import automanager.vista.MensajeUsuario;
import automanager.Sistema;

public class ControladorServicio {
    private Sistema sistema;

    public ControladorServicio(Sistema sistema) {
        this.sistema = sistema; // Para poder acceder a la instancia del sistema creada en la clase Main
    }

    // Obtener la lista de servicios de la lista
    public ArrayList<Servicio> getListaServicios() {
        return sistema.getServicios();
    }

    // Crear y agregar servicio a la lista de servicios del sistema a partir de los datos ingresados por el usuario en la clase VistaServicio
    public MensajeUsuario agregarServicio(String nombre, double precio){
        
        // Validar si el servicio ya existe en el sistema
        for (Servicio s : sistema.getServicios()){
            if (s.getNombre().equals(nombre)) return new MensajeUsuario("Agregar Servicio", "Ya existe un servicio con ese nombre.");
        }
        String codigo = generarCodigoServicio(); // Crear el codigo para el nuevo servicio
        Servicio servicio = new Servicio(codigo, nombre, precio);
        sistema.agregarServicio(servicio);
        return null;
    }

    // Cambiar el precio de un servicio a partir de los datos ingresados por el usuario en la clase VistaServicio
    public MensajeUsuario editarPrecioServicio(String codigo, double nuevoPrecio) {
        Servicio servicio = sistema.buscarServicio(codigo);
        if (servicio == null) return new MensajeUsuario("Editar Precio del Servicio", "Servicio no encontrado.");
        servicio.registrarPrecioEnHistorial(servicio.getPrecioActual()); // Guardar el precio actual del servicio en el historial
        servicio.setPrecioActual(nuevoPrecio); // Cambiar el precio del servicio por el ingresado por el usuario
        return null;
    }

    // Generar el codigo para el servicio a agregar 
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
