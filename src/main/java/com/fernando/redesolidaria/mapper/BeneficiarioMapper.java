package com.fernando.redesolidaria.mapper;

import com.fernando.redesolidaria.dto.request.BeneficiarioRequestDTO;
import com.fernando.redesolidaria.dto.response.BeneficiarioResponseDTO;
import com.fernando.redesolidaria.entity.Beneficiario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiarioMapper {
    BeneficiarioResponseDTO toResponse(Beneficiario beneficiario);

    List<BeneficiarioResponseDTO> toResponseDTOList(List<Beneficiario> beneficiarioList);

    Beneficiario toEntity(BeneficiarioRequestDTO beneficiarioRequestDTO);
}
