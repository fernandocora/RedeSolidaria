package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoRequestDTO(
        @Size(max = 150) String logradouro,
        @Size(max = 10) String numero,
        @Size(max = 80) String bairro,
        @NotBlank @Size(max = 80) String cidade,
        @NotBlank @Pattern(regexp = "[A-Z]{2}", message = "UF deve ter 2 letras maiúsculas") String uf,
        @Pattern(regexp = "\\d{8}", message = "CEP deve ter 8 dígitos") String cep
) {
}