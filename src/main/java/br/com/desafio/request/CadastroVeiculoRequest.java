package br.com.desafio.request;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import br.com.desafio.model.CadastroUsuario;
import br.com.desafio.model.CadastroVeiculo;
import br.com.desafio.repository.CadastroUsuarioRepository;

public class CadastroVeiculoRequest {

	@NotBlank
	private String marca;

	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;
	
	private Long usuario;

	public CadastroVeiculoRequest(String marca, String modelo, String ano, Long usuario) {

		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.usuario = usuario;

	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getAno() {
		return ano;
	}
	
	public Long getUsuario() {
		return usuario;
	}

	@Override
	public String toString() {
		return "CadastroVeiculoRequest [marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + "]";
	}

	public CadastroVeiculo toModel(CadastroUsuarioRepository usuarioRepository) {
		Optional<CadastroUsuario> cadastroUsuario = usuarioRepository.findById(usuario);
		return new CadastroVeiculo(marca, modelo, ano, cadastroUsuario.get());
	}

}
