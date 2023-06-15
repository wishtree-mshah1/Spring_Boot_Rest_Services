package com.example.demo.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.UserRepository;
import com.example.demo.io.entity.UserEntity;
import com.example.demo.service.userService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.UserDto;

import ch.qos.logback.classic.pattern.Util;

@Service
public class UserServiceImplementation implements userService {

    @Autowired
    Utils utils;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        
        //find user is already exist or not if yes then it return error
        if(userRepository.findByFname(user.getFname()) != null) throw new RuntimeException("Record already exist");
 
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);
        UserEntity  stroedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(stroedUserDetails, returnValue);

        return returnValue;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) throw new RuntimeException("Record not exist");
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
	public UserDto updateUser(String userId, UserDto user) {

        UserDto returnValue = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null) throw new RuntimeException("Record not exist");

        userEntity.setFname(user.getFname());
        userEntity.setName(user.getName());

        UserEntity  updatedUserDetails = userRepository.save(userEntity);
        BeanUtils.copyProperties(updatedUserDetails, returnValue);
        return returnValue;
    }

    @Override
    public void deleteUser(String userId) {

        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null) throw new RuntimeException("Record not exist");
        userRepository.delete(userEntity);
    }
    
    
}
