package br.com.desafio.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.CadastroUsuario;
import br.com.desafio.model.CadastroVeiculo;
import br.com.desafio.repository.CadastroUsuarioRepository;
import br.com.desafio.repository.VeiculoRepository;
import br.com.desafio.request.CadastroVeiculoRequest;

@RestController
@RequestMapping("/cadastro-veiculo")
public class CadastroVeiculoController {

	@Autowired
	private VeiculoRepository repository;

	@Autowired
	private CadastroUsuarioRepository usuarioRepository;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastroVeiculoRequest request) {
		
		Optional<CadastroUsuario> usuario = usuarioRepository.findById(request.getUsuario());
		if(usuario.isPresent()) {
		CadastroVeiculo veiculo = request.toModel(usuarioRepository);
		repository.save(veiculo);

		return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.badRequest().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> listar(@PathVariable Long id) {
		Optional<CadastroUsuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {
			Optional<CadastroVeiculo> veiculo = repository.findById(id);

			return ResponseEntity.ok(veiculo);
		}

		return ResponseEntity.badRequest().build();

	}

}
