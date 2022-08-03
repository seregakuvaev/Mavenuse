package com.jdbc;

import com.jdbc.service.ServiceRealize;
import com.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        String[] names = {"data1", "23123123", "barbaric", "fantasy", "poop", "lol"};

        ServiceRealize s = new ServiceRealize();

        s.newTable();
        for (String name : names) {
            s.addUser(name);
        }
        s.delUser(names[0]);
        for (User u: s.getname()){
            u.printUser();
        }

        s.dropTable();
    }
}


