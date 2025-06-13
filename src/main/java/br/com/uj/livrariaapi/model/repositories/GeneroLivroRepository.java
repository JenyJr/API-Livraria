package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.GeneroLivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroLivroRepository extends JpaRepository<GeneroLivroModel, Integer> {

    @Query("SELECT gl FROM GeneroLivroModel gl JOIN FETCH gl.genero WHERE gl.livro.id = :livroId")
    List<GeneroLivroModel> findByLivroId(@Param("livroId") int livroId);
}