package br.com.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class CadastroVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String marca;

	@NotBlank
	private String modelo;

	@NotBlank
	private String ano;
	
	@ManyToOne
	private CadastroUsuario usuario;

	@Deprecated
	public CadastroVeiculo() {

	}

	public CadastroVeiculo(String marca, String modelo, String ano, CadastroUsuario usuario) {

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

}
