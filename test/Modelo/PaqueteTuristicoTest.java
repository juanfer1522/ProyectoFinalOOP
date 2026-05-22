package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaqueteTuristicoTest {

    @Test
    public void calcularDuracionTotalDiasSumaLosDiasDeTodosLosDestinos() {
        PaqueteTuristico paquete = new PaqueteTuristicoImpl(200000, 2, crearDestinos(4, 1));

        assertEquals(5, paquete.calcularDuracionTotalDias());
    }

    @Test
    public void calcularValorTotalMultiplicaValorUnidadPorCantidadUnidades() {
        PaqueteTuristico paquete = new PaqueteTuristicoImpl(200000, 2, crearDestinos(4, 1));

        assertEquals(400000, paquete.calcularValorTotal());
    }

    private static ArrayList<Destino> crearDestinos(int... diasDestinos) {
        ArrayList<Destino> destinos = new ArrayList<>();
        LinkedList<String> atractivos = new LinkedList<>();
        atractivos.add("Paseo en chiva");

        for (int i = 0; i < diasDestinos.length; i++) {
            destinos.add(new Destino("Medellin " + (i + 1), diasDestinos[i], atractivos, true));
        }

        return destinos;
    }

    private static class PaqueteTuristicoImpl extends PaqueteTuristico {
        private final int valorUnidad;

        PaqueteTuristicoImpl(int valorUnidad, int cantidadUnidades, ArrayList<Destino> destinos) {
            super("222134", "Paquete base integrado", "Cultural",
                    "Descripcion de la prueba unitaria", "Cali", destinos,
                    true, true, false, true, true, 100000, cantidadUnidades);
            this.valorUnidad = valorUnidad;
        }

        @Override
        public int calcularValorUnidad() {
            return valorUnidad;
        }
    }
}
