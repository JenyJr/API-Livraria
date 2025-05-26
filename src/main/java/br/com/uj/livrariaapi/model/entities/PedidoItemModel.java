package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedido_Item")
public class PedidoItemModel {

    @Id
    @Column(name = "idItemPedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idLivro", foreignKey = @ForeignKey(name = "id_PedidoItem_Livro"))
    private LivroModel livro;

    @ManyToOne
    @JoinColumn(name = "idPedido", foreignKey = @ForeignKey(name = "id_PedidoItem_Pedido"))
    private PedidoModel pedido;
}
