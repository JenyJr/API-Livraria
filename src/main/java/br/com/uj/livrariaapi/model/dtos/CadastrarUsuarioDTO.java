package br.com.uj.livrariaapi.model.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarUsuarioDTO(@NotBlank String nome,
                                  @NotBlank String senha,
                                  @Email String email) {

    
}
