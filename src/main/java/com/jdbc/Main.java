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

        ServiceImpl service = new ServiceImpl();


        service.newTable();

        service.addUser(names[0]);
        service.addUser(names[1]);
        service.addUser(names[2]);
        service.addUser(names[3]);
        service.addUser(names[4]);
        service.addUser(names[5]);
        System.out.println("-------------");
        System.out.println(service.getnames());
        System.out.println("-------------");
        service.delUser(names[0]);
        System.out.println("-------------");
        System.out.println(service.getnames());
        System.out.println("-------------");
        service.clearUsers();
        System.out.println("-------------");
        System.out.println(service.getnames());
        System.out.println("-------------");

        service.clearUsers();
        System.out.println(service.getnames());
        service.dropTable();

    }
}


