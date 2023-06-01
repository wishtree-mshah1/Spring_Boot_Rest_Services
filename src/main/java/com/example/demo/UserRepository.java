package com.example.demo;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> 
// UserEntity - is a class of the object that needs to be persisted, and in our case it's a user entity
// Second is the data typr of ID firld, in our case, ID is alone, so i provide long
{
    
    // If you want to make any custom method you can write here
    //  UserEntity findUserByEmail(String email);
}
