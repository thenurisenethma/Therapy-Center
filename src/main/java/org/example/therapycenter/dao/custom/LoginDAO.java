package org.example.therapycenter.dao.custom;

import org.example.therapycenter.dao.CrudDAO;
import org.example.therapycenter.entity.Login;

public interface LoginDAO extends CrudDAO<Login> {
    boolean checkLogin(String username, String password);


    boolean save(String username, String password, String role);
}
