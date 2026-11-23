package com.bibliotecas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Datos de entrada para registrar una biblioteca.
 */
public record BibliotecaRequest(
        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
        String nombre,

        @NotBlank(message = "La dirección es obligatoria")
        @Size(max = 150, message = "La dirección no puede superar 150 caracteres")
        String direccion,

        @NotBlank(message = "La ciudad es obligatoria")
        @Size(max = 80, message = "La ciudad no puede superar 80 caracteres")
        String ciudad
) {
}
