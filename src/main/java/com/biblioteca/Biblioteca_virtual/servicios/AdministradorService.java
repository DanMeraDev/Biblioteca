package com.biblioteca.Biblioteca_virtual.servicios;

import com.biblioteca.Biblioteca_virtual.modelos.Administrador;
import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.repositorios.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Persona> obtenerAdministradores() {
        return administradorRepository.findAll();
    }

    public Optional<Persona> obtenerAdministradorPorId(Long id) {
        return administradorRepository.findById(id);
    }

    public Optional<Administrador> obtenerAdministradorPorUsername(String usuario) {
        return administradorRepository.findByUsuario(usuario);
    }

    public Administrador guardarAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    public void actualizarAdministrador(Administrador administrador) {
        administradorRepository.save(administrador);
    }

    public void eliminarAdministrador(Long id) {
        administradorRepository.deleteById(id);
    }
}
