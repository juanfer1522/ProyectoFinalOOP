/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Juanfer
 */
public class Destino implements Serializable {
    private String nombreLugar;
    private int diasPermanencia;
    private LinkedList<String> atractivos;
    private boolean atractivosIncluidos;

    public Destino(String nombreLugar, int diasPermanencia, LinkedList<String> atractivos, boolean atractivosIncluidos) {
        setNombreLugar(nombreLugar);
        setDiasPermanencia(diasPermanencia);
        this.atractivos = atractivos;
        this.atractivosIncluidos = atractivosIncluidos;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        if (nombreLugar == null || nombreLugar.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del destino no puede estar vacio");
        }

        this.nombreLugar = nombreLugar;
    }

    public int getDiasPermanencia() {
        return diasPermanencia;
    }

    public void setDiasPermanencia(int diasPermanencia) {
        if (diasPermanencia < 1) {
            throw new IllegalArgumentException("Dias de permanencia no validos, debe ser mayor o igual a 1");
            }
        this.diasPermanencia = diasPermanencia;
            
    }

    public LinkedList<String> getAtractivos() {
        return atractivos;
    }

    public void setAtractivos(LinkedList<String> atractivos) {
        this.atractivos = atractivos;
    }

    public boolean isAtractivosIncluidos() {
        return atractivosIncluidos;
    }

    public void setAtractivosIncluidos(boolean atractivosIncluidos) {
        this.atractivosIncluidos = atractivosIncluidos;
    }

    @Override
    public String toString() {
        return "Destino{" + "nombreLugar=" + nombreLugar + ", diasPermanencia=" + diasPermanencia + ", atractivos=" + atractivos + ", atractivosIncluidos=" + atractivosIncluidos + '}';
    }
            
}
