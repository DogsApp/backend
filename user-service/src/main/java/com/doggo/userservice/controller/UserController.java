package com.doggo.userservice.controller;

import com.doggo.userservice.dto.UserDto;
import com.doggo.userservice.service.UserService;
import com.doggo.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        userService.registerUser(userDto);
        return new ResponseEntity<>("User added", HttpStatus.OK);
    }

    @PostMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }
    @PostMapping("/user/delete")
    public ResponseEntity<?> deleteUser(@RequestBody UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        Optional<UserDto> userDto = userService.getUserByEmail(email);
        if(userDto.isPresent()) {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
