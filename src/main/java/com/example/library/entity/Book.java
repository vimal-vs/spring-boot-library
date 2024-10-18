package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String title;

    @Column(length=1000)
    private String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date publishedDate;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="author_id", referencedColumnName="id")
    private Author authorId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="publisher_id", referencedColumnName="id")
    private Publisher publisherId;
}