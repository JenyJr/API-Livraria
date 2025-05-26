package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.CepModel;
import org.springframework.data.repository.CrudRepository;

public interface CepRepository extends CrudRepository<CepModel, Integer> {
}
