package com.biblioteca.Biblioteca_virtual.repositorios;


import com.biblioteca.Biblioteca_virtual.modelos.Administrador;
import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministradorRepository extends PersonaRepository{
    Optional<Administrador> findByUsuario(String usuario);
}
