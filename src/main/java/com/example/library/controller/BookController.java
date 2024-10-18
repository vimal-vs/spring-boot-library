package com.example.library.controller;

import com.example.library.dto.BookDTO;
import com.example.library.handler.ResponseHandler;
import com.example.library.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<Object> getAllBooks() {
        List<BookDTO> response = bookService.getAllBooks();
        return ResponseHandler.generateResponse("Books List", HttpStatus.OK, response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        try {
            BookDTO response = bookService.getBookById(id);
            return ResponseHandler.generateResponse("Book found", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Book not found", HttpStatus.OK, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO response = bookService.createBook(bookDTO);
        return ResponseHandler.generateResponse("Book created", HttpStatus.OK, response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseHandler.generateResponse("Book deleted", HttpStatus.OK, null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO response = bookService.updateBook(id, bookDTO);
        return ResponseHandler.generateResponse("Book updated", HttpStatus.OK, response);
    }
}