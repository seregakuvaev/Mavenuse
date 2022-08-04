package com.jdbc;

import com.jdbc.service.ServiceImpl;
import com.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        String[] names = {"data1", "23123123", "barbaric", "fantasy", "poop", "lol"};

        ServiceImpl s = new ServiceImpl();

        s.newTable();
        for (String name : names) {
            s.addUser(name);
        }
        s.delUser(names[0]);

        //проверяем добавление и удаление отдельного юзера
        for (User username : s.getname()) {
            System.out.println(username);
        }

        s.clearUsers();

        //получаем 0 юзеров тк таблица пуста
        for (User username : s.getname()) {
            System.out.println("user " + username);
        }

        s.dropTable();
        s.connectionClose();
    }
}


