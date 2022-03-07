package com.example.springloppis.controller;

import com.example.springloppis.entity.UserEntity;
import com.example.springloppis.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController{

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public UserEntity createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

    }

    @GetMapping("{id}")
    public Optional<UserEntity> findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("")
    public Iterable<UserEntity> findAllUsers(){
        return userService.findAllUsers();
    }
}
