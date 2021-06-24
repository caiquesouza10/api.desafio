package br.com.desafio.repository;

import br.com.desafio.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface VeiculoRepository extends CrudRepository<Veiculo, Long> {
    @Query(value = "SELECT * FROM Veiculo WHERE usuario_id = :id", nativeQuery = true)
    List<Veiculo> findBuscarVeiculos(@PathVariable("id") Long id);
}
