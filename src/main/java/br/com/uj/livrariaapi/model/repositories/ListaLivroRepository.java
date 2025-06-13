package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.ListaLivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaLivroRepository extends JpaRepository<ListaLivroModel, Integer> {
}
