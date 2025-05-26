package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.ItemCarrinhoModel;
import org.springframework.data.repository.CrudRepository;

public interface ItemCarrinhoRepository extends CrudRepository<ItemCarrinhoModel, Integer> {
}
