package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.entity.Beneficiario;
import com.fernando.redesolidaria.enums.TipoBeneficiario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BeneficiarioRepository extends JpaRepository<Long, Beneficiario> {
    @Query("""
            select b from Beneficiario b
            where (:tipo is null or b.tipoBeneficiario = :tipo)
              and (:verificado is null or b.verificado = :verificado)
            """)
    Page<Beneficiario> buscar(@Param("tipo") TipoBeneficiario tipoBeneficiario,
                              @Param("verificado") boolean verificado,
                              Pageable pageable);
}
