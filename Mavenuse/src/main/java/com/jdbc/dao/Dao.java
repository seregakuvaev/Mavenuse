package com.jdbc.dao;

import com.jdbc.model.User;

import java.util.ArrayList;
//why not public?
public interface Dao {

    void add(String name);

    void delete(String name);

    void createTable();

    ArrayList<User> getResult();

    void deleteTable();

}
