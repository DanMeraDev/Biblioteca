package com.biblioteca.Biblioteca_virtual.repositorios;


import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends PersonaRepository {
    Optional<Usuario> findByUsuario(String usuario);
}
