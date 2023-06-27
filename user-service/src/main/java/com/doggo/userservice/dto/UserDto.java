package com.doggo.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private UUID userId;
    private String name;
    private String password;
    private String email;
    private String location;

    public UserDto(UUID userId, String username, String password) {
        this.userId = userId;
        this.name = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
