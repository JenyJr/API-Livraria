package br.com.uj.livrariaapi.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Livro")
public class LivroModel {

    @Id
    @Column(name = "idLivro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private float preco;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false)
    private int estoque;

    @Column(nullable = false, length = 250)
    private String imagem;

    @Column(nullable = false, length = 30)
    private String titulo;

    @Column(nullable = false)
    private int numero_paginas;
}
