package com.doggo.dogservice.service;

import com.doggo.dogservice.dto.DogDto;
import com.doggo.dogservice.entity.Breed;
import com.doggo.dogservice.entity.DogEntity;
import com.doggo.dogservice.entity.DogSize;
import com.doggo.dogservice.repository.DogRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class DogServiceImpl implements DogService{

    private final DogRepository dogRepository;

    @Autowired
    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    @KafkaListener(id = "groupId", topics = "user-topic", containerFactory = "factory")
    public void addDog(ConsumerRecord<String, DogDto> cr, @Payload DogDto payload) {
        dogRepository.save(mapDogDtoToDogEntity(payload));
    }

    @Override
    public void deleteDog(UUID id) {
        DogEntity dogEntity = dogRepository.getReferenceById(id);
        dogRepository.delete(dogEntity);
    }

    @Override
    public Optional<DogDto> getDogById(UUID id) {
        Optional<DogEntity> dogEntity = dogRepository.findById(id);
        return dogEntity.map(this::mapDogEntityToDogDto);
    }

    @Override
    public Optional<DogDto> getDogByName(String name) {
        Optional<DogEntity> dogEntity = dogRepository.findDogEntityByName(name);
        return dogEntity.map(this::mapDogEntityToDogDto);
    }

    @Override
    public List<DogDto> getAllDogs() {
        List<DogEntity> dogs = dogRepository.findAll();
        return dogs.stream()
                .map(this::mapDogEntityToDogDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DogDto> getAllDogsByUserId(UUID userId) {
        List<DogEntity> dogs = dogRepository.findAllByUserId(userId);
        return dogs.stream()
                .map(this::mapDogEntityToDogDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DogDto> getDogsByBreed(Breed breed) {
        List<DogEntity> dogs = dogRepository.findAllByBreed(breed);
        return dogs.stream()
                .map(this::mapDogEntityToDogDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DogDto> getDogsBySize(DogSize size) {
        List<DogEntity> dogs = dogRepository.findAllByDogSize(size);
        return dogs.stream()
                .map(this::mapDogEntityToDogDto)
                .collect(Collectors.toList());
    }

    @Override
    public DogDto mapDogEntityToDogDto(DogEntity entity) {
        return DogDto.builder()
                .dogId(entity.getDogId())
                .userId(entity.getUserId())
                .name(entity.getName())
                .dogSize(entity.getDogSize())
                .age(entity.getAge())
                .breed(entity.getBreed())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .build();
    }

    @Override
    public DogEntity mapDogDtoToDogEntity(DogDto dto) {
        return DogEntity.builder()
                .dogId(dto.getDogId())
                .userId(dto.getUserId())
                .name(dto.getName())
                .age(dto.getAge())
                .dogSize(dto.getDogSize())
                .breed(dto.getBreed())
                .description(dto.getDescription())
                .imageUrl(dto.getImageUrl())
                .build();
    }
}
