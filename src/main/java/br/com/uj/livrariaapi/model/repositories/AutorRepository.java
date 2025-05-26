package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.AutorModel;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<AutorModel, Integer> {
}
