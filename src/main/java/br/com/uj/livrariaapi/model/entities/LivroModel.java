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
    private int preco;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private int numero_paginas;

    @Column(nullable = false)
    private String editora;


}
