package com.jdbc.model;

//имя юзера должно называться name

public class User {
    private final String user;

    public User(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
