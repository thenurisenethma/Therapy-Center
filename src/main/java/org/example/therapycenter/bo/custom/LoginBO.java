package org.example.therapycenter.bo.custom;

public interface LoginBO {
    boolean authenticateUser(String username, String password);

    boolean saveUser(String username, String password, String role);
}
