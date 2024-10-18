package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=50)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length=300)
    private String bio;

    private String dateOfBirth;

    @Column(length=50)
    private String nationality;
}