package com.doggo.userservice.dto;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class DogDtoSerializer implements Serializer<DogDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, DogDto data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            // Obsługa błędu
            throw new RuntimeException("Błąd podczas serializacji obiektu DogDto: " + e.getMessage(), e);
        }
    }
}
