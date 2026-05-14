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
public final class PaqueteTuristicoUnico extends PaqueteTuristico {
    private String nombreHotel;
    private String tipoDesayuno;

    public PaqueteTuristicoUnico(String nombreHotel, String tipoDesayuno, String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestino, boolean hotel, boolean alimentacion, boolean alimentacionTodo, boolean vuelo, boolean asistencia, int tarifaDia, int cantidadIUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestino, hotel, alimentacion, alimentacionTodo, vuelo, asistencia, tarifaDia, cantidadIUnidades);
        this.nombreHotel = nombreHotel;
        this.tipoDesayuno = tipoDesayuno;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getTipoDesayuno() {
        return tipoDesayuno;
    }

    public void setTipoDesayuno(String tipoDesayuno) {
        this.tipoDesayuno = tipoDesayuno;
    }

    @Override
    public String toString() {
        return "PaqueteTuristicoUnico{" + "nombreHotel=" + nombreHotel + ", tipoDesayuno=" + tipoDesayuno + '}';
    }
    
    @Override  
    public int calcularValorUnidad (){
        return this.tarifaDia * this.calcularDuracionTotalDias();
    }
}
