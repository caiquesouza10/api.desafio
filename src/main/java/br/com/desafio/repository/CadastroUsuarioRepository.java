package br.com.desafio.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Usuario;

@Repository
public interface CadastroUsuarioRepository extends CrudRepository<Usuario, Long> {
	
	Optional<Usuario> findById(Long id);

}
