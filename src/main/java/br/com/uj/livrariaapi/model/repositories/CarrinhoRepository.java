package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.CarrinhoModel;
import org.springframework.data.repository.CrudRepository;

public interface CarrinhoRepository extends CrudRepository<CarrinhoModel, Integer> {
}
