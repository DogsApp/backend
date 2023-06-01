package com.doggo.dogservice.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class DogDtoDeserializer implements Deserializer<DogDto> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public DogDto deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, DogDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Błąd podczas deserializacji danych JSON", e);
        }
    }

    @Override
    public void close() {
    }
}