package automanager.controlador;

public class ControladorOrdenServicio {
    private Sistema sistema;
    public ControladorOrdenServicio(Sistema sistema){
        this.sistema = sistema;
    }

    public ArrayList<OrdenServicio> obtenerOrdenServicio(){
        return sistema.getOrdenes();
    }

    public MensajeUsuario agregarOrdenServicio(String ID, String idTecnico,String fecha, TipoVehiculo tipoVehiculo String placa, String codigo){
        Cliente cliente = buscarCliente(id);
        if (cliente == null) return MensajeUsuario("Cliente", "No existe el cliente");
        LocalDate fecha = LocalDate.parse(fecha);
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo == null) return MensajeUsuario("Vehiculo", "No existe el vehiculo");
        Servicio servicio = buscarServicio(codigo);
        if (servicio == null) return MensajeUsuario("Servicio", "No existe el servicio");
        Tecnico tecnico = buscaTecnico(idTecnico);
        if (tecnico == null) return MensajeUsuario("Tecnico", "No existe el Tecnico");

        OrdenServicio ordenServicio = new OrdenServicio(cliente,vehiculo,tecnico,fecha, EstadoOrden.PENDIENTE);
        sistema.agregarOrdenServicio(ordenServicio);

    }

    public Vehiculo buscarTecnico(String id){
        for (Tecnico t: sistema.getTecnico()){
            if(t.getCodigo.equals(id)){
                return t;
            }
        }
        return null
    }

    public Vehiculo buscarServicio(String codigo){
        for (Servicio s: sistema.getServicio()){
            if(s.getCodigo.equals(codigo)){
                return s;
            }
        }
        return null
    }

    public Vehiculo buscarVehiculo(String placa){
        for (Vehiculo v: sistema.getVehiculo()){
            if(v.getPlaca.equals(placa)){
                return v;
            }
        }
        return null
    }

    public Cliente buscarClientePorId(String id) {
        for (Cliente c : sistema.getClientes()) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}

