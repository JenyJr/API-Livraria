package br.com.uj.livrariaapi.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Livro")
public class LivroModel {

    @Id
    @Column(name = "idLivro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String descricao;

    @Column(nullable = false, length = 250, unique = true)
    private String url_imagem;

    @Column(nullable = false, unique = true, length = 250)
    private String link_Livro;

    @Column(nullable = false, length = 30)
    private String titulo;

    @Column(nullable = false)
    private int paginas;
}
