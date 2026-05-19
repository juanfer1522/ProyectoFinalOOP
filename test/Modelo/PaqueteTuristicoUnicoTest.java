package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juanfer
 */
public class PaqueteTuristicoUnicoTest {
    
    public PaqueteTuristicoUnicoTest() {
    }

    /**
     * Test of calcularValorUnidad method, of class PaqueteTuristicoUnico.
     */
    @Test
    public void testCalcularValorUnidad() {
        System.out.println("calcularValorUnidad");
        
        
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        LinkedList<String> actividades = new LinkedList<>();
        actividades.add("Recorrido cultural guiado");
        listaDestinos.add(new Destino("Cartagena", 4, actividades, true));
        int tarifaDiaria = 150000;
        PaqueteTuristicoUnico instance = new PaqueteTuristicoUnico("Hotel Hilton", "Desayuno Tipico", "002123", "Paquete Vacacional Premium Cartagena", "Turismo cultural", "Chiva rumbera", "Cali Valle del Cauca", listaDestinos, true, true, false, true, true, tarifaDiaria, 1);
        int expResult = 600000; 
        int result = instance.calcularValorUnidad();
        assertEquals(expResult, result);
    }
}