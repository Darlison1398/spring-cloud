package com.example.testcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testcloud.model.UserModel;
import com.example.testcloud.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository user;

    public UserController(UserRepository user) {
        this.user = user;
    }

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel userModel) {
        return user.save(userModel);
    }

    @GetMapping("/users")
    public List<UserModel> getUsers(UserModel userModel) {
        return user.findAll();
    }

    @DeleteMapping("/deleteUserById/{id}")
    public void deleteUserById(@PathVariable Long id) {
        try {
            user.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error ao excluir usuário: " + e.getMessage());
        }
    }
    
}
