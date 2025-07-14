package automanager.vista;

public class MensajeUsuario {
    
    // Variables de instancia 
    private String accion;
    private String descripcion;

    // Constructor
    public MensajeUsuario(String accion, String descripcion) {
        this.accion = accion;
        this.descripcion = descripcion;
    }

    // Getters
    public String getAccion() {
        return accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return accion + ": " + descripcion;
    }

}
