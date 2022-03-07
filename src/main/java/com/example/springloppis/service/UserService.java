package com.example.springloppis.service;

import com.example.springloppis.entity.UserEntity;
import com.example.springloppis.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    UserRepo userRepo;
    BeanScopesDemo beanScopesDemo;

    public UserService(UserRepo userRepo, BeanScopesDemo beanScopesDemo){
        this.userRepo = userRepo;
        this.beanScopesDemo = beanScopesDemo;
    }

    public UserEntity createUser(UserEntity user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id){

        UserEntity foundUser = userRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        userRepo.deleteById(foundUser.getId());
    }

    public Optional<UserEntity> findUserById(Long id){
        return userRepo.findById(id);
    }

    public Iterable<UserEntity> findAllUsers(){
        return userRepo.findAll();
    }

}
