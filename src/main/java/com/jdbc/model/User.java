package com.jdbc.model;

public class User {
    private final String name;

    public User(String user) {
        this.name = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

}
