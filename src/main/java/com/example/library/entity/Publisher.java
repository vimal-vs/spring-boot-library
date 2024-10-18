package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String name;

    @Column(length=200)
    private String address;

    @Column(nullable=false, length=15)
    private String phone;

    @Column(length=500)
    private String description;

    @Column(length=100)
    private String websiteUrl;

    @Column(nullable=false, length=50)
    private String email;
}
