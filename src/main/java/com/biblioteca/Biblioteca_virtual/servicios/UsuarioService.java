package com.biblioteca.Biblioteca_virtual.servicios;

import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Persona> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Persona> obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> obtenerUsuarioPorUsername(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
