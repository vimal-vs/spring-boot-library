package com.example.library.controller;

import com.example.library.dto.AuthorDTO;
import com.example.library.handler.ResponseHandler;
import com.example.library.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<Object> getAllAuthors(@RequestParam(name = "limit", required = false) String limit) {
        List<AuthorDTO> response = authorService.getAllAuthors();
        return ResponseHandler.generateResponse("Authors List", HttpStatus.OK, response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable Long id) {
        try { // try/catch is not required for RuntimeExceptions (un-checked)
             AuthorDTO response = authorService.getAuthorById(id);
             return ResponseHandler.generateResponse("Author found", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Author not found", HttpStatus.OK, null);
        }
    }

    @PostMapping // not used "/"
    public ResponseEntity<Object> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO response = authorService.createAuthor(authorDTO);
        return ResponseHandler.generateResponse("Author created", HttpStatus.OK, response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseHandler.generateResponse("Author deleted", HttpStatus.OK, null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO){
        AuthorDTO response = authorService.updateAuthor(id, authorDTO);
        return ResponseHandler.generateResponse("Author Updated", HttpStatus.OK, response);
    }
}