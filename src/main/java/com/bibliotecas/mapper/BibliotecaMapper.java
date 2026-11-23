package com.bibliotecas.mapper;

import com.bibliotecas.dto.BibliotecaRequest;
import com.bibliotecas.dto.BibliotecaResponse;
import com.bibliotecas.dto.LibroResumen;
import com.bibliotecas.entity.Biblioteca;
import com.bibliotecas.entity.Libro;
import org.springframework.stereotype.Component;

/**
 * Mapeo explícito entre entidades y DTO. El id nunca se copia desde la solicitud.
 */
@Component
public class BibliotecaMapper {

    public Biblioteca toEntity(BibliotecaRequest request) {
        return new Biblioteca(
                request.nombre().trim(),
                request.direccion().trim(),
                request.ciudad().trim()
        );
    }

    public BibliotecaResponse toResponse(Biblioteca biblioteca) {
        return new BibliotecaResponse(
                biblioteca.getId(),
                biblioteca.getNombre(),
                biblioteca.getDireccion(),
                biblioteca.getCiudad(),
                biblioteca.getLibros().stream().map(this::toResumen).toList()
        );
    }

    public LibroResumen toResumen(Libro libro) {
        return new LibroResumen(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getAnioPublicacion()
        );
    }
}
