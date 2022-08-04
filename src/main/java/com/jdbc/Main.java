package com.jdbc;

import com.jdbc.service.ServiceRealize;
import com.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        String[] names = {"data1", "23123123", "barbaric", "fantasy", "poop", "lol"};
        //названия имплементация обычно примерно такое ServiceImpl (название класса)
        ServiceRealize s = new ServiceRealize();

        s.newTable();
        for (String name : names) {
            s.addUser(name);
        }
        s.delUser(names[0]);
        //выводить юзера надо не через геттер, а через просто System.out.println(user);
        //проверяем добавление и удаление отдельного юзера
        for (User u : s.getname()) {
            System.out.println(u.getUser());
        }

        s.clearUsers();

        //получаем 0 юзеров тк таблица пуста
        for (User u : s.getname()) {
            System.out.println("user " + u.getUser());
        }

        s.dropTable();
        s.connectionClose();
    }
}


