package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.master.UserRepository;


/**
 * UserService
 */
public class UserService {
    
    protected UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }
}

