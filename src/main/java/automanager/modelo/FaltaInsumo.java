package automanager.modelo;

public class FaltaInsumo {

    // Variables de instancia
    private String descripcion;
    private Proveedor proveedor;

    // Constructor
    public FaltaInsumo(String descripcion, Proveedor proveedor) {
        this.descripcion = descripcion;
        this.proveedor = proveedor;
    }

    // Getters
    public Proveedor getProveedor() {
        return proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método setter para Descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}