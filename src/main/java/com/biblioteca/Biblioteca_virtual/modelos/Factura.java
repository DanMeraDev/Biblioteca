package com.biblioteca.Biblioteca_virtual.modelos;

import java.time.LocalDate;

public class Factura {
    private String nombreUsuario;
    private LocalDate fecha;
    private Float montoPagado;

    public Factura(String nombreUsuario, LocalDate fecha, Float montoPagado) {
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.montoPagado = montoPagado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Float getMontoPagado() {
        return montoPagado;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setMontoPagado(Float montoPagado) {
        this.montoPagado = montoPagado;
    }
}