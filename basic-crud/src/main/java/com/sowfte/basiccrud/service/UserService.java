package com.sowfte.basiccrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sowfte.basiccrud.entity.UserEntity;
import com.sowfte.basiccrud.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository ;

    // create user
    public UserEntity createUser(UserEntity userRecord){
       return userRepository.save(userRecord);
    }

    // get all user
    public List<UserEntity> getAllUser(){
        return userRepository.findAll();
    }

    // get user by id
    public UserEntity getUserByID(Long id){
        return userRepository.findById(id).get();
    }

    // delete user by id
    public String deleteUserByID(Long id){
        if(!userRepository.existsById(id)){
            return "User does not exist";
        }
        userRepository.deleteById(id);
        return "User successfully deleted";
    }

    // update a user by id
    public UserEntity updateUserByID(UserEntity newUserRecord, Long id){
        newUserRecord.setId(id);
         UserEntity updatedRecord = userRepository.save(newUserRecord);

         return ResponseEntity.ok(updatedRecord).getBody();
    }
    
}
