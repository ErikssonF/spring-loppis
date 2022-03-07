package com.example.springloppis.controller;

import com.example.springloppis.entity.UserEntity;
import com.example.springloppis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController{

    UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        UserEntity createdUser = userService.createUser(user);

        logger.trace("vi loggar på TRACE-nivå");
        logger.debug("vi loggar på debug-nivå");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserEntity>> findUserById(@PathVariable Long id){
        Optional<UserEntity> foundUser = userService.findUserById(id);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<UserEntity>> findAllUsers(){
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
