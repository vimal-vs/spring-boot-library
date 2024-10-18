package com.example.library.service.genre;

import com.example.library.dto.GenreDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    List<GenreDTO> getAllGenres();
    GenreDTO getGenreById(Long id);
    GenreDTO createGenre(GenreDTO genre);
    GenreDTO updateGenre(Long id, GenreDTO genre);
    void deleteGenre(Long id);
}