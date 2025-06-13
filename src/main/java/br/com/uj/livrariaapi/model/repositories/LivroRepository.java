package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Importe esta anotação
import org.springframework.data.repository.query.Param; // Importe esta anotação
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {

    @Query(value = "SELECT buscarDownloadLivro(:i_idLivro, :i_idUsuario)", nativeQuery = true)
    String chamarBuscarDownloadLivro(
            @Param("i_idLivro") Integer idLivro,
            @Param("i_idUsuario") Integer idUsuario
    );
}