package br.com.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class CadastroUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String email;
	@NotBlank
	private String cpf;
	@NotBlank
	private String dataNascimento;

	@Deprecated
	public CadastroUsuario() {

	}

	public CadastroUsuario(@NotBlank String nome, @NotBlank String email, @NotBlank String cpf,
			@NotBlank String dataNascimento) {

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

}
