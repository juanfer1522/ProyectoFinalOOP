/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta {
    private int numero;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraActualizacion;
    private Cliente suCliente;
    private ArrayList<PaqueteTuristico> susPaquetesTuristicos;
    private char estado;

    public Venta(int numero, Cliente suCliente, ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.numero = numero;
        this.fechaHoraGeneracion = LocalDateTime.now();      // Tomada del sistema
        this.fechaHoraActualizacion = LocalDateTime.now();   // Igual a generación al crear
        this.suCliente = suCliente;
        this.susPaquetesTuristicos = susPaquetesTuristicos;
        this.estado = 'A';                                   // Valor por defecto
    }

    // ── Getters y Setters ───────────────────────────────────────────────────────

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public LocalDateTime getFechaHoraGeneracion() { return fechaHoraGeneracion; }
    public void setFechaHoraGeneracion(LocalDateTime fechaHoraGeneracion) {
        this.fechaHoraGeneracion = fechaHoraGeneracion;
    }

    public LocalDateTime getFechaHoraActualizacion() { return fechaHoraActualizacion; }
    public void setFechaHoraActualizacion(LocalDateTime fechaHoraActualizacion) {
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    public Cliente getSuCliente() { return suCliente; }
    public void setSuCliente(Cliente suCliente) { this.suCliente = suCliente; }

    public ArrayList<PaqueteTuristico> getSusPaquetesTuristicos() { return susPaquetesTuristicos; }
    public void setSusPaquetesTuristicos(ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.susPaquetesTuristicos = susPaquetesTuristicos;
    }

    public char getEstado() { return estado; }
    public void setEstado(char estado) {
        this.estado = estado;
        this.fechaHoraActualizacion = LocalDateTime.now();   // Se actualiza al cambiar estado
    }

    // ── Métodos de cálculo ──────────────────────────────────────────────────────

    /**
     * Retorna la sumatoria de las unidades de todos los paquetes incluidos.
     */
    public int calcularCantidadTotalUnidadesPaquetes() {
        int total = 0;
        for (PaqueteTuristico paquete : susPaquetesTuristicos) {
            total += paquete.getCantidadUnidades();
        }
        return total;
    }

    /**
     * Retornar la sumatoria del valor total de cada paquete incluido.
     */
public double calcularValorTotalPaquetes (){
    double total = 0;
    for (PaqueteTuristico paquete : susPaquetesTuristicos){
        total += paquete.calcularValorTotal(); // método de PaqueteTuristico
    }
    return total;
}

//Retorna el descuento: valor total de paquetes * porcentaje de descuento del cliente
 public double calcularValorDescuento() {
     return calcularValorTotalPaquetes() * suCliente.getPorcentajeDescuento();
 }
 
 //Retorna el valor a pagar: valor total de paquetes menos el descuento
 public double calcularValorTotalPagar(){
     return calcularValorTotalPaquetes() - calcularValorDescuento();
 }
    // ── toString ────────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Venta{" +
               "numero=" + numero +
               ", fechaHoraGeneracion=" + fechaHoraGeneracion +
               ", fechaHoraActualizacion=" + fechaHoraActualizacion +
               ", suCliente=" + suCliente +
               ", susPaquetesTuristicos=" + susPaquetesTuristicos +
               ", estado=" + estado +
               '}';
    }
}