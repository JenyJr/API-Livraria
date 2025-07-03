package br.com.uj.livrariaapi.model.dtos;

public interface LivroProjetado {
    int getIdLivro();
    String getTitulo();
    String getDescricao();
    String getUrlImagem();
    String getLinkLivro();
    int getPaginas();
    String getNomeAutor();
    String getCategoria();
}