package com.jdbc.service;

import com.jdbc.dao.DaoCommands;
import com.jdbc.model.User;

import java.util.ArrayList;

public class ServiceRealize implements ServiceInterface {

    DaoCommands dao = new DaoCommands();

    @Override
    public void newTable() {dao.createTable();}

    @Override
    public void delUser(String user) {dao.delete(user);}

    @Override
    public ArrayList<User> getname() {return dao.getResult();}

    @Override
    public void addUser(String user) {dao.add(user);}

    @Override
    public void dropTable() {dao.deleteTable();}

}
