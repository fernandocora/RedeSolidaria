package com.fernando.redesolidaria.mapper;

import com.fernando.redesolidaria.dto.request.DoadorRequestDTO;
import com.fernando.redesolidaria.dto.response.DoadorResponseDTO;
import com.fernando.redesolidaria.entity.Doador;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoadorMapper {
    DoadorResponseDTO toResponse(Doador doador);

    List<DoadorResponseDTO> toResponseDTOList(List<Doador> doadorList);

    Doador toEntity(DoadorRequestDTO doadorRequestDTO);

}
