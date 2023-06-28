package com.doggo.userservice.service;

import com.doggo.userservice.config.Producer;
import com.doggo.userservice.dto.DogDto;
import com.doggo.userservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Producer producer;
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository, Producer producer) {
        this.userRepository = userRepository;
        this.producer = producer;
    }

    public String sendMessage(DogDto dogDto) throws JsonProcessingException {
        return producer.sendMessage(dogDto);
    }

}