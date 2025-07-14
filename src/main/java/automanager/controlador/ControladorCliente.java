package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.Cliente;
import automanager.modelo.TipoCliente;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorCliente {
    
    private Sistema sistema;

    public ControladorCliente(Sistema sistema) {
        this.sistema= sistema; // Para poder acceder a la instancia del sistema creada en la clase Main
    }

    // Método que crea cliente a partir de los datos ingresados por el usuario en la clase VistaCliente y lo agrega a la lista de clientes del sistema
    public MensajeUsuario agregarCliente(String id, String nombre, String direccion, String telefono, TipoCliente tipo) {
        
        // Verificar si el cliente ya existe dentro de la lista de clientes del sitema
        if (sistema.buscarCliente(id) != null) return new MensajeUsuario("Agregar Cliente", "Ya existe un cliente con esa identificación.");
        Cliente c= new Cliente(id, nombre, telefono, direccion, tipo);
        sistema.agregarCliente(c);
        return null;
    }

    // Método que devuelve la lista de clientes del sistema
    public ArrayList<Cliente> getListaClientes() {
        return sistema.getClientes();
    }

}
