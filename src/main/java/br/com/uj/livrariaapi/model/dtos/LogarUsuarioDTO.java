package br.com.uj.livrariaapi.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LogarUsuarioDTO(@NotBlank(message = "Campo Obrigatório") @Email(message = "Formato do Email está inválido") String email,
                              @NotBlank(message = "Campo Obrigatório") String senha) {
}
