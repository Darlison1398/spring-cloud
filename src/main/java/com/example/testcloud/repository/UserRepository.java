package com.example.testcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testcloud.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    
}
