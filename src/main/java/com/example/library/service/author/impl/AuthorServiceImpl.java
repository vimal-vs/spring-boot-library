package com.example.library.service.author.impl;

import com.example.library.dto.AuthorDTO;
import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    private AuthorDTO convertToDTO(Author author){
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setBio(author.getBio());
        dto.setFirstName(author.getFirstName());
        dto.setLastName(author.getLastName());
        dto.setNationality(author.getNationality());
        dto.setDateOfBirth(author.getDateOfBirth());
        return dto;
    }

    private Author convertToEntity(AuthorDTO authorDTO){
        Author entity = new Author();
        entity.setId(authorDTO.getId());
        entity.setBio(authorDTO.getBio());
        entity.setFirstName(authorDTO.getFirstName());
        entity.setLastName(authorDTO.getLastName());
        entity.setNationality(authorDTO.getNationality());
        entity.setDateOfBirth(authorDTO.getDateOfBirth());
        return entity;
    }

    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return convertToDTO(author);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = convertToEntity(authorDTO);
        Author createdAuthor = authorRepository.save(author);
        return convertToDTO(createdAuthor);
    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        author.setBio(authorDTO.getBio());
        author.setDateOfBirth(authorDTO.getDateOfBirth());
        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());
        author.setNationality(authorDTO.getNationality());
        Author updatedAuthor = authorRepository.save(author);
        return convertToDTO(updatedAuthor);
    }

    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.delete(author);
    }
}
