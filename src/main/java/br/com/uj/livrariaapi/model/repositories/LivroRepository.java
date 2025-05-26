package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.LivroModel;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<LivroModel, Integer> {
}
