package com.doggo.userservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID userId = UUID.randomUUID();
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private String location;
}
