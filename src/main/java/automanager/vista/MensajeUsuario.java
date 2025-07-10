package automanager.vista;

public class MensajeUsuario {
    private String accion;
    private String descripcion;

    public MensajeUsuario(String accion, String descripcion) {
        this.accion = accion;
        this.descripcion = descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return accion + ": " + descripcion;
    }

}
