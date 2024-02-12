package com.realtor.controller;

import com.realtor.payload.UserDto;
import com.realtor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

@Autowired
    private UserService userService;
@PostMapping
public ResponseEntity<String> createUser(@RequestBody UserDto userDto){
    long userId=userService.createUser(userDto);
    return new ResponseEntity<>("User is created  and User id is:"+userId, HttpStatus.CREATED);
}

}
