package br.com.desafio.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.desafio.model.CadastroVeiculo;

public interface VeiculoRepository extends CrudRepository<CadastroVeiculo, Long> {
	
	List<CadastroVeiculo> findAllBy();

}
