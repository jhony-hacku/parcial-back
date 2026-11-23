package com.bibliotecas.dto;

/**
 * Proyección ligera de un libro, sin la referencia de vuelta a la biblioteca.
 */
public record LibroResumen(
        Long id,
        String titulo,
        String autor,
        Integer anioPublicacion
) {
}
