package com.bibliotecas.dto;

import java.util.List;

/**
 * Respuesta de una biblioteca con sus libros anidados (sin referencias circulares).
 */
public record BibliotecaResponse(
        Long id,
        String nombre,
        String direccion,
        String ciudad,
        List<LibroResumen> libros
) {
}
