package org.example.therapycenter.dao.impl;

import org.example.therapycenter.configuration.FactoryConfiguration;
import org.example.therapycenter.dao.custom.LoginDAO;
import org.example.therapycenter.entity.Login;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LoginDAOImpl implements LoginDAO {
    private final FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();

    @Override
    public boolean checkLogin(String username, String password) {
        Session session = factoryConfiguration.getSession();
        try {
            Query<Login> query = session.createQuery("FROM Login WHERE username = :username AND password = :password", Login.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            Login login = query.uniqueResult();
            return login != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public boolean save(String username, String password, String role) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Login login = new Login();
            login.setUsername(username);
            login.setPassword(password);
            login.setRole(role);
            session.save(login);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public boolean save(Login entity) {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Login> getAll() {
        Session session = factoryConfiguration.getSession();
        List<Login> loginList = session.createQuery("FROM Login", Login.class).list();
        session.close();
        return loginList;
    }

    @Override
    public boolean update(Login entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Login> search(String searchText) {
        return List.of();
    }
}
