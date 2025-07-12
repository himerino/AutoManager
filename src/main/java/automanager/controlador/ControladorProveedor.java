package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.Proveedor;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorProveedor {

    private Sistema sistema;

    public ControladorProveedor(Sistema sistema) {
        this.sistema = sistema;
    }

    public MensajeUsuario agregarProveedor(String id, String nombre, String telefono, String descripcion) {
        if (buscarProveedorPorId(id) != null) {
            return new MensajeUsuario("Agregar Proveedor", "Ya existe un proveedor con esa identificación.");
        }
        Proveedor proveedor = new Proveedor(id, nombre, telefono, descripcion);
        sistema.getProveedores().add(proveedor);
        return null;
    }

    public Proveedor buscarProveedorPorId(String id) {
        for (Proveedor p : sistema.getProveedores()) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public ArrayList<Proveedor> getListaProveedores() {
        return sistema.getProveedores();
    }
}