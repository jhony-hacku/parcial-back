package com.bibliotecas.controller;

import com.bibliotecas.dto.BibliotecaRequest;
import com.bibliotecas.dto.BibliotecaResponse;
import com.bibliotecas.service.BibliotecaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bibliotecas")
@RequiredArgsConstructor
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    /** POST /bibliotecas — Registrar biblioteca. */
    @PostMapping
    public ResponseEntity<BibliotecaResponse> registrar(@Valid @RequestBody BibliotecaRequest request) {
        BibliotecaResponse creada = bibliotecaService.registrar(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creada.id())
                .toUri();
        return ResponseEntity.created(location).body(creada);
    }

    /** GET /bibliotecas — Consultar bibliotecas, incluyendo sus libros asociados. */
    @GetMapping
    public ResponseEntity<List<BibliotecaResponse>> listar() {
        return ResponseEntity.ok(bibliotecaService.listar());
    }
}
