package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Editora_Livro")
public class EditoraLivroModel {

    @Id
    @Column(name = "idEditoraLivro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEditora", foreignKey = @ForeignKey(name = "id_Editora"))
    private EditoraModel editora;

    @ManyToOne
    @JoinColumn(name = "idLivro", foreignKey = @ForeignKey(name = "id_EditoraLivro_Livro"))
    private LivroModel livro;
}
