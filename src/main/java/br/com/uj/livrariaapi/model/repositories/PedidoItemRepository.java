package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.PedidoItemModel;
import org.springframework.data.repository.CrudRepository;

public interface PedidoItemRepository extends CrudRepository<PedidoItemModel, Integer> {
}
