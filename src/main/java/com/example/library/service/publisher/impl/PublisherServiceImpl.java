package com.example.library.service.publisher.impl;

import com.example.library.dto.PublisherDTO;
import com.example.library.entity.Publisher;
import com.example.library.repository.PublisherRepository;
import com.example.library.service.publisher.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;

    private PublisherDTO convertToDTO(Publisher publisher) {
        PublisherDTO dto = new PublisherDTO();
        dto.setId(publisher.getId());
        dto.setName(publisher.getName());
        dto.setAddress(publisher.getAddress());
        dto.setPhone(publisher.getPhone());
        dto.setDescription(publisher.getDescription());
        dto.setWebsiteUrl(publisher.getWebsiteUrl());
        dto.setEmail(publisher.getEmail());
        return dto;
    }

    private Publisher convertToEntity(PublisherDTO publisherDTO) {
        Publisher entity = new Publisher();
        entity.setId(publisherDTO.getId());
        entity.setName(publisherDTO.getName());
        entity.setAddress(publisherDTO.getAddress());
        entity.setPhone(publisherDTO.getPhone());
        entity.setDescription(publisherDTO.getDescription());
        entity.setWebsiteUrl(publisherDTO.getWebsiteUrl());
        entity.setEmail(publisherDTO.getEmail());
        return entity;
    }

    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PublisherDTO getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        return convertToDTO(publisher);
    }

    public PublisherDTO createPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = convertToEntity(publisherDTO);
        Publisher createdPublisher = publisherRepository.save(publisher);
        return convertToDTO(createdPublisher);
    }

    public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        publisher.setName(publisherDTO.getName());
        publisher.setAddress(publisherDTO.getAddress());
        publisher.setPhone(publisherDTO.getPhone());
        publisher.setDescription(publisherDTO.getDescription());
        publisher.setWebsiteUrl(publisherDTO.getWebsiteUrl());
        publisher.setEmail(publisherDTO.getEmail());
        Publisher updatedPublisher = publisherRepository.save(publisher);
        return convertToDTO(updatedPublisher);
    }

    public void deletePublisher(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        publisherRepository.delete(publisher);
    }
}