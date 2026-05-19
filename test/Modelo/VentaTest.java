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
public class VentaTest {
    
    public VentaTest() {
    }

    /**
     * Test of calcularCantidadTotalUnidadesPaquetes method, of class Venta.
     */
    @Test
    public void testCalcularCantidadTotalUnidadesPaquetes() {
        System.out.println("calcularCantidadTotalUnidadesPaquetes");
        
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(new PaqueteTuristicoMock(2, 200000)); 
        paquetes.add(new PaqueteTuristicoMock(3, 300000)); 
        
        Venta instance = new Venta(101, new ClienteMock(), paquetes);
        
        int expResult = 5; 
        int result = instance.calcularCantidadTotalUnidadesPaquetes();
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularValorTotalPaquetes method, of class Venta.
     */
    @Test
    public void testCalcularValorTotalPaquetes() {
        System.out.println("calcularValorTotalPaquetes");
        
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(new PaqueteTuristicoMock(2, 150000)); 
        paquetes.add(new PaqueteTuristicoMock(1, 150000)); 
        
        Venta instance = new Venta(101, new ClienteMock(), paquetes);
        
        double expResult = 300000.0; 
        double result = instance.calcularValorTotalPaquetes();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calcularValorDescuento method, of class Venta.
     */
    @Test
    public void testCalcularValorDescuento() {
        System.out.println("calcularValorDescuento");
        
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(new PaqueteTuristicoMock(2, 300000)); 
        
        Venta instance = new Venta(101, new ClienteMock(), paquetes);
        
        double expResult = 30000.0; 
        double result = instance.calcularValorDescuento();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calcularValorTotalPagar method, of class Venta.
     */
    @Test
    public void testCalcularValorTotalPagar() {
        System.out.println("calcularValorTotalPagar");
        
        ArrayList<PaqueteTuristico> paquetes = new ArrayList<>();
        paquetes.add(new PaqueteTuristicoMock(2, 300000)); 
        
        Venta instance = new Venta(101, new ClienteMock(), paquetes);
        
        double expResult = 270000.0; 
        double result = instance.calcularValorTotalPagar();
        assertEquals(expResult, result, 0.001);
    }

    // <editor-fold defaultstate="collapsed" desc="CLASES DE SOPORTE FALSAS (MOCKS) PARA LA PRUEBA">
    
    private static class ClienteMock extends Cliente {
        public ClienteMock() {
            // Datos extensos para cumplir las reglas de validación de longitud de caracteres
            super('C', "123456789", true, "Juan Fernando Cabrera", "Cali,Colombia", "Calle 18 A # 56-20", "32436836197", 0.10); 
        }
        
        @Override
        public double getPorcentajeDescuento() {
            return 0.10; 
        }
    }

    private static class PaqueteTuristicoMock extends PaqueteTuristico {
        private final int cantUnidades;
        private final int valTotal;

        public PaqueteTuristicoMock(int cantUnidades, int valTotal) {
            super("2345678910", "Paquete Turistico Valle del cauca", "Chiva por sitios turisticos", "Descripciondel paquete turistico para pruebas de funcionamiento", "Cali Valle del Cauca", crearDestinosPrueba(), false, false, false, false, false, 50000, cantUnidades);
            this.cantUnidades = cantUnidades;
            this.valTotal = valTotal;
        }

        @Override
        public int getCantidadUnidades() {
            return this.cantUnidades;
        }

        @Override
        public int calcularValorUnidad() {
            return 150000;
        }

        @Override
        public int calcularValorTotal() {
            return this.valTotal;
        }
    }

    private static ArrayList<Destino> crearDestinosPrueba() {
        ArrayList<Destino> lista = new ArrayList<>();
        LinkedList<String> actividades = new LinkedList<>();
        actividades.add("Chiva por sitios turisticos");
        lista.add(new Destino("Cali, valle del cauca", 5, actividades, true)); 
        return lista;
    }
    // </editor-fold>
}