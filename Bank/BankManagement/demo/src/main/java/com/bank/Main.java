package com.bank;

import com.bank.dao.DatabaseConnection; 
import com.bank.model.User;
import com.bank.service.UserService;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        
        try {
            Connection connection = DatabaseConnection.getConnection();
            System.out.println("Database connected successfully!");
            
            
            
            UserService userService = new UserService();
            User newUser   = new User(0, "john_doe", "password123", "john@example.com", BigDecimal.ZERO);
            userService.registerUser  (newUser  );
            System.out.println("User  registered successfully!");

            
            User loggedInUser   = userService.loginUser  ("john_doe", "password123");
            if (loggedInUser   != null) {
                System.out.println("Login successful! Welcome, " + loggedInUser  .getUsername());
            } else {
                System.out.println("Invalid username or password.");
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}