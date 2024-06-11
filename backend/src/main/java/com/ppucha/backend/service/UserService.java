package com.ppucha.backend.service;

import com.ppucha.backend.entity.User;
import com.ppucha.backend.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public List<User> getAll(){
        return userRespository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRespository.findById(id);
    }

    public User createUser(User user){
        return userRespository.save(user);
    }

    public User updateUser(Long id, User user){
        User user1 = userRespository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setRol(user.getRol());
        return userRespository.save(user1);
    }

    public void deleteUser(Long id){
        userRespository.deleteById(id);
    }

    //public User findByUserName(String name){
        //return userRespository.findByUserName(name);
    //}
}
