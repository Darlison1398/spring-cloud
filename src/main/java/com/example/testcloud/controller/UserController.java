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
    public List<UserModel> getUsers() {
        return user.findAll();
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUser(@PathVariable Long id) {
        try {
            user.deleteById(id);
            System.out.println("Usuário deletado com sucesso: " + id);
        } catch (Exception e) {
            System.out.println("Usuário não encontrado: " + id);
        }
    }
    
}
