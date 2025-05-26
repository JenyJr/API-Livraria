package br.com.uj.livrariaapi.model.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO (String nome,
                          String senha,
                          String email,
                          String telefone,
                          @Valid @NotNull EnderecoDTO enderecoDTO) {
}
