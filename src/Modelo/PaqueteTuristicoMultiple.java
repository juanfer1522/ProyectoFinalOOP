/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Juanfer
 */
public class PaqueteTuristicoMultiple extends PaqueteTuristico{
    
    private String obsequio;

    public PaqueteTuristicoMultiple(String obsequio, String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestino, boolean hotel, boolean alimentacion, boolean alimentacionTodo, boolean vuelo, boolean asistencia, int tarifaDia, int cantidadIUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestino, hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadIUnidades);
        this.obsequio = obsequio;
    }

    @Override
    public String toString() {
        return "PaqueteTuristicoMultiple{" + "obsequio=" + obsequio + '}';
    }
    
    
}
