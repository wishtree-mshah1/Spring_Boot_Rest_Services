package com.example.demo.service;

import org.apache.catalina.User;

import com.example.demo.shared.dto.UserDto;

public interface userService {

    UserDto createUser(UserDto user);
    UserDto getUserByUserId(String userId);
    UserDto updateUser(String userId, UserDto user);
    void deleteUser(String userId);
}
