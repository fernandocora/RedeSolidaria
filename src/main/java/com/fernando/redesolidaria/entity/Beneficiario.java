package com.fernando.redesolidaria.entity;

import com.fernando.redesolidaria.enums.PapelUsuario;
import com.fernando.redesolidaria.enums.TipoBeneficiario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Beneficiario extends Usuario {
    public Beneficiario() {
        super(PapelUsuario.BENEFICIARIO);
    }

    @Column(name = "tipo_beneficiario", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TipoBeneficiario tipoBeneficiario;

    @Column(name = "nivel_prioridade", nullable = false)
    private Short nivelPrioridade = 1;

    @Column(name = "verificado", nullable = false)
    private Boolean verificado = false;
}
