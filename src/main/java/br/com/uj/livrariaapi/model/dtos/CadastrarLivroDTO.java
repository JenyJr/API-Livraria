package br.com.uj.livrariaapi.model.dtos;

public record CadastrarLivroDTO( String descricao,
                                 String url_imagem,
                                 String link_Livro,
                                 String titulo,
                                 int paginas) {
}
