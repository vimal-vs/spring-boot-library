package com.example.library.service.book.impl;

import com.example.library.dto.BookDTO;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setPublishedDate(book.getPublishedDate());
        dto.setAuthor(book.getAuthorId());
        dto.setPublisher(book.getPublisherId());
        return dto;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book entity = new Book();
        entity.setId(bookDTO.getId());
        entity.setTitle(bookDTO.getTitle());
        entity.setDescription(bookDTO.getDescription());
        entity.setPublishedDate((Date) bookDTO.getPublishedDate()); // asked for sql date
        entity.setAuthorId(bookDTO.getAuthor());
        entity.setPublisherId(bookDTO.getPublisher());
        return entity;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return convertToDTO(book);
    }

    public BookDTO createBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        Book createdBook = bookRepository.save(book);
        return convertToDTO(createdBook);
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDTO.getTitle());
        book.setDescription(bookDTO.getDescription());
        book.setAuthorId(bookDTO.getAuthor());
        book.setPublisherId(bookDTO.getPublisher());
        book.setPublishedDate((Date) bookDTO.getPublishedDate()); // sql date
        Book updatedBook = bookRepository.save(book);
        return convertToDTO(updatedBook);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(book);
    }
}