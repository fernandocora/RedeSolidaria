package com.fernando.redesolidaria.entity;

import com.fernando.redesolidaria.enums.PapelUsuario;
import com.fernando.redesolidaria.enums.TipoDoador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Doador extends Usuario {
    public Doador() {
        super(PapelUsuario.DOADOR);
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_doador", nullable = false, length = 20)
    private TipoDoador tipoDoador;

    @Column(name = "documento", length = 14)
    private String documento;
}
