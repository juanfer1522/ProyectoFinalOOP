/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juanfer
 */
public class PaqueteTuristicoTest {

    /**
     * Test of calcularDuracionTotalDias method, of class PaqueteTuristico.
     */
    @Test
    public void testCalcularDuracionTotalDias() {
        System.out.println("Test -> calcularDuracionTotalDias");
        PaqueteTuristico instance = new PaqueteTuristicoImpl();   
        int expResult = 5; 
        int result = instance.calcularDuracionTotalDias();
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularValorUnidad method, of class PaqueteTuristico.
     */
    @Test
    public void testCalcularValorUnidad() {
        System.out.println("-> calcularValorUnidad");
        PaqueteTuristico instance = new PaqueteTuristicoImpl();
        
        int expResult = 150000;
        int result = instance.calcularValorUnidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularValorTotal method, of class PaqueteTuristico.
     */
    @Test
    public void testCalcularValorTotal() {
        System.out.println("calcularValorTotal");
        PaqueteTuristico instance = new PaqueteTuristicoImpl();
        int expResult = 300000;
        int result = instance.calcularValorTotal();
        assertEquals(expResult, result);
    }

   
    public class PaqueteTuristicoImpl extends PaqueteTuristico {

        public PaqueteTuristicoImpl() {
            super("12345678910", "Juan Fernando Cabrera", "Ecológico", "Des", "Medellin", 
                  crearDestinosPrueba(), false, false, false, false, false, 50000, 2);
        }

        @Override
        public int calcularValorUnidad() {
            return 150000;
        }
        
        @Override
        public int calcularDuracionTotalDias() {
            return 5; 
        }
    }
    
   
    private static ArrayList<Destino> crearDestinosPrueba() {
        ArrayList<Destino> lista = new ArrayList<>();
        
        
        LinkedList<String> cosasPorHacer = new LinkedList<>();
        cosasPorHacer.add("Caminar");
        
        
        Destino destinoFalso = new Destino("Lugar de Prueba", 5, cosasPorHacer, true);
        
        lista.add(destinoFalso); 
        return lista;
    }
    // </editor-fold>

}