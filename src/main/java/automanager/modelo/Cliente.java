package automanager.modelo;

public class Cliente extends Persona {

    private String direccion;
    private TipoCliente tipo;
    
    public Cliente(String id, String nombre, String telefono, String direccion, TipoCliente tipo) {
        super(id, nombre, telefono);
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    
}
