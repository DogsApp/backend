package com.doggo.dogservice.service;

import com.doggo.dogservice.dto.DogDto;
import com.doggo.dogservice.entity.Breed;
import com.doggo.dogservice.entity.DogEntity;
import com.doggo.dogservice.entity.DogSize;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DogService {
    void addDog(ConsumerRecord<String, DogDto> cr, @Payload DogDto payload);
    void deleteDog(UUID id);
    Optional<DogDto> getDogById(UUID id);
    Optional<DogDto> getDogByName(String name);
    List<DogDto> getAllDogsByUserId(UUID userId);
    List<DogDto> getAllDogs();
    List<DogDto> getDogsByBreed(Breed breed);
    List<DogDto> getDogsBySize(DogSize size);
    DogDto mapDogEntityToDogDto(DogEntity entity);
    DogEntity mapDogDtoToDogEntity(DogDto dto);
}
