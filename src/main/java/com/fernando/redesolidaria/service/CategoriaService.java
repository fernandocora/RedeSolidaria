package com.fernando.redesolidaria.service;

import com.fernando.redesolidaria.dto.request.CategoriaRequestDTO;
import com.fernando.redesolidaria.dto.response.CategoriaResponseDTO;
import com.fernando.redesolidaria.entity.Categoria;
import com.fernando.redesolidaria.exception.ConflitoException;
import com.fernando.redesolidaria.exception.RecursoNaoEncontradoException;
import com.fernando.redesolidaria.mapper.CategoriaMapper;
import com.fernando.redesolidaria.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaResponseDTO> listar() {
        List<Categoria> categoriaList = categoriaRepository.findAll(Sort.by("nome"));
        return categoriaMapper.toResponseDTOList(categoriaList);
    }

    public CategoriaResponseDTO buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada"));

        return categoriaMapper.toResponse(categoria);
    }

    @Transactional
    public CategoriaResponseDTO criar(CategoriaRequestDTO categoriaRequestDTO) {
        String nome = categoriaRequestDTO.nome().toLowerCase(Locale.ROOT).trim();


        if (categoriaRepository.existsByNome(nome)) {
            throw new ConflitoException("Já existe uma categoria com esse nome");
        }

        Categoria categoria = categoriaMapper.toEntity(categoriaRequestDTO);
        categoria.setNome(nome);

        return categoriaMapper.toResponse(categoriaRepository.save(categoria));
    }

    @Transactional
    public CategoriaResponseDTO atualizar(Integer id) {

    }


}
