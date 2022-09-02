package com.jdbc.service;

import com.jdbc.dao.DaoImpl;
import com.jdbc.dao.HiberDao;
import com.jdbc.model.User;

import java.util.ArrayList;

public class ServiceImpl implements ServiceInterface {

    HiberDao dao = new HiberDao();

    @Override
    public void newTable() {dao.createTable();}

    @Override
    public void delUser(String user) {dao.delete(user);}

    @Override
    public ArrayList<User> getnames() {return dao.getResult();}

    @Override
    public void addUser(String user) {dao.add(user);}

    @Override
    public void dropTable() {dao.deleteTable();}

    @Override
    public void clearUsers() {dao.clearTable();}

    @Override
    public void connectionClose() {dao.closeConnection();}
}
