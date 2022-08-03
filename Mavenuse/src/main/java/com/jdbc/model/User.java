package com.jdbc.model;
//getter setter
//поля нормально называть сделать приватным
//получать строковое представление объекта через toString()
public class User {

    public final String user;

    public User(String user) {
        this.user = user;
    }

    public void printUser() {
        System.out.println(user);
    }
}
