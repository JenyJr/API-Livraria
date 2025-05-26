package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Endereco")
public class EnderecoModel {

    @Id
    @Column(name = "idEndereco")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "id_Usuario"))
    private UsuarioModel usuario;

    @OneToOne
    @JoinColumn(name = "idCep", foreignKey = @ForeignKey(name = "id_Cep"))
    private CepModel cep;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String complemento;



}
