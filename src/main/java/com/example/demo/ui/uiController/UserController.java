package com.example.demo.ui.uiController;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.userService;
import com.example.demo.shared.dto.UserDto;
import com.example.demo.ui.uiModelRequest.UserDetailRequestModel;
import com.example.demo.ui.uiModelResponse.ErrorMessages;
import com.example.demo.ui.uiModelResponse.OperationalStatusModel;
import com.example.demo.ui.uiModelResponse.RequestoperationStatus;
import com.example.demo.ui.uiModelResponse.UserRest;
import com.mysql.cj.exceptions.OperationCancelledException;

//annotation
@RestController // it is able to recive HTTP request when the send and match URL path
@RequestMapping("users") // When HTTP request sent is send some URL That URLs are contain path I am creating a controller it will responsible for operations 
//http://localhost:8080/users
public class UserController {
    
    @Autowired
    userService userService;

    @GetMapping(path = "/{id}") // Have to bind with this because to make this get user respond to HTTP get request 
    // GET user info
    // Because here I am going to return string value
    public UserRest getUser(@PathVariable String id){

        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    //POST request 
    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails) throws Exception // paramater used to convert JSON request in java object
    {
        UserRest returnValue = new UserRest();

        if(userDetails.getFname().isEmpty()) throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        if(userDetails.getName().isEmpty()) throw new Exception(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto); // copies peoperties of sourse object into target object userDetails is a sourse object and userDto is a target object

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;

    }

    //PUT request
    @PutMapping(path = "/{id}")
    public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailRequestModel userDetails) // paramater used to convert JSON request in java object
    {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto); // copies peoperties of sourse object into target object userDetails is a sourse object and userDto is a target object

        UserDto updatedUser = userService.updateUser(id, userDto);
        BeanUtils.copyProperties(updatedUser, returnValue);

        return returnValue;
    }

    //DELETE request
    @DeleteMapping(path = "/{id}")
    public OperationalStatusModel deleteUser(@PathVariable String id){

        OperationalStatusModel returnValue = new OperationalStatusModel();
        returnValue.setOperationalName(RequestOperationName.DELETE.name());
        userService.deleteUser(id);
        returnValue.setOperationalResult(RequestoperationStatus.SUCCESS.name());
        return returnValue;
    }
}
