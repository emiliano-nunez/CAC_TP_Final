package com.example.tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.tp.repository.PeliculaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.tp.model.Pelicula;
import java.util.Optional;
import java.util.List;


@Controller
public class PeliculaController {

    @Autowired
    PeliculaRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<Pelicula>> index() {
        List<Pelicula> peliculas = repository.findAll();
        return ResponseEntity.ok(peliculas);
    }

    @PostMapping("/guardarPeli")
    public ResponseEntity<Pelicula> guardarPelicula(@RequestBody Pelicula pelicula) {
        repository.save(pelicula);

        return ResponseEntity.ok(pelicula);
    }

    @GetMapping("/ver/{id}")
    public ResponseEntity<Pelicula> verPelicula(@PathVariable Long id) {
        Optional<Pelicula> optPeli = repository.findById(id);
        return optPeli.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/actualizarPeli/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        repository.save(pelicula);
        return ResponseEntity.ok(pelicula);
    }

    @DeleteMapping("/eliminarPeli/{id}")
    public ResponseEntity<List<Pelicula>> eliminarPelicula(@PathVariable Long id) {
        Pelicula pelicula = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id incorrecto" + id));
        repository.delete(pelicula);
        List<Pelicula> peliculas = repository.findAll();
        return ResponseEntity.ok(peliculas);
    }
}
