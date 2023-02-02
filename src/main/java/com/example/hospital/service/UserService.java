package com.example.hospital.service;

import com.example.hospital.model.user.User;
import com.example.hospital.model.user.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    public void registerUser(User user) throws Exception;


    public String loginUser(UserRequest userRequest);
}
