package com.bibliotecas.service;

import com.bibliotecas.dto.BibliotecaRequest;
import com.bibliotecas.dto.BibliotecaResponse;
import com.bibliotecas.entity.Biblioteca;
import com.bibliotecas.mapper.BibliotecaMapper;
import com.bibliotecas.repository.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Gestiona el registro y la consulta de bibliotecas.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;
    private final BibliotecaMapper bibliotecaMapper;

    @Transactional
    public BibliotecaResponse registrar(BibliotecaRequest request) {
        Biblioteca guardada = bibliotecaRepository.save(bibliotecaMapper.toEntity(request));
        log.info("Biblioteca registrada con id {}", guardada.getId());
        return bibliotecaMapper.toResponse(guardada);
    }

    @Transactional(readOnly = true)
    public List<BibliotecaResponse> listar() {
        return bibliotecaRepository.findAllConLibros().stream()
                .map(bibliotecaMapper::toResponse)
                .toList();
    }
}
