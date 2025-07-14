package automanager.controlador;

import automanager.modelo.FaltaInsumo;
import automanager.modelo.Proveedor;
import automanager.vista.MensajeUsuario;
import automanager.Sistema;
import java.util.ArrayList;

public class ControladorFaltaInsumo {

    private Sistema sistema;

    public ControladorFaltaInsumo(Sistema sistema) {
        this.sistema = sistema; // Para poder acceder a la instancia del sistema creada en la clase Main
    }

    // Obtener la lista de proveedores del sistema
    public ArrayList<Proveedor> getProveedores() {
        return sistema.getProveedores();
    }

    // Crear y agregar una falta de insumo al sistema a partir de los datos ingresados por el usuario en la clase VistaFaltaInsumo
    public MensajeUsuario registrarFalta(String descripcion, String idProveedor) {
        Proveedor proveedor = sistema.buscarProveedor(idProveedor);
        if (proveedor == null) 
        return new MensajeUsuario("Registrar Falta de Insumo", "No se pudo registrar la falta. Verifique el ID del proveedor.");

        FaltaInsumo falta = new FaltaInsumo(descripcion, proveedor);
        sistema.agregarFaltaInsumo(falta);
        return null;
    }

}

