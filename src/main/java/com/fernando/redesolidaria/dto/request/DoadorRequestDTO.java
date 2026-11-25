package com.fernando.redesolidaria.dto.request;

import com.fernando.redesolidaria.enums.TipoDoador;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DoadorRequestDTO(
        @NotBlank @Size(max = 150) String nome,
        @NotBlank @Email @Size(max = 254) String email,
        @NotBlank @Size(min = 8, max = 72) String senha,
        @Size(max = 20) String telefone,
        @NotNull TipoDoador tipoDoador,
        @Pattern(regexp = "\\d{11}|\\d{14}", message = "Documento deve ser CPF (11) ou CNPJ (14), só dígitos") String documento,
        @NotNull @Valid EnderecoRequestDTO endereco
) {
    // o toString padrão de um record imprime a senha
    @Override
    public String toString() {
        return "DoadorRequestDTO[email=" + email + "]";
    }
}