package com.fernando.redesolidaria.dto.request;

import com.fernando.redesolidaria.enums.TipoBeneficiario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BeneficiarioRequestDTO(
        @NotBlank @Size(max = 150) String nome,
        @NotBlank @Email @Size(max = 254) String email,
        @NotBlank @Size(min = 8, max = 72) String senha,
        @Size(max = 20) String telefone,
        @NotNull TipoBeneficiario tipoBeneficiario,
        @NotNull @Valid EnderecoRequestDTO endereco
) {
    @Override
    public String toString() {
        return "BeneficiarioRequestDTO[email=" + email + "]";
    }
}