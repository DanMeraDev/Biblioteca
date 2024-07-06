package com.biblioteca.Biblioteca_virtual.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "usuarios")
public class Usuario extends Persona{
    private String docIdentidad;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Facultad facultad;
    private String codigoUnico;
    private LocalDate fechaRetorno;

    public Usuario() {
    }


    public Usuario(String nombre, String correo, String clave, String docIdentidad, String telefono, Facultad facultad, String codigoUnico, LocalDate fechaRetorno) {
        super(nombre, correo, clave);
        this.docIdentidad = docIdentidad;
        this.telefono = telefono;
        this.facultad = facultad;
        this.codigoUnico = codigoUnico;
        this.fechaRetorno = fechaRetorno;
    }

    public LocalDate getFechaRetorno() {
        return fechaRetorno;
    }

    public void setFechaRetorno(LocalDate fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        this.docIdentidad = docIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
