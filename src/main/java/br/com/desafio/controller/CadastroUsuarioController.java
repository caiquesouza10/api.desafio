package br.com.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.CadastroUsuario;
import br.com.desafio.repository.CadastroUsuarioRepository;
import br.com.desafio.request.CadastroUsuarioRequest;

@RestController
@RequestMapping("/cadastro-usuario")
public class CadastroUsuarioController {
	
	@Autowired
	private CadastroUsuarioRepository repository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar (@RequestBody @Valid CadastroUsuarioRequest request) {
		
		CadastroUsuario usuario = request.toModel();
		repository.save(usuario);
		
		return ResponseEntity.ok().build();

	}
}