package com.doggo.dogservice.dto;

import com.doggo.dogservice.entity.Breed;
import com.doggo.dogservice.entity.DogSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DogDto {
    private UUID dogId;
    private Long userId;
    private String name;
    private String breed;
    private String size;
    private int age;
    private String description;
    private String imageUrl;
}
