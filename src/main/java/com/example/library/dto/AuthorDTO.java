package com.example.library.dto;
import lombok.Data;

@Data
public class AuthorDTO{
    private Long id;

    private String firstName;

    private String lastName;

    private String bio;

    private String dateOfBirth;

    private String nationality;
}
