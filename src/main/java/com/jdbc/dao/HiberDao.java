package com.jdbc.dao;

import com.jdbc.model.User;
import com.jdbc.util.UtilHiber;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class HiberDao implements Dao {

    UtilHiber utilHiber = new UtilHiber();

    @Override
    public void add(String name) {
        try (Session session = utilHiber.openTransactionalSession()) {
            User user = new User(name);
            session.persist(user);
            utilHiber.commitSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try (Session session = utilHiber.openTransactionalSession()) {
            Query<User> query = session.createQuery("from User where name=:name", User.class)
                    .setParameter("name", name);
            List<User> users = query.getResultList();
            System.out.println(users.get(0));
            session.remove(users.get(0));
            utilHiber.commitSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try (Session session = utilHiber.openTransactionalSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE users( id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL)");
            transaction.commit();
            //utilHiber.commitSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getResult() {
        try (Session session = utilHiber.openTransactionalSession()) {
            List<User> users = session.createQuery("from User", User.class).getResultList();
            return (ArrayList<User>) users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTable() { //2dllauto create-drop

    }

    @Override
    public void closeConnection() {
    }

    @Override
    public void clearTable() {
        try (Session session = utilHiber.openTransactionalSession()) {
            List<User> users = session.createQuery("from User", User.class).getResultList();
            for (User i: users){
                delete(i.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
