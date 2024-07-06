package com.biblioteca.Biblioteca_virtual.modelos;

import java.time.LocalDate;

public class Prestamo {
    private String id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String usuario;
    private String libro;



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getLibro() {
        return libro;
    }
    public void setLibro(String libro) {
        this.libro = libro;
    }

}