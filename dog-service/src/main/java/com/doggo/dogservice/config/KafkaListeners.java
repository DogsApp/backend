package com.doggo.dogservice.config;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "user-topic", groupId = "groupId")
    public void listen(String message){
        System.out.println("Received Message in group doggo: " + message);
    }

}
