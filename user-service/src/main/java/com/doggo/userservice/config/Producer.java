package com.doggo.userservice.config;

import com.doggo.userservice.dto.DogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final KafkaTemplate<Object, Object> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(DogDto dogDto) {
        kafkaTemplate.send("user-topic", dogDto);
        return "message sent";
    }
}