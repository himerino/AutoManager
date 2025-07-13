package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.Tecnico;
import automanager.vista.MensajeUsuario;

import java.util.ArrayList;

public class ControladorTecnico {
    private Sistema sistema;

        public ControladorTecnico(Sistema sistema) {
            this.sistema = sistema;
        }

        public MensajeUsuario agregarTecnico(String id, String nombre, String telefono, String especialidad) {
            if (sistema.buscarTecnico(id) != null) {
                return new MensajeUsuario("Agregar Técnico", "Ya existe un técnico con esa identificación.");
            }
            Tecnico tecnico = new Tecnico(id, nombre, telefono, especialidad);
            sistema.agregarTecnico(tecnico);
            return null;
        }

        public void eliminarTecnico(String id) {
            Tecnico tecnico = sistema.buscarTecnico(id);
            sistema.eliminarTecnico(tecnico);
        }

        public Tecnico buscarTecnicoPorId(String id) {
            for (Tecnico t : sistema.getTecnicos()) {
                if (t.getId().equals(id)) return t;
            }
            return null;
        }

        public ArrayList<Tecnico> getListaTecnicos() {
            return sistema.getTecnicos();
        }
        
}
