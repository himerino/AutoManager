package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.Tecnico;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorTecnico {
    private Sistema sistema;

        public ControladorTecnico(Sistema sistema) {
            this.sistema = sistema; // Para poder acceder a la instancia del sistema creada en la clase Main
        }

        // Crear y agregar tecnico a la lista de tecnicos del sistema a partir de los datos ingresados por el usuario en la clase VistaTecnico
        public MensajeUsuario agregarTecnico(String id, String nombre, String telefono, String especialidad) {
            
            // Validar si ya existe el tecnico en el sistema
            if (sistema.buscarTecnico(id) != null) {
                return new MensajeUsuario("Agregar Técnico", "Ya existe un técnico con esa identificación.");
            }
            Tecnico tecnico = new Tecnico(id, nombre, telefono, especialidad);
            sistema.agregarTecnico(tecnico);
            return null;
        }

        // Eliminar tecnico de la lista de tecnicos del sistema a partir de los datos ingresados en la clase VistaTecnico
        public void eliminarTecnico(String id) {
            Tecnico tecnico = sistema.buscarTecnico(id);
            sistema.eliminarTecnico(tecnico);
        }

        // Buscar tecnico en el sistema a partir del id
        public Tecnico buscarTecnicoPorId(String id) {
            return sistema.buscarTecnico(id);
        }

        // Obtener la lista de tecnicos del sistema
        public ArrayList<Tecnico> getListaTecnicos() {
            return sistema.getTecnicos();
        }
        
}
