package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaqueteTuristicoUnicoTest {

    @Test
    public void calcularValorUnidadMultiplicaTarifaPorDuracionTotal() {
        PaqueteTuristicoUnico paquete = new PaqueteTuristicoUnico("Hotel hilton", "Criollo",
                "0021", "Paquete unico ", "Cultural",
                "Descripcion de paquete unico", "Cali",
                crearDestinos(2, 3), true, true, false, true, true, 120000, 1);

        assertEquals(600000, paquete.calcularValorUnidad());
    }

    private static ArrayList<Destino> crearDestinos(int... diasDestinos) {
        ArrayList<Destino> destinos = new ArrayList<>();
        LinkedList<String> atractivos = new LinkedList<>();
        atractivos.add("Tour historico");

        for (int i = 0; i < diasDestinos.length; i++) {
            destinos.add(new Destino("Unico destino " + (i + 1), diasDestinos[i], atractivos, true));
        }

        return destinos;
    }
}
