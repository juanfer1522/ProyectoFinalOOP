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
        setNombreHotel(nombreHotel);
        setTipoDesayuno(tipoDesayuno);
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        if (nombreHotel == null || nombreHotel.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del hotel no puede estar vacio");
        }

        this.nombreHotel = nombreHotel;
    }

    public String getTipoDesayuno() {
        return tipoDesayuno;
    }

    public void setTipoDesayuno(String tipoDesayuno) {
        if (tipoDesayuno == null) {
            throw new IllegalArgumentException("El tipo de desayuno no puede ser nulo");
        }

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
