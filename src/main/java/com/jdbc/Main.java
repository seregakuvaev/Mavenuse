package com.jdbc;

import com.jdbc.dao.HiberDao;
import com.jdbc.service.ServiceImpl;
import com.jdbc.model.User;
import com.jdbc.util.UtilHiber;

public class Main {
    public static void main(String[] args) {
        String[] names = {"первый юзер", "23123123", "barbaric", "fantasy", "poop", "lol"};

        //ServiceImpl s = new ServiceImpl();

        //s.newTable();
        //for (String name : names) {
        //    s.addUser(name);
        //}
        //s.delUser(names[0]);

        //проверяем добавление и удаление отдельного юзера
        //for (User username : s.getname()) {
        //    System.out.println(username);
        //}

        //s.clearUsers();

        //получаем 0 юзеров тк таблица пуста
        //for (User username : s.getname()) {
        //    System.out.println("user " + username);
        //}

        //s.dropTable();
        //s.connectionClose();

        HiberDao hiberDao = new HiberDao();

        hiberDao.createTable();

        //hiberDao.add(names[0]);
//        hiberDao.add(names[1]);
//        hiberDao.add(names[2]);
//        hiberDao.add(names[3]);
//        hiberDao.add(names[4]);
//        hiberDao.add(names[5]);
//        System.out.println("-------------");
//        System.out.println(hiberDao.getResult());
//        System.out.println("-------------");
//        hiberDao.delete(names[0]);
//        System.out.println("-------------");
//        System.out.println(hiberDao.getResult());
//        System.out.println("-------------");
//        hiberDao.clearTable();
//        System.out.println("-------------");
//        System.out.println(hiberDao.getResult());
//        System.out.println("-------------");

//        hiberDao.clearTable();
        //System.out.println(hiberDao.getResult());
        //hiberDao.add(names[2]);
        //UtilHiber utilHiber = new UtilHiber();
        //utilHiber.getSessionFactory().openSession().persist(new User(names[0]));
        //for (String name : names) {
        //    hiberDao.add(name);
        //}
        //hiberDao.delete(names[0]);
        //hiberDao.delete("data1");
        //for (User username : hiberDao.getResult()) {
        //    System.out.println(username);
        //}

    }
}


