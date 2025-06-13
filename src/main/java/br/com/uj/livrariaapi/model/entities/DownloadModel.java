package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Download")
public class DownloadModel {

    @Id
    @Column(name = "idDownload")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_Download_usuario", referencedColumnName = "idUsuario")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "id_Download_Livro", referencedColumnName = "idLivro")
    private LivroModel livro;
}
