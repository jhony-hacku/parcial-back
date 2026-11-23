package com.bibliotecas.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Sede de la red de bibliotecas. Una biblioteca puede tener varios libros (1:N).
 */
@Entity
@Table(name = "bibliotecas")
@Getter
@Setter
@NoArgsConstructor
public class Biblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false, length = 80)
    private String ciudad;

    @OneToMany(mappedBy = "biblioteca", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre, String direccion, String ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    /** Mantiene sincronizados ambos lados de la relación. */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        libro.setBiblioteca(this);
    }
}
