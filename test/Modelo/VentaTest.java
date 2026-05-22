package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class VentaTest {

    @Test
    public void calcularCantidadTotalUnidadesPaquetesSumaLasUnidadesDeCadaPaquete() {
        Venta venta = crearVenta(crearPaquete(2, 200000), crearPaquete(4, 360000));

        assertEquals(6, venta.calcularCantidadTotalUnidadesPaquetes());
    }

    @Test
    public void calcularValorTotalPaquetesSumaElValorTotalDeCadaPaquete() {
        Venta venta = crearVenta(crearPaquete(2, 200000), crearPaquete(4, 360000));

        assertEquals(560000.0, venta.calcularValorTotalPaquetes(), 0.001);
    }

    @Test
    public void calcularValorDescuentoAplicaPorcentajeDelCliente() {
        Venta venta = crearVenta(crearPaquete(1, 500000));

        assertEquals(50000.0, venta.calcularValorDescuento(), 0.001);
    }

    @Test
    public void calcularValorTotalPagarRestaElDescuentoAlTotal() {
        Venta venta = crearVenta(crearPaquete(1, 500000));

        assertEquals(450000.0, venta.calcularValorTotalPagar(), 0.001);
    }

    private static Venta crearVenta(PaqueteTuristico... paquetes) {
        ArrayList<PaqueteTuristico> listaPaquetes = new ArrayList<>();
        for (PaqueteTuristico paquete : paquetes) {
            listaPaquetes.add(paquete);
        }

        Cliente cliente = new Cliente('C', "987654321", false, "Cliente ",
                "cliente.asasa@correo.com", "3009876543", "Contacto del cliente", 0.10);
        return new Venta(202, cliente, listaPaquetes);
    }

    private static PaqueteTuristico crearPaquete(int cantidadUnidades, int valorTotal) {
        return new PaqueteTuristicoMock(cantidadUnidades, valorTotal);
    }

    private static ArrayList<Destino> crearDestinos() {
        ArrayList<Destino> destinos = new ArrayList<>();
        LinkedList<String> atractivos = new LinkedList<>();
        atractivos.add("Actividad ");
        destinos.add(new Destino("Destino venta ", 2, atractivos, true));
        return destinos;
    }

    private static class PaqueteTuristicoMock extends PaqueteTuristico {
        private final int valorTotal;

        PaqueteTuristicoMock(int cantidadUnidades, int valorTotal) {
            super("03234", "Paquete venta ", "Familiar",
                    "Descripcion para la venta", "Cali", crearDestinos(),
                    true, true, false, true, true, 50000, cantidadUnidades);
            this.valorTotal = valorTotal;
        }

        @Override
        public int calcularValorUnidad() {
            return valorTotal / getCantidadUnidades();
        }

        @Override
        public int calcularValorTotal() {
            return valorTotal;
        }
    }
}
