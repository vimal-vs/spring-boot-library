package com.example.library.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean isMember;
}