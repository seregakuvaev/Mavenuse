package com.jdbc.model;

//имя юзера должно называться name

public class User {
    private final String name;

    public User(String user) {
        this.name = user;
    }

    public String toString() {
        return name;
    }

}
