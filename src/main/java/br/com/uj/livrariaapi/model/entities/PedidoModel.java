package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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

    //TODO mudar para enum
    @Column(nullable = false, length = 2)
    private String status;

    @Column(nullable = false)
    private Date prazo_entrega;

    @Column(nullable = false)
    private Date data_compra;

}
