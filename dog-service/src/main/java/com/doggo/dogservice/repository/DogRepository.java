package com.doggo.dogservice.repository;

import com.doggo.dogservice.entity.Breed;
import com.doggo.dogservice.entity.DogEntity;
import com.doggo.dogservice.entity.DogSize;
import com.doggo.dogservice.service.DogService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DogRepository extends JpaRepository<DogEntity, UUID> {
    Optional<DogEntity> findDogEntityByName(String name);
    List<DogEntity> findAllByBreed(Breed breed);
    List<DogEntity> findAllByDogSize(DogSize size);
    List<DogEntity> findAllByUserId(UUID userId);
}
