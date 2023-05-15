package com.doggo.userservice.service;


import com.doggo.userservice.dto.UserDto;
import com.doggo.userservice.entity.UserEntity;
import com.doggo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto registerUser(UserDto userDto) {
        UserEntity userEntity = mapUserDtoToUserEntity(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return mapUserEntityToUserDto(savedUserEntity);
    }


    public UserDto mapUserEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserId());
        userDto.setName(userEntity.getName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setEmail(userEntity.getEmail());
        userDto.setLocation(userEntity.getLocation());
        return userDto;
    }

    public UserEntity mapUserDtoToUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        if(userDto.getUserId() != null) {
            userEntity.setUserId(userDto.getUserId());
        }
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setLocation(userDto.getLocation());
        return userEntity;
    }
}
