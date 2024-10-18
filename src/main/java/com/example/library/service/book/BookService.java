package com.example.library.service.book;

import com.example.library.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO createBook(BookDTO book);
    BookDTO updateBook(Long id, BookDTO book);
    void deleteBook(Long id);
}