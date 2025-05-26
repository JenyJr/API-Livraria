package br.com.uj.livrariaapi.model.dtos;

import br.com.uj.livrariaapi.model.entities.CepModel;
import jakarta.validation.constraints.NotBlank;

public record EnderecoDTO(@NotBlank String rua,
                          int numero,
                          @NotBlank String complemento,
                          @NotBlank String bairro,
                          @NotBlank String cidade,
                          @NotBlank String estado,
                          @NotBlank CepModel cepModel) {
}
