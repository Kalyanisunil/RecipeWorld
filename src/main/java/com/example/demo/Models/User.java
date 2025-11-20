package com.example.demo.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Entity
public class User{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Boolean isBlock;
    private Boolean isAdmin;
    private String token;

    public User(String email, Integer id, Boolean isAdmin, Boolean isBlock, String name, String password, String token) {
        this.email = email;
        this.id = id;
        this.isAdmin = isAdmin;
        this.isBlock = isBlock;
        this.name = name;
        this.password = password;
        this.token = token;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getIsBlock() {
        return isBlock;
    }
    public void setIsBlock(Boolean isBlock) {
        this.isBlock = isBlock;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", isBlock="
                + isBlock + ", isAdmin=" + isAdmin + "]";
    }





}