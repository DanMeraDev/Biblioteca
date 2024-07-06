package com.biblioteca.Biblioteca_virtual.repositorios;

import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
