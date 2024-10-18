package com.example.library.service.publisher;

import com.example.library.dto.PublisherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<PublisherDTO> getAllPublishers();
    PublisherDTO getPublisherById(Long id);
    PublisherDTO createPublisher(PublisherDTO publisher);
    PublisherDTO updatePublisher(Long id, PublisherDTO publisher);
    void deletePublisher(Long id);
}