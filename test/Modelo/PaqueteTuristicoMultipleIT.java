/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Modelo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juanfer
 */
public class PaqueteTuristicoMultipleIT {
    
    public PaqueteTuristicoMultipleIT() {
    }

    /**
     * Test of calcularValorUnidad method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testCalcularValorUnidad() {
        System.out.println("calcularValorUnidad");
        PaqueteTuristicoMultiple instance = null;
        int expResult = 0;
        int result = instance.calcularValorUnidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDestinoInicial method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testObtenerDestinoInicial() {
        System.out.println("obtenerDestinoInicial");
        PaqueteTuristicoMultiple instance = null;
        Destino expResult = null;
        Destino result = instance.obtenerDestinoInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerDestinoFinal method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testObtenerDestinoFinal() {
        System.out.println("obtenerDestinoFinal");
        PaqueteTuristicoMultiple instance = null;
        Destino expResult = null;
        Destino result = instance.obtenerDestinoFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PaqueteTuristicoMultiple.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PaqueteTuristicoMultiple instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
