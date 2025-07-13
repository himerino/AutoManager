package automanager.vista;

import automanager.controlador.ControladorOrdenServicio;
import automanager.modelo.OrdenServicio;
import automanager.modelo.ItemOrdenServicio;
import automanager.modelo.Vehiculo;
import automanager.modelo.TipoVehiculo;
import automanager.modelo.Servicio;

import java.time.LocalDate;
import java.util.Scanner;

public class VistaOrdenServicio {
    private ControladorOrdenServicio controlador;
    private Scanner scanner;

    public VistaOrdenServicio(ControladorOrdenServicio controlador){
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
        iniciar();
    }

    public void iniciar(){
        System.out.println("\n--- GENERAR ORDEN DE SERVICIO ---");
        System.out.println();

        System.out.print("Ingrese la identificación del cliente: ");
        String idCliente = scanner.nextLine();

        System.out.print("Ingrese fecha del servicio (AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);
        TipoVehiculo tipo = leerTipoVehiculo();
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();
        System.out.println();
        Vehiculo vehiculo = new Vehiculo(placa.toUpperCase(), tipo);

        OrdenServicio orden = controlador.generaOrdenServicio(idCliente, fecha, vehiculo);

        if (orden == null) {
            System.out.println("Cliente no encontrado.");
            System.out.println("No se pudo generar la Orden de Servicio.");
        }else {
            agregarServicios(orden);

            if ((orden.getItems()).isEmpty()) {
                System.out.println("No se agregaron servicios a la orden.");
                System.out.println("No se pudo generar la Orden de Servicio.");
            }
            else {
                controlador.agregarOrdenServicio(orden);
                System.out.println("Generando Orden de Servicio...");
                System.out.println();
                mostrarDetalleOrdenServicio(orden);
                
            }

        }
        
    }

    private void mostrarDetalleOrdenServicio(OrdenServicio orden){
        System.out.printf("%-10s %-25s %-10s %-10s %-10s\n", "Código", "Servicio", "Cantidad", "Precio", "Subtotal");
            System.out.println("-".repeat(70));
            for (ItemOrdenServicio item : orden.getItems()) {
                Servicio s = item.getServicio();
                int cantidad = item.getCantidad();
                double precio = s.getPrecioActual();
                double subtotal = item.calcularSubtotal();
                System.out.printf("%-10s %-25s %-10d %-10.2f %-10.2f\n",
                s.getCodigo(), s.getNombre(), cantidad, precio, subtotal);
            }
            System.out.println("-".repeat(70));
            System.out.printf("Total a pagar: %.2f\n", orden.calcularTotal());
            System.out.println();

    }

    private void agregarServicios(OrdenServicio orden){
        String codigo = null;
        do{
            System.out.print("Ingrese el código del servicio: ");
            codigo = scanner.nextLine();
            
            if (! codigo.equals("-1")){
                System.out.print("Ingrese la cantidad: ");
                int cantidad = scanner.nextInt();
                System.out.println();
                scanner.nextLine();
                ItemOrdenServicio item = controlador.agregarItemOrdenServicio(codigo, cantidad);
                if (item == null){
                    System.out.println("Servicio no encontrado.");
                    System.out.println();
                }else{
                    orden.agregarItem(item);
                }
            }

        }while (! codigo.equals("-1"));
        System.out.println();

    }

    private TipoVehiculo leerTipoVehiculo() {
        while (true) {
            System.out.print("Tipo de Vehículo (1. AUTOMOVIL, 2. MOTOCICLETA, 3. BUS): ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 -> { return TipoVehiculo.AUTOMOVIL; }
                case 2 -> { return TipoVehiculo.MOTOCICLETA; }
                case 3 -> { return TipoVehiculo.BUS; }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

}
