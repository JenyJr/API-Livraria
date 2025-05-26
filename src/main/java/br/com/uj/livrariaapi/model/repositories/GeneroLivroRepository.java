package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.GeneroLivroModel;
import org.springframework.data.repository.CrudRepository;

public interface GeneroLivroRepository extends CrudRepository<GeneroLivroModel, Integer> {
}
