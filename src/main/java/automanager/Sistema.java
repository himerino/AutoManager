package automanager;

import java.util.ArrayList;

import automanager.modelo.Cliente;
import automanager.modelo.FaltaInsumo;
import automanager.modelo.OrdenServicio;
import automanager.modelo.Proveedor;
import automanager.modelo.Servicio;
import automanager.modelo.Tecnico;

public class Sistema {

    private ArrayList<Cliente> clientes;
    private ArrayList<Tecnico> tecnicos;
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Servicio> servicios;
    private ArrayList<OrdenServicio> ordenes;
    private ArrayList<FaltaInsumo> faltas;

    public Sistema() {
        clientes = new ArrayList<>();
        tecnicos = new ArrayList<>();
        proveedores = new ArrayList<>();
        servicios = new ArrayList<>();
        ordenes = new ArrayList<>();
        faltas = new ArrayList<>();
    }

    // MÉTODOS DE CLIENTE
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    // MÉTODOS DE TÉCNICO
    public void agregarTecnico(Tecnico tecnico) {
        tecnicos.add(tecnico);
    }

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public Tecnico buscarTecnico(String id) {
        for (Tecnico t : tecnicos) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    // MÉTODOS DE PROVEEDOR
    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public Proveedor buscarProveedor(String id) {
        for (Proveedor p : proveedores) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    // MÉTODOS DE SERVICIO
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public Servicio buscarServicio(String codigo) {
        for (Servicio s : servicios) {
            if (s.getCodigo().equals(codigo)) return s;
        }
        return null;
    }

    // MÉTODOS DE ORDEN DE SERVICIO
    public void agregarOrdenServicio(OrdenServicio orden) {
        ordenes.add(orden);
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return ordenes;
    }


    // MÉTODOS DE FALTA DE INSUMO
    public void agregarFaltaInsumo(FaltaInsumo falta) {
        faltas.add(falta);
    }

    public ArrayList<FaltaInsumo> getFaltas() {
        return faltas;
    }

}
