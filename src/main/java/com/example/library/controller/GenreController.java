package com.example.library.controller;

import com.example.library.dto.GenreDTO;
import com.example.library.handler.ResponseHandler;
import com.example.library.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<Object> getAllGenres() {
        List<GenreDTO> response = genreService.getAllGenres();
        return ResponseHandler.generateResponse("Genres List", HttpStatus.OK, response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getGenreById(@PathVariable Long id) {
        try {
            GenreDTO response = genreService.getGenreById(id);
            return ResponseHandler.generateResponse("Genre found", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Genre not found", HttpStatus.OK, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createGenre(@RequestBody GenreDTO genreDTO) {
        GenreDTO response = genreService.createGenre(genreDTO);
        return ResponseHandler.generateResponse("Genre created", HttpStatus.OK, response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseHandler.generateResponse("Genre deleted", HttpStatus.OK, null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateGenre(@PathVariable Long id, @RequestBody GenreDTO genreDTO) {
        GenreDTO response = genreService.updateGenre(id, genreDTO);
        return ResponseHandler.generateResponse("Genre updated", HttpStatus.OK, response);
    }
}