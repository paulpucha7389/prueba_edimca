package com.ppucha.backend.controllers;

import com.ppucha.backend.entity.User;
import com.ppucha.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/update/{id}")
        public ResponseEntity<?> updateUser(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()){
            User user1 = user.get();
            user1.setName(user.get().getName());
            user1.setName(user.get().getPassword());
            user1.setRol(user.get().getRol());
            return ResponseEntity.ok(userService.updateUser(id, user1));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Registro eliminado");
    }
}