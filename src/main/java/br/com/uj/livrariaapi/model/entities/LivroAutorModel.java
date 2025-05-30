package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Livro_Autor")
public class LivroAutorModel {

    @Id
    @Column(name = "idLivroAutor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idLivro", foreignKey = @ForeignKey(name = "id_LA_Livro"))
    private LivroModel livro;

    @ManyToOne
    @JoinColumn(name = "idAutor", foreignKey = @ForeignKey(name = "id_LA_Autor"))
    private AutorModel autor;
}
