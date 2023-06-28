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
    private Long userId;
    private String name;
    private String breed;
    private String size;
    private int age;
    private String description;
    private String imageUrl;

    @Override
    public String toString() {
        return "DogDto{" +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", size='" + size + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}