package com.example.testcloud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

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
    
}
