package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cep")
public class CepModel {

    @Id
    @Column(name = "idCep")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //ter acesso ao id
    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "id_Cep_Usuario"))
    private UsuarioModel usuario;

    @Column(nullable = false, length = 8)
    private char cep;

}
