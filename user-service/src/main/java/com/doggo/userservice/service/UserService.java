package com.doggo.userservice.service;

import com.doggo.userservice.dto.DogDto;
import com.doggo.userservice.dto.UserDto;
import com.doggo.userservice.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDto registerUser(UserDto userDto);

    String sendMessage(DogDto dogDto) throws JsonProcessingException;
    Optional<UserDto> getUserById(UUID id);
    Optional<UserDto> getUserByEmail(String email);
    UserDto updateUser(UserDto userDto);
    List<UserEntity> getUsers();
    void deleteUser(UUID id);
    UserDto mapUserEntityToUserDto(UserEntity userEntity);
    UserEntity mapUserDtoToUserEntity(UserDto userDto);
}
