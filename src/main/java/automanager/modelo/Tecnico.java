package automanager.modelo;

public class Tecnico extends Persona {

    private String especialidad;

    public Tecnico(String id, String nombre, String telefono, String especialidad) {
        super(id, nombre, telefono);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
}
