package br.com.uj.livrariaapi.model.dtos;

public record ListarLivrosDTO(Integer idLivro,
                              String titulo,
                              String descricao,
                              String urlImagem,
                              String linkLivro,
                              Integer paginas) {
}