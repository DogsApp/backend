package com.doggo.dogservice.controller;

import com.doggo.dogservice.dto.DogDto;
import com.doggo.dogservice.entity.Breed;
import com.doggo.dogservice.entity.DogSize;
import com.doggo.dogservice.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/dogs")
public class DogController {
    private final DogService dogService;


    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteDog(@RequestBody DogDto dogDto) {
        dogService.deleteDog(dogDto.getDogId());
        return new ResponseEntity<>("Dog deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDogById(@PathVariable UUID id) {
        Optional<DogDto> dogDto = dogService.getDogById(id);
        if(dogDto.isPresent()) {
            return new ResponseEntity<>(dogDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Dog not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getDogByName(@PathVariable String name) {
        Optional<DogDto> dogDto = dogService.getDogByName(name);
        if(dogDto.isPresent()) {
            return new ResponseEntity<>(dogDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Dog not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/breed/{breed}")
    public ResponseEntity<?> getDogsByBreed(@PathVariable String breed) {
        return new ResponseEntity<>(dogService.getDogsByBreed(Breed.valueOf(breed)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllDogs() {
        return new ResponseEntity<>(dogService.getAllDogs(), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getDogsBySize(@PathVariable String size) {
        return new ResponseEntity<>(dogService.getDogsBySize(DogSize.valueOf(size)), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAllDogsByUserId(@PathVariable UUID userId) {
        return new ResponseEntity<>(dogService.getAllDogsByUserId(userId), HttpStatus.OK);
    }


}
