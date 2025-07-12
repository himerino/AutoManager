package automanager.controlador;

import automanager.modelo.Cliente;
import automanager.modelo.TipoCliente;
import automanager.modelo.Sistema;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorCliente {
    
    private Sistema sistema;

    public ControladorCliente(Sistema sistema) {
        this.sistema= sistema;
    }

    public MensajeUsuario agregarCliente(String id, String nombre, String direccion, String telefono, TipoCliente tipo) {
        Cliente c= buscarClientePorId(id);
        if (c != null) return new MensajeUsuario("Agregar Cliente", "Ya existe un cliente con esa identificación.");
        sistema.getClientes().add(c);
        return null;
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente c : sistema.getClientes()) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cliente> getListaClientes() {
        return sistema.getClientes();
    }

}
