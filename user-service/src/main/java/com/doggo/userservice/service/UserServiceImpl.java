package com.doggo.userservice.service;


import com.doggo.userservice.dto.UserDto;
import com.doggo.userservice.entity.UserEntity;
import com.doggo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto registerUser(UserDto userDto) {
        UserEntity userEntity = mapUserDtoToUserEntity(userDto);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return mapUserEntityToUserDto(savedUserEntity);
    }

    @Override
    public Optional<UserDto> getUserById(UUID id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(this::mapUserEntityToUserDto);
    }

    @Override
    public Optional<UserDto> getUserByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        return userEntity.map(this::mapUserEntityToUserDto);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserEntity userEntity = mapUserDtoToUserEntity(userDto);
        userRepository.save(userEntity);
        return userDto;
    }
    @Override
    public UserDto mapUserEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userEntity.getUserId());
        userDto.setName(userEntity.getName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setEmail(userEntity.getEmail());
        userDto.setLocation(userEntity.getLocation());
        return userDto;
    }

    @Override
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
