package com.estoque.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.model.Usuario;
import com.estoque.repository.UsuarioRepositorio;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping(value="/teste")
	private ResponseEntity<String> teste() {
		return new ResponseEntity<String>("Teste usuario", HttpStatus.OK);
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario) {
		
		for (int pos = 0; pos < usuario.getTelefones().size(); pos ++) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}
		
		usuarioRepositorio.save(usuario);
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List> usuarios(){
		
		//List do java util
		List<Usuario> usuarios = (List<Usuario>) usuarioRepositorio.findAll();		
		return new ResponseEntity<List>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> usuario(@PathVariable("id") Long id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable("id") Long id) {
		usuarioRepositorio.deleteById(id);
		
		return "Ok";
	}
	
	@PutMapping("/")
	private ResponseEntity<Usuario> alterar(@RequestBody @Valid Usuario usuario) {
		
		for (int pos = 0; pos < usuario.getTelefones().size(); pos ++) {
			usuario.getTelefones().get(pos).setUsuario(usuario);
		}
		usuarioRepositorio.save(usuario);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	
	
	
}
