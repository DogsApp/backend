package com.doggo.userservice.service;

import com.doggo.userservice.dto.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerService {
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(DogDto dogDto) {
        kafkaTemplate.send("user-topic", dogDto);
        return "message sent";
    }
}