package com.sowfte.basiccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sowfte.basiccrud.entity.UserEntity;
import com.sowfte.basiccrud.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to server";
    }

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity payload){
        return userService.createUser(payload);
    }

    @GetMapping("/users")
    public List<UserEntity> getALLRecords(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public UserEntity getOneUser(@PathVariable Long id){
        return userService.getUserByID(id);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUserByID(id);
    }

    @PatchMapping("/users/{id}")
    public UserEntity upateUser(@RequestBody UserEntity payload, @PathVariable Long id){
        return userService.updateUserByID(payload, id);
    }
    
}
