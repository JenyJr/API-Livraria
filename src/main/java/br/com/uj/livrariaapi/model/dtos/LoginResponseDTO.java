package br.com.uj.livrariaapi.model.dtos;

import jakarta.validation.constraints.NotBlank;

public record LoginResponseDTO(@NotBlank String status,
                               Integer idUsuario,
                               String nome) {
}
