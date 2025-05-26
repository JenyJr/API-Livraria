package br.com.uj.livrariaapi.model.dtos;

import br.com.uj.livrariaapi.model.entities.CepModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(@NotBlank String rua,
                          int numero,
                          @NotBlank String complemento,
                          @NotBlank String bairro,
                          @NotBlank String cidade,
                          @NotBlank String estado) {
}
