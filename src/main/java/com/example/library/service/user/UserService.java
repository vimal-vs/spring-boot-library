package com.example.library.service.user;

import com.example.library.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(String email);
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(String email, UserDTO user);
    void deleteUser(String email);
}