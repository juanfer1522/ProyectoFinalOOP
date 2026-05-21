/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta implements Serializable {
    private int numero;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraActualizacion;
    private Cliente suCliente;
    private ArrayList<PaqueteTuristico> susPaquetesTuristicos;
    private char estado;

    public Venta(int numero, Cliente suCliente, ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.numero = numero;
        this.fechaHoraGeneracion = LocalDateTime.now();      
        this.fechaHoraActualizacion = LocalDateTime.now();   
        this.suCliente = suCliente;
        this.susPaquetesTuristicos = susPaquetesTuristicos;
        this.estado = 'A';                                   
    }

    

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
        estado = Character.toUpperCase(estado);

        if (estado != 'A' && estado != 'P' && estado != 'C') {
            throw new IllegalArgumentException("El estado debe ser A, P o C");
        }

        this.estado = estado;
        this.fechaHoraActualizacion = LocalDateTime.now();   
    }

   

    
    public int calcularCantidadTotalUnidadesPaquetes() {
        int total = 0;
        for (PaqueteTuristico paquete : susPaquetesTuristicos) {
            total += paquete.getCantidadUnidades();
        }
        return total;
    }

   
public double calcularValorTotalPaquetes (){
    double total = 0;
    for (PaqueteTuristico paquete : susPaquetesTuristicos){
        total += paquete.calcularValorTotal(); 
    }
    return total;
}


 public double calcularValorDescuento() {
     return calcularValorTotalPaquetes() * suCliente.getPorcentajeDescuento();
 }
 
 
 public double calcularValorTotalPagar(){
     return calcularValorTotalPaquetes() - calcularValorDescuento();
 }
    

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
