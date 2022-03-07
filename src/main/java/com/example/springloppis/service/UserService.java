package com.example.springloppis.service;

import com.example.springloppis.entity.UserEntity;
import com.example.springloppis.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepo userRepo;

    public UserService(UserRepo userRepo){

        this.userRepo = userRepo;
    }

    public UserEntity createUser(UserEntity user){

        return userRepo.save(user);
    }

    public void deleteUser(Long id){

        Optional<UserEntity> foundItem = userRepo.findById(id);
        userRepo.deleteById(foundItem.get().getId());
    }

    public Optional<UserEntity> findUserById(Long id){
        return userRepo.findById(id);
    }

    public Iterable<UserEntity> findAllUsers(){
        return userRepo.findAll();
    }

}
