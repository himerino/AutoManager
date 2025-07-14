package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.Proveedor;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorProveedor {

    private Sistema sistema;

    public ControladorProveedor(Sistema sistema) {
        this.sistema = sistema; // Para acceder a la intancia del sistema creada en la clase Main
    }

    // Agregar a la lista de proveedores del sistema el proveedor creado a partir de los datos ingresados por el usuario en la clase VistaProveedor
    public MensajeUsuario agregarProveedor(String id, String nombre, String telefono, String descripcion) {
        // Validar si el proveedor exite en la lista de proveedores del sistema
        if (sistema.buscarProveedor(id) != null) {
            return new MensajeUsuario("Agregar Proveedor", "Ya existe un proveedor con esa identificación.");
        }
        Proveedor proveedor = new Proveedor(id, nombre, telefono, descripcion);
        sistema.agregarProveedor(proveedor);
        return null;
    }

    // Obtener la lista de proveedores del sistema
    public ArrayList<Proveedor> getListaProveedores() {
        return sistema.getProveedores();
    }
    
}