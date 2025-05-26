package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.EnderecoModel;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<EnderecoModel, Integer> {
}
