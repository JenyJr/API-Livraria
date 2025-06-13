package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.Column; // Importe esta anotação
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "listarLivros") // Nome da sua VIEW no MySQL
@Data
public class ListaLivroModel {

    @Id
    private Integer idLivro;

    private String titulo;
    private String descricao;

    @Column(name = "url_imagem")
    private String urlImagem;

    @Column(name = "link_livro")
    private String linkLivro;

    private Integer paginas;
}