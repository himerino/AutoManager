package automanager;

import java.time.LocalDate;

import automanager.modelo.Cliente;
import automanager.modelo.EstadoOrden;
import automanager.modelo.ItemOrdenServicio;
import automanager.modelo.OrdenServicio;
import automanager.modelo.Proveedor;
import automanager.modelo.Servicio;
import automanager.modelo.Tecnico;
import automanager.modelo.TipoCliente;
import automanager.modelo.TipoVehiculo;
import automanager.modelo.Vehiculo;
import automanager.vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        new VistaPrincipal(sistema);
        inicializarApp(sistema); 
        
    }
    public static void inicializarApp(Sistema sistema) {
        // 1. Técnicos
        sistema.agregarTecnico(new Tecnico("1101", "Mario Barcos", "0999001122", "Frenos"));
        sistema.agregarTecnico(new Tecnico("1102", "Alvaro López", "0999888777", "Suspensión"));

        // 2. Clientes
        sistema.agregarCliente(new Cliente("1701", "Carlos Pérez", "Av. Quito", "0991112222", TipoCliente.PERSONAL));
        sistema.agregarCliente(new Cliente("1702", "Lucía Gómez", "Av. América", "0993334444", TipoCliente.PERSONAL));
        sistema.agregarCliente(new Cliente("1799", "Grupo HG S.A", "Parque Industrial", "023456789", TipoCliente.EMPRESARIAL));
        sistema.agregarCliente(new Cliente("1798", "Transporte Express", "Av. 10 de Agosto", "022345678", TipoCliente.EMPRESARIAL));

        // 3. Proveedores
        sistema.agregarProveedor(new Proveedor("201", "InsumosAuto S.A", "022112233", "Proveedor de filtros y aceites"));
        sistema.agregarProveedor(new Proveedor("202", "TecniParts", "022334455", "Partes de suspensión"));

        // 4. Servicios
        sistema.agregarServicio(new Servicio("S001", "Cambio de aceite", 20.0));
        sistema.agregarServicio(new Servicio("S002", "Cambio de filtro", 15.0));
        sistema.agregarServicio(new Servicio("S003", "Alineación", 30.0));
        sistema.agregarServicio(new Servicio("S004", "Balanceo", 25.0));
        sistema.agregarServicio(new Servicio("S005", "Revisión de frenos", 35.0));
        sistema.agregarServicio(new Servicio("S006", "Diagnóstico electrónico", 40.0));

        // 5. Vehículos
        Vehiculo v1 = new Vehiculo("GTL-456", TipoVehiculo.AUTOMOVIL);
        Vehiculo v2 = new Vehiculo("TPX-888", TipoVehiculo.BUS);

        // 6. Órdenes (con al menos dos servicios cada una)
        OrdenServicio os1 = new OrdenServicio(
            sistema.buscarCliente("1701"), v1, sistema.buscarTecnico("1101"), LocalDate.of(2025, 4, 4), EstadoOrden.COMPLETADA);
        os1.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S001"), 1));
        os1.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S002"), 1));
        sistema.agregarOrdenServicio(os1);

        OrdenServicio os2 = new OrdenServicio(
            sistema.buscarCliente("1799"), v2, sistema.buscarTecnico("1101"), LocalDate.of(2025, 4, 9), EstadoOrden.COMPLETADA);
        os2.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S003"), 1));
        os2.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S004"), 1));
        sistema.agregarOrdenServicio(os2);

        OrdenServicio os3 = new OrdenServicio(
            sistema.buscarCliente("1702"), new Vehiculo("LUC-789", TipoVehiculo.AUTOMOVIL),
            sistema.buscarTecnico("1102"), LocalDate.of(2025, 5, 10), EstadoOrden.COMPLETADA);
        os3.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S005"), 1));
        os3.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S006"), 1));
        sistema.agregarOrdenServicio(os3);

        OrdenServicio os4 = new OrdenServicio(
            sistema.buscarCliente("1798"), new Vehiculo("TRN-999", TipoVehiculo.BUS),
            sistema.buscarTecnico("1102"), LocalDate.of(2025, 5, 20), EstadoOrden.COMPLETADA);
        os4.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S006"), 1));
        os4.agregarItem(new ItemOrdenServicio(sistema.buscarServicio("S001"), 1));
        sistema.agregarOrdenServicio(os4);
    }
    
}