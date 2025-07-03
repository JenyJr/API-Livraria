package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.dtos.LivroProjetado;
import br.com.uj.livrariaapi.model.entities.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroModel, Integer> {

    @Query("SELECT l.id as idLivro, " +
            "       l.titulo as titulo, " +
            "       l.descricao as descricao, " +
            "       l.url_imagem as urlImagem, " +
            "       l.link_Livro as linkLivro, " +
            "       l.paginas as paginas " +
            "FROM LivroModel l")
    List<LivroProjetado> procurarLivros();

    @Query("SELECT l.link_Livro FROM LivroModel l WHERE l.id = :idLivro")
    String chamarBuscarDownloadLivro(@Param("idLivro") Integer idLivro);

}