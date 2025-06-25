package grupo4.modelo;

public class FaltaInsumo {
    private String descripcion;
    private Proveedor proveedor;
    
    public FaltaInsumo(String descripcion, Proveedor proveedor) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    
    
}
