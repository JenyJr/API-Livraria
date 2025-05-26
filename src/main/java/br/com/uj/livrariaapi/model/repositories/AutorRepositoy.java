package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.AutorModel;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepositoy extends CrudRepository<AutorModel, Integer> {
}
