package com.biblioteca.Biblioteca_virtual.repositorios;

import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByNombre(String nombre);
}
