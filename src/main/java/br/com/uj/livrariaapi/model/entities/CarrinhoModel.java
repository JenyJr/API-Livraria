package br.com.uj.livrariaapi.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Carrinho")
public class CarrinhoModel {

    @Id
    @Column(name = "idCarrinho")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "id_Carrinho_Usuario"))
    private UsuarioModel usuario;

    //mudar o tipo para enum
    @Column(nullable = false)
    private String status;
}
