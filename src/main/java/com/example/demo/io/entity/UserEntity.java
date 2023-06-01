package com.example.demo.io.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="users")
public class UserEntity implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, length = 50)
    private String fname;
    
    @Column(nullable = false, length = 50)
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
