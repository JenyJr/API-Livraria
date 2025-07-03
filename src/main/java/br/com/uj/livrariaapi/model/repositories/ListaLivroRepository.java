package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.dtos.LivroProjetado;
import br.com.uj.livrariaapi.model.entities.ListaLivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListaLivroRepository extends JpaRepository<ListaLivroModel, Integer> {

    // Query para fazer a busca pela view e juntar com as tabelas genero e autor
    @Query("SELECT ll.idLivro AS idLivro, " +
            "ll.titulo AS titulo, " +
            "ll.descricao AS descricao, " +
            "ll.urlImagem AS urlImagem, " +
            "ll.linkLivro AS linkLivro, " +
            "ll.paginas AS paginas, " +
            "a.nome AS nomeAutor, " +
            "g.categoria AS categoria " +
            "FROM ListaLivroModel ll " +
            "JOIN LivroAutorModel la ON la.livro.id = ll.idLivro " +
            "JOIN AutorModel a ON a.id = la.autor.id " +
            "JOIN GeneroLivroModel gl ON gl.livro.id = ll.idLivro " +
            "JOIN GeneroModel g ON g.id = gl.genero.id")
    List<LivroProjetado> procurarLivros();
}