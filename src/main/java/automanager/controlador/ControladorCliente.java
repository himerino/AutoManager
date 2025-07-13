package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.Cliente;
import automanager.modelo.TipoCliente;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorCliente {
    
    private Sistema sistema;

    public ControladorCliente(Sistema sistema) {
        this.sistema= sistema;
    }

    public MensajeUsuario agregarCliente(String id, String nombre, String direccion, String telefono, TipoCliente tipo) {
        if (sistema.buscarCliente(id) != null) return new MensajeUsuario("Agregar Cliente", "Ya existe un cliente con esa identificación.");
        Cliente c= new Cliente(id, nombre, telefono, direccion, tipo);
        sistema.agregarCliente(c);
        return null;
    }

    public ArrayList<Cliente> getListaClientes() {
        return sistema.getClientes();
    }

}
