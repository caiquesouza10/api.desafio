package br.com.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.Veiculo;
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
		Veiculo veiculo = request.toModel(usuarioRepository);
		int dia = Integer.parseInt(request.getAno().substring(3));
		veiculo.setRodizio(veiculo.adicionaDiaRodizio(dia));
		repository.save(veiculo);
		return ResponseEntity.status(201).body(veiculo.toString());
	}

	@GetMapping("/{id}")
	public List<Veiculo> listar(@PathVariable Long id) {
		List<Veiculo> veiculo = repository.findBuscarVeiculos(id);
		Veiculo.verificaRodizioAtivo(veiculo);
		return veiculo;
	}

}
