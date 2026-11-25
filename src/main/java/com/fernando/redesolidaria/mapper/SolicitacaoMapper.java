package com.fernando.redesolidaria.mapper;

import com.fernando.redesolidaria.dto.request.SolicitacaoRequestDTO;
import com.fernando.redesolidaria.dto.response.SolicitacaoResponseDTO;
import com.fernando.redesolidaria.entity.Solicitacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SolicitacaoMapper {
    SolicitacaoResponseDTO toResponse(Solicitacao solicitacao);

    List<SolicitacaoResponseDTO> toResponseDTOList(List<Solicitacao> solicitacaoList);

    Solicitacao toEntity(SolicitacaoRequestDTO solicitacaoRequestDTO);
}
