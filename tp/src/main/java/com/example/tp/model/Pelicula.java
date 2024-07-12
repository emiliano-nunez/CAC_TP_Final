package com.example.tp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String date;

    public Pelicula() {
    }

    public Pelicula(String titulo, String descripcion, String date) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.date = date;
    }
}
