package com.jdbc.service;

import com.jdbc.model.User;

import java.util.ArrayList;

public interface ServiceInterface {

    void newTable();

    void delUser(String user);

    ArrayList<User> getname();

    void addUser(String name);

    void dropTable();

    void clearUsers();

    void connectionClose();

}
