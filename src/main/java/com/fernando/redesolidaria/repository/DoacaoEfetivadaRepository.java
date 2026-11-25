package com.fernando.redesolidaria.repository;

import com.fernando.redesolidaria.dto.response.DoacaoPorCategoriaDTO;
import com.fernando.redesolidaria.dto.response.ResumoDoacoesDTO;
import com.fernando.redesolidaria.entity.DoacaoEfetivada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface DoacaoEfetivadaRepository extends JpaRepository<DoacaoEfetivada, Long> {

    boolean existsBySolicitacaoId(Long solicitacaoId);

    @EntityGraph(attributePaths = {"itemDoacao", "doador", "beneficiario"})
    Page<DoacaoEfetivada> findByBeneficiarioId(Long beneficiarioId, Pageable pageable);

    @EntityGraph(attributePaths = {"itemDoacao", "doador", "beneficiario"})
    Page<DoacaoEfetivada> findByDoadorId(Long doadorId, Pageable pageable);

    // intervalo meio-aberto [inicio, fim)
    @EntityGraph(attributePaths = {"itemDoacao", "doador", "beneficiario"})
    @Query("""
            select d from DoacaoEfetivada d
            where d.dataEntrega >= :inicio and d.dataEntrega < :fim
            """)
    Page<DoacaoEfetivada> buscarPorPeriodo(@Param("inicio") LocalDateTime inicio,
                                           @Param("fim") LocalDateTime fim,
                                           Pageable pageable);

    // relatório: total de doações e de unidades no período
    @Query("""
            select new com.fernando.redesolidaria.dto.response.ResumoDoacoesDTO(
                count(d), coalesce(sum(d.quantidade), 0L))
            from DoacaoEfetivada d
            where d.dataEntrega >= :inicio and d.dataEntrega < :fim
            """)
    ResumoDoacoesDTO resumoPorPeriodo(@Param("inicio") LocalDateTime inicio,
                                      @Param("fim") LocalDateTime fim);

    // relatório: doações agrupadas por categoria
    @Query("""
            select new com.fernando.redesolidaria.dto.response.DoacaoPorCategoriaDTO(
                c.nome, count(d), sum(d.quantidade))
            from DoacaoEfetivada d
            join d.item i
            join i.categoria c
            where d.dataEntrega >= :inicio and d.dataEntrega < :fim
            group by c.nome
            order by sum(d.quantidade) desc
            """)
    List<DoacaoPorCategoriaDTO> totalPorCategoria(@Param("inicio") LocalDateTime inicio,
                                                  @Param("fim") LocalDateTime fim);
}