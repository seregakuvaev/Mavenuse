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
        try (Session session = utilHiber.getSession()) {
            Transaction transaction = session.beginTransaction();
            User user = new User(name);
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String name) {
        try (Session session = utilHiber.getSession()) {
            Transaction transaction = session.beginTransaction();
            Query<User> query = session.createQuery("from User where name=:name", User.class)
                    .setParameter("name", name);
            List<User> users = query.getResultList();
            session.remove(users.get(0));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable() {
        try (Session session = utilHiber.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE users( id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50) NOT NULL)").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getResult() {
        try (Session session = utilHiber.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> users = session.createQuery("from User", User.class).getResultList();
            transaction.commit();
            return (ArrayList<User>) users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTable() {
        try (Session session = utilHiber.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.createSQLQuery("DROP TABLE users").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
    }

    @Override
    public void clearTable() {
        try (Session session = utilHiber.getSession()) {
            Transaction transaction = session.beginTransaction();
            List<User> users = session.createQuery("from User", User.class).getResultList();
            for (User i: users){
                delete(i.getName());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
