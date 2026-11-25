package com.fernando.redesolidaria.mapper;

import com.fernando.redesolidaria.dto.request.CategoriaRequestDTO;
import com.fernando.redesolidaria.dto.response.CategoriaResponseDTO;
import com.fernando.redesolidaria.entity.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponseDTO toResponse(Categoria categoria);

    List<CategoriaResponseDTO> toResponseDTOList(List<Categoria> categoriaList);

    Categoria toEntity(CategoriaRequestDTO categoriaRequestDTO);
}
