package com.example.library.dto;

import lombok.Data;

@Data
public class GenreDTO {
    private Long id;

    private String name;

    private String description;

    private boolean isActive;
}