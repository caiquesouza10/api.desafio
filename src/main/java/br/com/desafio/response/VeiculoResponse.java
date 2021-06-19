package br.com.desafio.response;

import br.com.desafio.model.CadastroVeiculo;

public class VeiculoResponse {

	private String marca;
	private String modelo;
	private String ano;

	public VeiculoResponse(CadastroVeiculo cadastro) {

		this.marca = cadastro.getMarca();
		this.modelo = cadastro.getModelo();
		this.ano = cadastro.getAno();
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
