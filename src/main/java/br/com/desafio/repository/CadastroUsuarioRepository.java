package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.CadastroUsuario;

@Repository
public interface CadastroUsuarioRepository extends CrudRepository<CadastroUsuario, Long> {
	
	Optional<CadastroUsuario> findById(Long id);

}
