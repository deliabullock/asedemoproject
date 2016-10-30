package com.therealzads.telestrations.controller;

public class User {
    private int userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }
    
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                userID, firstName, lastName);
    }
}
