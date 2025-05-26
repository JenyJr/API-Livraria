package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.PedidoModel;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<PedidoModel, Integer> {
}
