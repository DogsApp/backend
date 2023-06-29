package com.doggo.userservice.service;

import com.doggo.userservice.dto.DogDto;
import com.doggo.userservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final KafkaProducerService kafkaProducerService;
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository, KafkaProducerService kafkaProducerService) {
        this.userRepository = userRepository;
        this.kafkaProducerService = kafkaProducerService;
    }

    public String sendMessage(DogDto dogDto) throws JsonProcessingException {
        return kafkaProducerService.sendMessage(dogDto);
    }

}