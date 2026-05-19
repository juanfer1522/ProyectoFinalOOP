package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juanfer
 */
public class PaqueteTuristicoMultipleTest {
    
    public PaqueteTuristicoMultipleTest() {
    }

    /**
     * Test of calcularValorUnidad method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testCalcularValorUnidad() {
        System.out.println("calcularValorUnidad");
        
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        LinkedList<String> actividades = new LinkedList<>();
        actividades.add("Actividad de Prueba");
        listaDestinos.add(new Destino("Destino Inicial Eje Cafetero", 3, actividades, true));
        listaDestinos.add(new Destino("Destino Final Medellin Antioquia", 2, actividades, true));
        
        PaqueteTuristicoMultiple instance = new PaqueteTuristicoMultiple("Maleta de viaje ejecutiva premium", "PKG-MULT-999", "Gran Tour Multidestino Colombia Autentica", "Eco-Turismo y Aventura Cultural", "Recorrido completo por multiples destinos de Colombia con guia personalizado", "Cali Valle del Cauca", listaDestinos, true, true, false, true, true, 100000, 2);
        
        int expResult = 502000; 
        int result = instance.calcularValorUnidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerDestinoInicial method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testObtenerDestinoInicial() {
        System.out.println("obtenerDestinoInicial");
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        LinkedList<String> actividades = new LinkedList<>();
        actividades.add("Monumentos Historicos");
        Destino destinoInicial = new Destino("Destino Inicial Cali, Valle del Cauca", 3, actividades, true);
        listaDestinos.add(destinoInicial);
        listaDestinos.add(new Destino("Destino Final Medellin Antioquia", 2, actividades, true));
        
        PaqueteTuristicoMultiple instance = new PaqueteTuristicoMultiple("Maleta de viaje ejecutiva", "000AZ22", "Tour ciudades principales", "Recorrido cultural", "Recorrido completo por ciudades  de Colombia ", "Cali Valle del Cauca", listaDestinos, true, true, false, true, true, 100000, 2);
        
        Destino result = instance.obtenerDestinoInicial();
        assertEquals(destinoInicial, result);
    }

    /**
     * Test of obtenerDestinoFinal method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testObtenerDestinoFinal() {
        System.out.println("obtenerDestinoFinal");
        
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        LinkedList<String> actividades = new LinkedList<>();
        actividades.add("Monumentos Historicos");
        Destino destinoFinal = new Destino("Destino Final Medellin Antioquia", 2, actividades, true);
        listaDestinos.add(new Destino("Destino Inicial Cali, Valle del cauca", 3, actividades, true));
        listaDestinos.add(destinoFinal);
        
        PaqueteTuristicoMultiple instance = new PaqueteTuristicoMultiple("Maleta de viaje ejecutiva", "000AZ2223", "Tour multidestino ciudades principales", "Monumentos historicos", "Recorrido completo por multiples destinos de Colombia con guia personalizado", "Cali Valle del Cauca", listaDestinos, true, true, false, true, true, 100000, 2);
        
        Destino result = instance.obtenerDestinoFinal();
        assertEquals(destinoFinal, result);
    }
}