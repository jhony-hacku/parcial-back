package com.bibliotecas.exception;

import java.time.Instant;
import java.util.List;

/**
 * Estructura uniforme de error devuelta por la API.
 */
public record ErrorDto(
        String code,
        String message,
        Instant timestamp,
        List<String> details
) {
    public ErrorDto(String code, String message) {
        this(code, message, Instant.now(), List.of());
    }

    public ErrorDto(String code, String message, List<String> details) {
        this(code, message, Instant.now(), details);
    }
}
