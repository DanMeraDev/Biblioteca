package com.biblioteca.Biblioteca_virtual.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administrador extends Persona{
    @Enumerated(EnumType.STRING)
    private JornadaLaboral jornadaLaboral;

    public Administrador() {
    }

    public Administrador(String nombre, String correo, String usuario, String clave, JornadaLaboral jornadaLaboral) {
        super(nombre, correo, usuario, clave);
        this.jornadaLaboral = jornadaLaboral;
    }

    public JornadaLaboral getJornadaLaboral() {
        return jornadaLaboral;
    }

    public void setJornadaLaboral(JornadaLaboral jornadaLaboral) {
        this.jornadaLaboral = jornadaLaboral;
    }
}
