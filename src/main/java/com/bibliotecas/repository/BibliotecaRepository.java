package com.bibliotecas.repository;

import com.bibliotecas.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

    /**
     * Trae las bibliotecas con sus libros en una sola consulta (evita el problema N+1).
     */
    @Query("select distinct b from Biblioteca b left join fetch b.libros order by b.id")
    List<Biblioteca> findAllConLibros();
}
