package grupo4.modelo;

public class Proveedor extends Persona {
    private String descripcion;

    public Proveedor(String id, String nombre, String telefono, String descripcion) {
        super(id, nombre, telefono);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
}
