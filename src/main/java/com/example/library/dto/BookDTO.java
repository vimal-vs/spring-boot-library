package com.example.library.dto;
import com.example.library.entity.Author;
import com.example.library.entity.Publisher;
import lombok.Data;

import java.util.Date;

@Data
public class BookDTO {
    private Long id;

    private String title;

    private String description;

    private Date publishedDate;

    private Author author;

    private Publisher publisher;
}
