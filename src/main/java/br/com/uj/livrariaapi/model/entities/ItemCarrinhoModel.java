package br.com.uj.livrariaapi.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_carrinho")
public class ItemCarrinhoModel {

    @Id
    @Column(name = "idItemCar")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idLivro", foreignKey = @ForeignKey(name = "id_IC_Livro"))
    private LivroModel livro;

    @ManyToOne
    @JoinColumn(name = "idCarrinho", foreignKey = @ForeignKey(name = "id_IC_Carrinho"))
    private CarrinhoModel carrinho;

    @Column(nullable = false)
    private int quantidade;
}
