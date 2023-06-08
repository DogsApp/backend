package com.doggo.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DogDto implements Serializable {
    private UUID dogId;
    private UUID userId;
    private String name;
    private int age;
    private String description;
    private String imageUrl;

    @Override
    public String toString() {
        return "DogDto{" +
                "dogId=" + dogId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}