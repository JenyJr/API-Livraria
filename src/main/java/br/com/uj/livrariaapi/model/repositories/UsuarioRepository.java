package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {
}
