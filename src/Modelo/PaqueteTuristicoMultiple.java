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
public final class PaqueteTuristicoMultiple extends PaqueteTuristico{
    
    private String obsequio;

    public PaqueteTuristicoMultiple(String obsequio, String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestino, boolean hotel, boolean alimentacion, boolean alimentacionTodo, boolean vuelo, boolean asistencia, int tarifaDia, int cantidadIUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestino, hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadIUnidades);
        setObsequio(obsequio);
    }

    public String getObsequio() {
        return obsequio;
    }

    public void setObsequio(String obsequio) {
        if (obsequio == null || obsequio.trim().isEmpty()) {
            throw new IllegalArgumentException("El obsequio no puede estar vacio");
        }

        this.obsequio = obsequio;
    }
    
    @Override
    public int calcularValorUnidad(){
        int valorBase = this.tarifaDia *  this.calcularDuracionTotalDias();
        int incremento = (this.tarifaDia * this.susDestinos.size()) / 100;
        return valorBase + incremento;
    }
    
    public Destino obtenerDestinoInicial() {
        return this.susDestinos.get(0);
    }
    
    public Destino obtenerDestinoFinal(){
        return this.susDestinos.get(this.susDestinos.size()-1);
    }
    
    

    @Override
    public String toString() {
        return "PaqueteTuristicoMultiple{" + "obsequio=" + obsequio + '}';
    }
       
}
