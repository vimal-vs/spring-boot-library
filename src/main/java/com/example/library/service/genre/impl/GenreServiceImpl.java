package com.example.library.service.genre.impl;

import com.example.library.dto.GenreDTO;
import com.example.library.entity.Genre;
import com.example.library.repository.GenreRepository;
import com.example.library.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;

    private GenreDTO convertToDTO(Genre genre) {
        GenreDTO dto = new GenreDTO();
        dto.setId(genre.getId());
        dto.setName(genre.getName());
        dto.setDescription(genre.getDescription());
        dto.setActive(genre.isActive());
        return dto;
    }

    private Genre convertToEntity(GenreDTO genreDTO) {
        Genre entity = new Genre();
        entity.setId(genreDTO.getId());
        entity.setName(genreDTO.getName());
        entity.setDescription(genreDTO.getDescription());
        entity.setActive(genreDTO.isActive());
        return entity;
    }

    public List<GenreDTO> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public GenreDTO getGenreById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        return convertToDTO(genre);
    }

    public GenreDTO createGenre(GenreDTO genreDTO) {
        Genre genre = convertToEntity(genreDTO);
        Genre createdGenre = genreRepository.save(genre);
        return convertToDTO(createdGenre);
    }

    public GenreDTO updateGenre(Long id, GenreDTO genreDTO) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));

        genre.setName(genreDTO.getName());
        genre.setDescription(genreDTO.getDescription());
        genre.setActive(genreDTO.isActive());
        Genre updatedGenre = genreRepository.save(genre);
        return convertToDTO(updatedGenre);
    }

    public void deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genreRepository.delete(genre);
    }
}