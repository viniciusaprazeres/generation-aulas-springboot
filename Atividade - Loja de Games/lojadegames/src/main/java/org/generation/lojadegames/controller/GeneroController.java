package org.generation.lojadegames.controller;

import org.generation.lojadegames.model.Genero;
import org.generation.lojadegames.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public ResponseEntity<List<Genero>> getAll(){
        return ResponseEntity.ok(generoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getById(@PathVariable Long id){
        return generoRepository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Genero>> getByTitle(@PathVariable String genero){
        return ResponseEntity.ok(generoRepository
                .findAllByGeneroContainingIgnoreCase(genero));
    }

    @PostMapping
    public ResponseEntity<Genero> post(@Valid @RequestBody Genero genero){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(generoRepository.save(genero));
    }

    @PutMapping
    public ResponseEntity<Genero> put(@Valid @RequestBody Genero genero){
        return generoRepository.findById(genero.getId())
                .map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(generoRepository.save(genero)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Genero> genero = generoRepository.findById(id);

        if(genero.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        generoRepository.deleteById(id);
    }

}
