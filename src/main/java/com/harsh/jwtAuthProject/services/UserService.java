package com.harsh.jwtAuthProject.services;

import com.harsh.jwtAuthProject.entities.User;
import com.harsh.jwtAuthProject.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRespository userRespository;

    @Autowired
    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();
        userRespository.findAll().forEach(users::add);
        return users;
    }
}
