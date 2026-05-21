/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;


/**
 *
 * @author Juanfer
 */


public class Cliente implements Serializable {

    private char tipoIdentificacion;
    private String numeroIdentificacion;
    private boolean empresa;
    private String nombre;
    private String email;
    private String telefono;
    private String nombreContacto;
    private double porcentajeDescuento;

    // Constructor
    public Cliente(char tipoIdentificacion, String numeroIdentificacion,
                   boolean empresa, String nombre, String email,
                   String telefono, String nombreContacto,
                   double porcentajeDescuento){
        setTipoIdentificacion(tipoIdentificacion);
        setNumeroIdentificacion(numeroIdentificacion);
        setEmpresa(empresa);
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
        setNombreContacto(nombreContacto);
        setPorcentajeDescuento(porcentajeDescuento);
    }



   

    public char getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(char tipoIdentificacion) {

        tipoIdentificacion = Character.toUpperCase(tipoIdentificacion);

        if (tipoIdentificacion == 'C' || tipoIdentificacion == 'N') {
            this.tipoIdentificacion = tipoIdentificacion;
        } else {
            throw new IllegalArgumentException(
                "El tipo debe ser C (cédula) o N (NIT)"
            );
        }
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {

        
        if (!numeroIdentificacion.matches("\\d+")) {
            throw new IllegalArgumentException(
                "La identificación debe contener numeros"
            );
        }
        if (tipoIdentificacion == 'C') {

            if (numeroIdentificacion.length() < 6) {
                throw new IllegalArgumentException(
                    "La cédula debe tener mínimo 6 dígitos"
                );
            }

        } else if (tipoIdentificacion == 'N') {

            if (numeroIdentificacion.length() != 9) {
                throw new IllegalArgumentException(
                    "El NIT debe tener   9 dígitos"
                );
            }
        }

        this.numeroIdentificacion = numeroIdentificacion;
    }

    public boolean isEmpresa() {
        return empresa;
    }

    public void setEmpresa(boolean empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío"
            );
        }

        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

       
        if (telefono == null || !telefono.matches("\\d+")) {
            throw new IllegalArgumentException(
                "El teléfono solo debe contener números"
            );
        }

        this.telefono = telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        if (nombreContacto == null || nombreContacto.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre de contacto no puede estar vacio"
            );
        }

        this.nombreContacto = nombreContacto;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0.0 || porcentajeDescuento > 70.0) {
            throw new IllegalArgumentException(
                "El porcentaje de descuento debe estar entre 0.0 y 70.0"
            );
        }

        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "tipoIdentificacion=" + tipoIdentificacion + ", numeroIdentificacion=" + numeroIdentificacion + ", empresa=" + empresa + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", nombreContacto=" + nombreContacto + ", porcentajeDescuento=" + porcentajeDescuento + '}';
    }
}
