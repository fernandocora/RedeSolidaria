package com.fernando.redesolidaria.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senhaHash,
        @NotBlank String telefone,
        @NotBlank String cidade,
        @NotBlank String uf,
        String cep,
        String bairro,
        String numero,
        String logradouro
) {
}
