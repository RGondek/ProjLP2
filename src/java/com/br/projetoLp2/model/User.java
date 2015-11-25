/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLp2.model;

import java.io.Serializable;

/**
 *
 * @author 1147106
 */
public class User implements Serializable{
    private int id_user,userType;
    private String username, password;

    public User(int id_user, String username, String password,int userType) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
    
    public User(String username, String password,int userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User() {
        this.id_user = -1;
        this.username = "anonimo";
        this.password = "1234567";
    }
    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
    
    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", username=" + username + ", password=" + password + '}';
    }
    
}
