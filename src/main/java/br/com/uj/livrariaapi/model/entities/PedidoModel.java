package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedido")
public class PedidoModel {

    @Id
    @Column(name = "idPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "idCarrinho", foreignKey = @ForeignKey(name = "id_Pedido_Carrinho"))
    private CarrinhoModel carrinho;

    @OneToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "id_Pedido_Usuario"))
    private UsuarioModel usuario;

    //mudar para enum
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private char prazo_entrega;

    @Column(nullable = false)
    private char data_compra;

}
