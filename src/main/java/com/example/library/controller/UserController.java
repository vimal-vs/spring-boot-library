package com.example.library.controller;

import com.example.library.dto.UserDTO;
import com.example.library.handler.ResponseHandler;
import com.example.library.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<UserDTO> response = userService.getAllUsers();
        return ResponseHandler.generateResponse("Users List", HttpStatus.OK, response);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> getUserById(@PathVariable String email) {
        try {
            UserDTO response = userService.getUserById(email);
            return ResponseHandler.generateResponse("User found", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("User not found", HttpStatus.OK, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        UserDTO response = userService.createUser(userDTO);
        return ResponseHandler.generateResponse("User created", HttpStatus.OK, response);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseHandler.generateResponse("User deleted", HttpStatus.OK, null);
    }

    @PutMapping("/{email}")
    public ResponseEntity<Object> updateUser(@PathVariable String email, @RequestBody UserDTO userDTO) {
        UserDTO response = userService.updateUser(email, userDTO);
        return ResponseHandler.generateResponse("User updated", HttpStatus.OK, response);
    }
}