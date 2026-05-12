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
public abstract class PaqueteTuristico {
    protected String codigo;
    protected String nombre;
    protected String tipologiaTurismo;
    protected String descripcion;
    protected String origen;
    protected ArrayList<Destino> susDestino;
    protected boolean hotel;
    protected boolean alimentacion;
    protected boolean alimentacionTodo;
    protected boolean vuelo;
    protected boolean asistencia;
    protected int tarifaDia;
    protected int cantidadIUnidades;

    public PaqueteTuristico(String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestino, boolean hotel, boolean alimentacion, boolean alimentacionTodo, boolean vuelo, boolean asistencia, int tarifaDia, int cantidadIUnidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipologiaTurismo = tipologiaTurismo;
        this.descripcion = descripcion;
        this.origen = origen;
        this.susDestino = susDestino;
        this.hotel = hotel;
        this.alimentacion = alimentacion;
        this.alimentacionTodo = alimentacionTodo;
        this.vuelo = vuelo;
        this.asistencia = asistencia;
        this.tarifaDia = tarifaDia;
        this.cantidadIUnidades = cantidadIUnidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipologiaTurismo() {
        return tipologiaTurismo;
    }

    public void setTipologiaTurismo(String tipologiaTurismo) {
        this.tipologiaTurismo = tipologiaTurismo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public ArrayList<Destino> getSusDestino() {
        return susDestino;
    }

    public void setSusDestino(ArrayList<Destino> susDestino) {
        this.susDestino = susDestino;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(boolean alimentacion) {
        this.alimentacion = alimentacion;
    }

    public boolean isAlimentacionTodo() {
        return alimentacionTodo;
    }

    public void setAlimentacionTodo(boolean alimentacionTodo) {
        this.alimentacionTodo = alimentacionTodo;
    }

    public boolean isVuelo() {
        return vuelo;
    }

    public void setVuelo(boolean vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public int getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(int tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public int getCantidadIUnidades() {
        return cantidadIUnidades;
    }

    public void setCantidadIUnidades(int cantidadIUnidades) {
        this.cantidadIUnidades = cantidadIUnidades;
    }

    @Override
    public String toString() {
        return "PaqueteTuristico{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipologiaTurismo=" + tipologiaTurismo + ", descripcion=" + descripcion + ", origen=" + origen + ", susDestino=" + susDestino + ", hotel=" + hotel + ", alimentacion=" + alimentacion + ", alimentacionTodo=" + alimentacionTodo + ", vuelo=" + vuelo + ", asistencia=" + asistencia + ", tarifaDia=" + tarifaDia + ", cantidadIUnidades=" + cantidadIUnidades + '}';
    }
    
    
    
}
