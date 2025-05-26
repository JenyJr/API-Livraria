package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.EditoraLivroModel;
import org.springframework.data.repository.CrudRepository;

public interface EditoraLivroRepository extends CrudRepository<EditoraLivroModel, Integer> {
}
