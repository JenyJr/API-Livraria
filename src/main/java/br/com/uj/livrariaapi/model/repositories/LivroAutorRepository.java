package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.LivroAutorModel;
import org.springframework.data.repository.CrudRepository;

public interface LivroAutorRepository extends CrudRepository<LivroAutorModel, Integer> {
}
