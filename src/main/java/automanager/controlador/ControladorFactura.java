package automanager.controlador;

import automanager.Sistema;
import automanager.modelo.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControladorFactura {
    private Sistema sistema;
    private Factura factura;
    private Cliente cliente;

    public ControladorFactura(Sistema sistema) {
        this.sistema= sistema; // Para poder acceder a la instancia del Sistema creada en la clase Main
    }

    // Método que genera la factura a partir de los datos ingresados por el usuario en la clase VistaFactura  
    public Factura generarFactura(String idCliente, int anio, int mes) {
        factura=null;
        cliente=null;

        // Buscar la orden correspondiente a los datos solicitados
        for (OrdenServicio orden : sistema.getOrdenes()) {
            if (orden.getCliente().getId().equals(idCliente) &&
                orden.getFecha().getYear() == anio &&
                orden.getFecha().getMonthValue() == mes) {

                cliente=orden.getCliente(); // Obtener cliente correspondiente a esa orden
                
                if (cliente.getTipo() != TipoCliente.EMPRESARIAL) return null; // Validar que el cliente sea de tipo empresarial
                // Crear la factura
                factura = new Factura(cliente, LocalDate.of(anio, mes,orden.getFecha().getDayOfMonth()));
                factura.agregarOrden(orden); // Agregar la orden a la factura
            }
        }

        return factura;
    }

    // Generar detalle de la factura
    public String generarDetalleFactura(Factura factura) {
        // Validar que la factura exista
        if (factura == null) {
            if (cliente != null && cliente.getTipo()!=TipoCliente.EMPRESARIAL) return "El cliente no es de tipo empresarial.";
            return "No se encontraron órdenes para ese cliente empresarial en el período especificado.";
        }

        StringBuilder detalle = new StringBuilder();
        detalle.append("Empresa: ").append(factura.getCliente().getNombre()).append("\n");
        detalle.append("Periodo de facturación: ").append(
                factura.getFechaEmision().getMonth().name().substring(0, 1)
                        + factura.getFechaEmision().getMonth().name().substring(1).toLowerCase()
        ).append(" ").append(factura.getFechaEmision().getYear()).append("\n");
        detalle.append("Detalle de servicios:\n");
        detalle.append(String.format("%-10s %-10s %-12s %-25s %-10s %-10s\n",
                "#Placa", "Fecha", "Tipo", "Servicio", "Cantidad", "Total"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM");

        for (OrdenServicio orden : factura.getOrdenes()) {
            String placa = orden.getVehiculo().getPlaca();
            String fecha = orden.getFecha().format(formatter);
            String tipo = orden.getVehiculo().getTipo().name();

            for (ItemOrdenServicio item : orden.getItems()) {
                String servicio = item.getServicio().getNombre();
                int cantidad = item.getCantidad();
                double subtotal = item.calcularSubtotal();

                detalle.append(String.format("%-10s %-10s %-12s %-25s %-10d $%-10.2f\n",
                        placa, fecha, tipo, servicio, cantidad, subtotal));
            }
        }

        detalle.append("\nTotal a pagar: $").append(String.format("%.2f", factura.calcularTotal()));
        return detalle.toString();
    }

}
