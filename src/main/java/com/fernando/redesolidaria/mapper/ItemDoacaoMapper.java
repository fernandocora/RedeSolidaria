package com.fernando.redesolidaria.mapper;

import com.fernando.redesolidaria.dto.request.ItemRequestDTO;
import com.fernando.redesolidaria.dto.response.ItemResponseDTO;
import com.fernando.redesolidaria.entity.ItemDoacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemDoacaoMapper {
    ItemResponseDTO toResponse(ItemDoacao itemDoacao);

    List<ItemResponseDTO> toResponseDTOList(List<ItemDoacao> itemDoacaoList);

    ItemDoacao toEntity(ItemRequestDTO itemRequestDTO);
}
