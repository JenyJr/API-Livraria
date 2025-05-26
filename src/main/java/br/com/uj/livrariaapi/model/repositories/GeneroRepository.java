package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.GeneroModel;
import org.springframework.data.repository.CrudRepository;

public interface GeneroRepository extends CrudRepository<GeneroModel, Integer> {
}
