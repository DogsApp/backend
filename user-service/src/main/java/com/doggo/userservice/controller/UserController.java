package com.doggo.userservice.controller;

import com.doggo.userservice.dto.DogDto;
import com.doggo.userservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add-dog")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> publishDog(@RequestBody DogDto dogDto) throws JsonProcessingException {
        return new ResponseEntity<>(userService.sendMessage(dogDto), HttpStatus.OK);
    }

}
