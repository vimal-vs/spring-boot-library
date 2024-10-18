package com.example.library.controller;

import com.example.library.dto.PublisherDTO;
import com.example.library.handler.ResponseHandler;
import com.example.library.service.publisher.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public ResponseEntity<Object> getAllPublishers() {
        List<PublisherDTO> response = publisherService.getAllPublishers();
        return ResponseHandler.generateResponse("Publishers List", HttpStatus.OK, response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPublisherById(@PathVariable Long id) {
        try {
            PublisherDTO response = publisherService.getPublisherById(id);
            return ResponseHandler.generateResponse("Publisher found", HttpStatus.OK, response);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Publisher not found", HttpStatus.OK, null);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createPublisher(@RequestBody PublisherDTO publisherDTO) {
        PublisherDTO response = publisherService.createPublisher(publisherDTO);
        return ResponseHandler.generateResponse("Publisher created", HttpStatus.OK, response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return ResponseHandler.generateResponse("Publisher deleted", HttpStatus.OK, null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        PublisherDTO response = publisherService.updatePublisher(id, publisherDTO);
        return ResponseHandler.generateResponse("Publisher updated", HttpStatus.OK, response);
    }
}