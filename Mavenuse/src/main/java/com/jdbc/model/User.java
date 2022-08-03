package com.jdbc.model;

public class User {
    public final String user;

    public User(String user) {
        this.user = user;
    }

    public void printUser() {
        System.out.println(user);
    }
}
