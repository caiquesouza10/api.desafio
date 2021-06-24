package br.com.desafio.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.desafio.utils.CampoUnico;
import org.hibernate.validator.constraints.br.CPF;

import br.com.desafio.model.Usuario;

public class CadastroUsuarioRequest {
	
	@NotBlank
	private String nome;
	
	@Email
	@CampoUnico(klazz = Usuario.class, name = "email")
	private String email;
	
	@CPF
	@CampoUnico(klazz = Usuario.class, name = "cpf")
	private String cpf;
	
	private String dataNascimento;

	public CadastroUsuarioRequest(@NotBlank String nome, @Email String email, @CPF String cpf,
			String dataNascimento) {
		
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "CadastroUsuarioRequest [nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}

	public Usuario toModel() {
		// TODO Auto-generated method stub
		
		return new Usuario(nome, email, cpf, dataNascimento);
	}
	
	

}
