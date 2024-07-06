package com.biblioteca.Biblioteca_virtual;

import com.biblioteca.Biblioteca_virtual.modelos.Facultad;
import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.presentacion.SistemaBibliotecaFX;
import com.biblioteca.Biblioteca_virtual.repositorios.PersonaRepository;
import com.biblioteca.Biblioteca_virtual.repositorios.UsuarioRepository;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class BibliotecaVirtualApplication {

	public static void main(String[] args) {
//		ConfigurableApplicationContext configurableApplicationContext =
//				SpringApplication.run(BibliotecaVirtualApplication.class, args);
//		PersonaRepository usuarioRepository =
//                configurableApplicationContext.getBean(UsuarioRepository.class);
//
//		Persona usuario =
//				new Usuario("Daniel", "dm375211@gmail.com", "asdasd", "1309321123", "1234455", Facultad.SISTEMAS, "123123", LocalDate.now());
//
//		usuarioRepository.save(usuario);
		Application.launch(SistemaBibliotecaFX.class, args);
	}

}
