package com.doggo.dogservice.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "dogs")
public class DogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID dogId = UUID.randomUUID();
    @Nonnull
    private Long userId;
    @Nonnull
    private String name;
    private String breed;
    private String dogSize;
    private int age;
    private String description;
    private String imageUrl;

}
