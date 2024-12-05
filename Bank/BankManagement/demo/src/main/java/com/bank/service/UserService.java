package com.bank.service;

import com.bank.dao.UserDAO;
import com.bank.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public void registerUser (User user) {
        // You can add additional business logic here (e.g., password hashing)
        userDAO.registerUser (user);
    }

    public User loginUser (String username, String password) {
        User user = userDAO.getUser (username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Invalid credentials
    }
}