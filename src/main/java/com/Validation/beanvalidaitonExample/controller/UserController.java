package com.Validation.beanvalidaitonExample.controller;

import com.Validation.beanvalidaitonExample.dto.UserRequest;
import com.Validation.beanvalidaitonExample.entity.User;
import com.Validation.beanvalidaitonExample.exception.UserNotFoundException;
import com.Validation.beanvalidaitonExample.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
        System.out.println("entered the /signup endpoint");
        User savedUser = service.saveUser(userRequest);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser = service.getAllUsers();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
        return ResponseEntity.ok(service.getUser(id));
    }
}
