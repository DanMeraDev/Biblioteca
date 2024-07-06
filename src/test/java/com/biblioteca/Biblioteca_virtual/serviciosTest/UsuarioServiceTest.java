package com.biblioteca.Biblioteca_virtual.serviciosTest;

import com.biblioteca.Biblioteca_virtual.modelos.Facultad;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.servicios.UsuarioService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioServiceTest {
    @Autowired
    private UsuarioService usuarioService;

//    @Test
//    @Order(1)
//    public void guardarUsuario() {
//        Usuario usuario1 = new Usuario("Daniel", "dm375211@gmail.com", "asdasd", "1309321123", "1234455", Facultad.SISTEMAS, "123123", LocalDate.now());
//        Usuario usuarioGuardado = usuarioService.insertarUsuario(usuario1);
//        assertEquals(1L, usuarioGuardado.getId());
//    }
}
