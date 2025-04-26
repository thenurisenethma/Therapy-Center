package org.example.therapycenter.bo.custom.impl;

import org.example.therapycenter.bo.custom.LoginBO;
import org.example.therapycenter.dao.custom.LoginDAO;
import org.example.therapycenter.dao.impl.LoginDAOImpl;
import org.example.therapycenter.entity.Login;

public class LoginBOImpl implements LoginBO {
    private final LoginDAO loginDAO = new LoginDAOImpl();

    @Override
    public boolean authenticateUser(String username, String password) {
        return loginDAO.checkLogin(username, password);
    }

    @Override
    public boolean saveUser(String username, String password, String role) {
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        login.setRole(role);
        return loginDAO.save(login);
    }

}