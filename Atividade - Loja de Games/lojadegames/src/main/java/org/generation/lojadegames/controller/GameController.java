package org.generation.lojadegames.controller;

import org.generation.lojadegames.model.Game;
import org.generation.lojadegames.repository.GameRepository;
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
@RequestMapping("/games")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public ResponseEntity<List<Game>> getAll(){
        return ResponseEntity.ok(gameRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id){
        return gameRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Game>> getByNome(@PathVariable String nome){
        return ResponseEntity.ok(gameRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Game> post(@Valid @RequestBody Game game){
        if (generoRepository.existsById(game.getGenero().getId()))
            return ResponseEntity.status(HttpStatus.CREATED).body(gameRepository.save(game));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity<Game> put(@Valid @RequestBody Game game){
        if (gameRepository.existsById(game.getId())){

            if (generoRepository.existsById(game.getGenero().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(gameRepository.save(game));

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Optional<Game> game = gameRepository.findById(id);

        if (game.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        gameRepository.deleteById(id);
    }

}
