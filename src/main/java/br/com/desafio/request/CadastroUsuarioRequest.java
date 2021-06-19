package br.com.desafio.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.desafio.model.CadastroUsuario;

public class CadastroUsuarioRequest {
	
	@NotBlank
	private String nome;
	
	@Email
	private String email;
	
	@CPF
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

	public CadastroUsuario toModel() {
		// TODO Auto-generated method stub
		
		return new CadastroUsuario(nome, email, cpf, dataNascimento);
	}
	
	

}
