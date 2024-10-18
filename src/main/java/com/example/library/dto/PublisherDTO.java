package com.example.library.dto;

import lombok.Data;

@Data
public class PublisherDTO {
    private Long id;

    private String name;

    private String address;

    private String phone;

    private String description;

    private String websiteUrl;

    private String email;
}