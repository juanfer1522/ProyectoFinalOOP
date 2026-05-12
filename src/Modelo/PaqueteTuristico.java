/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

import Modelo.Destino;

public abstract class PaqueteTuristico {

    protected String codigo;

    // nombre minimo 10 caracteres
    protected String nombre;

    // ej: negocios, recreación, educativo, ecológico
    protected String tipologiaTurismo;

    // descripcion maximo 500 caracteres
    protected String descripcion;

    // lugar de partida ej: Bogotá D.C.
    protected String origen;

    protected ArrayList<Destino> susDestinos;

    // si incluye hotel o no
    // por defecto incluido
    protected boolean hotel;

    // si incluye alimentacion o no
    // por defecto incluido
    protected boolean alimentacion;

    // si la alimentacion es completa
    // o solo desayuno
    protected boolean alimentacionTodo;

    // si incluye vuelo o no
    // por defecto incluido
    protected boolean vuelo;

    // si incluye asistencia o no
    // por defecto NO incluida
    protected boolean asistencia;

    // tarifa mayor que cero
    protected int tarifaDia;

    // minimo 1 reserva
    protected int cantidadUnidades;

    public PaqueteTuristico(
            String codigo,
            String nombre,
            String tipologiaTurismo,
            String descripcion,
            String origen,
            ArrayList<Destino> susDestinos,
            boolean hotel,
            boolean alimentacion,
            boolean alimentacionTodo,
            boolean vuelo,
            boolean asistencia,
            int tarifaDia,
            int cantidadUnidades) {

        this.codigo = codigo;

        // nombre:
        // minimo 10 caracteres

        if (nombre.length() >= 10) {
            this.nombre = nombre;
        }

        this.tipologiaTurismo = tipologiaTurismo;

        // descripcion:
        // maximo 500 caracteres
        if (descripcion.length() <= 500) {
            this.descripcion = descripcion;
        }

        this.origen = origen;

        this.susDestinos = susDestinos;

        // hotel:
        // por defecto incluido
        this.hotel = hotel;

        // alimentacion:
        // por defecto incluida
        this.alimentacion = alimentacion;

        // alimentacionTodo:
        // todo o solo desayuno
        this.alimentacionTodo = alimentacionTodo;

        // vuelo:
        // por defecto incluido
        this.vuelo = vuelo;

        // asistencia:
        // por defecto NO incluida
        this.asistencia = asistencia;

        // tarifaDia:
        // mayor que cero
        if (tarifaDia > 0) {
            this.tarifaDia = tarifaDia;
        }

        // cantidadUnidades:
        // minimo 1
        if (cantidadUnidades >= 1) {
            this.cantidadUnidades = cantidadUnidades;
        }
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

    // minimo 10 caracteres
    public void setNombre(String nombre) {

        if (nombre.length() >= 10) {
            this.nombre = nombre;
        }
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

    // maximo 500 caracteres
    public void setDescripcion(String descripcion) {

        if (descripcion.length() <= 500) {
            this.descripcion = descripcion;
        }
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public ArrayList<Destino> getSusDestinos() {
        return susDestinos;
    }

    public void setSusDestinos(ArrayList<Destino> susDestinos) {
        this.susDestinos = susDestinos;
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

    // tarifa mayor que cero
    public void setTarifaDia(int tarifaDia) {

        if (tarifaDia > 0) {
            this.tarifaDia = tarifaDia;
        }
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    // minimo 1 reserva
    public void setCantidadUnidades(int cantidadUnidades) {

        if (cantidadUnidades >= 1) {
            this.cantidadUnidades = cantidadUnidades;
        }
    }

    // calcularDuracionTotalDias
    // sumatoria dias permanencia destinos
    public int calcularDuracionTotalDias() {

        int suma = 0;

        for (Destino d : susDestinos) {

            suma += d.getDiasPermanencia();
        }

        return suma;
    }

    // calcularValorUnidad
    // depende del tipo de paquete
    // destino unico o multiple
    public abstract int calcularValorUnidad();

    // calcularValorTotal
    // valor unidad * cantidad unidades
    public int calcularValorTotal() {

        return calcularValorUnidad() * cantidadUnidades;
    }

    @Override
    public String toString() {

        return "PaqueteTuristico{"
                + "codigo=" + codigo
                + ", nombre=" + nombre
                + ", tipologiaTurismo=" + tipologiaTurismo
                + ", descripcion=" + descripcion
                + ", origen=" + origen
                + ", susDestinos=" + susDestinos
                + ", hotel=" + hotel
                + ", alimentacion=" + alimentacion
                + ", alimentacionTodo=" + alimentacionTodo
                + ", vuelo=" + vuelo
                + ", asistencia=" + asistencia
                + ", tarifaDia=" + tarifaDia
                + ", cantidadUnidades=" + cantidadUnidades
                + '}';
    }
}

