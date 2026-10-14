package com.fernando.redesolidaria.entity;

import com.fernando.redesolidaria.enums.TipoDoador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Doador {
    @Id
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_doador", nullable = false, length = 20)
    private TipoDoador tipoDoador;

    @Column(name = "documento", nullable = true, length = 14)
    private String documento;
}
