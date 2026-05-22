package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaqueteTuristicoMultipleTest {

    @Test
    public void calcularValorUnidadSumaValorBaseMasIncrementoPorDestinos() {
        PaqueteTuristicoMultiple paquete = crearPaquete(100000, 3, 2);

        assertEquals(502000, paquete.calcularValorUnidad());
    }

    @Test
    public void obtenerDestinoInicialRetornaPrimerDestino() {
        ArrayList<Destino> destinos = crearDestinos(3, 2);
        PaqueteTuristicoMultiple paquete = crearPaquete(100000, destinos);

        assertSame(destinos.get(0), paquete.obtenerDestinoInicial());
    }

    @Test
    public void obtenerDestinoFinalRetornaUltimoDestino() {
        ArrayList<Destino> destinos = crearDestinos(3, 2, 4);
        PaqueteTuristicoMultiple paquete = crearPaquete(100000, destinos);

        assertSame(destinos.get(2), paquete.obtenerDestinoFinal());
    }

    private static PaqueteTuristicoMultiple crearPaquete(int tarifaDia, int... diasDestinos) {
        return crearPaquete(tarifaDia, crearDestinos(diasDestinos));
    }

    private static PaqueteTuristicoMultiple crearPaquete(int tarifaDia, ArrayList<Destino> destinos) {
        return new PaqueteTuristicoMultiple("Maleta Economica", "00033255",
                "Paquete multiple Colombia", "Paseo",
                "Descripcion de actividades de paquete multiple", "Cali", destinos,
                true, true, false, true, true, tarifaDia, 2);
    }

    private static ArrayList<Destino> crearDestinos(int... diasDestinos) {
        ArrayList<Destino> destinos = new ArrayList<>();
        LinkedList<String> atractivos = new LinkedList<>();
        atractivos.add("Tour monumentos");

        for (int i = 0; i < diasDestinos.length; i++) {
            destinos.add(new Destino("Destino multiple " + (i + 1), diasDestinos[i], atractivos, true));
        }

        return destinos;
    }
}
