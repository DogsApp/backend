package com.doggo.userservice.service;

import com.doggo.userservice.dto.UserDto;
import com.doggo.userservice.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    public UserDto registerUser(UserDto userDto);
    Optional<UserDto> getUserById(UUID id);
    Optional<UserDto> getUserByEmail(String email);
    UserDto updateUser(UserDto userDto);
    List<UserEntity> getUsers();
    void deleteUser(UUID id);
    UserDto mapUserEntityToUserDto(UserEntity userEntity);
    UserEntity mapUserDtoToUserEntity(UserDto userDto);
}
