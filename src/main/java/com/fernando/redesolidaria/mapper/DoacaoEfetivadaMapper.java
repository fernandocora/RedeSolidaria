package com.fernando.redesolidaria.mapper;

import com.fernando.redesolidaria.dto.response.DoacaoResponseDTO;
import com.fernando.redesolidaria.entity.DoacaoEfetivada;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoacaoEfetivadaMapper {
    DoacaoResponseDTO toResponseDTO(DoacaoEfetivada doacaoEfetivada);

    List<DoacaoResponseDTO> toResponseDTOList(List<DoacaoEfetivada> doacaoEfetivadaList);

}
