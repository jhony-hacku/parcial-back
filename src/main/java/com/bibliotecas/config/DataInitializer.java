package com.bibliotecas.config;

import com.bibliotecas.entity.Biblioteca;
import com.bibliotecas.entity.Libro;
import com.bibliotecas.repository.BibliotecaRepository;
import com.bibliotecas.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Carga datos de prueba (bibliotecas y libros) usando los repositorios.
 * Solo inserta si la base está vacía, para no duplicar datos en cada arranque.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BibliotecaRepository bibliotecaRepository;
    private final LibroRepository libroRepository;

    @Override
    @Transactional
    public void run(String... args) {
        if (bibliotecaRepository.count() > 0) {
            log.info("Datos de prueba ya cargados; se omite la inicialización");
            return;
        }

        Biblioteca central = bibliotecaRepository.save(
                new Biblioteca("Biblioteca Central", "Carrera 7 # 40-62", "Bogotá"));
        Biblioteca norte = bibliotecaRepository.save(
                new Biblioteca("Biblioteca Norte", "Calle 170 # 67-51", "Bogotá"));

        Libro cienAnios = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967);
        Libro amor = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", 1985);
        central.agregarLibro(cienAnios);
        central.agregarLibro(amor);

        Libro coronel = new Libro("El coronel no tiene quien le escriba", "Gabriel García Márquez", 1961);
        Libro maria = new Libro("María", "Jorge Isaacs", 1867);
        norte.agregarLibro(coronel);
        norte.agregarLibro(maria);

        libroRepository.saveAll(List.of(cienAnios, amor, coronel, maria));
        log.info("Datos de prueba cargados: {} bibliotecas, {} libros",
                bibliotecaRepository.count(), libroRepository.count());
    }
}
