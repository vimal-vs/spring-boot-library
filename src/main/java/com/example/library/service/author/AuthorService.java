package com.example.library.service.author;

import com.example.library.dto.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(Long id);
    AuthorDTO createAuthor(AuthorDTO author);
    AuthorDTO updateAuthor(Long id, AuthorDTO author);
    void deleteAuthor(Long id);
}