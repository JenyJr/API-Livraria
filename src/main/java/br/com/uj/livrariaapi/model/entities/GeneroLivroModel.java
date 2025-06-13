package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Livro_Genero")
public class GeneroLivroModel {

    @Id
    @Column(name = "idGeneroLivro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_GL_Livro", foreignKey = @ForeignKey(name = "id_GL_Livro"))
    private LivroModel livro;

    @ManyToOne
    @JoinColumn(name = "id_GL_Genero", foreignKey = @ForeignKey(name = "id_GL_Genero"))
    private GeneroModel genero;
}