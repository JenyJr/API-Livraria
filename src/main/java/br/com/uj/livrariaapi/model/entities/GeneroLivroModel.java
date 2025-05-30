package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Genero_Livro")
public class GeneroLivroModel {

    @Id
    @Column(name = "idGeneroLivro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idLivro", foreignKey = @ForeignKey(name = "id_GL_Livro"))
    private LivroModel livro;

    @ManyToOne
    @JoinColumn(name = "idGenero", foreignKey = @ForeignKey(name = "id_GL_Genero"))
    private GeneroModel genero;
}
