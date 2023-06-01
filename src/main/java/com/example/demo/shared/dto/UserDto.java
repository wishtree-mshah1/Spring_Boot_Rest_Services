package com.example.demo.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

    private static final long serialVersionUID = 1L;
    private long id;
    private String userId;
    private String fname;
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
