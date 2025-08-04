package com.ttracker.dao;

import com.ttracker.models.StandardUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {

         
    public static void createUsersTableDAO() {
        String url = "jdbc:sqlite:database.db";
        String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + " user_id INTEGER PRIMARY KEY,\n"
                + " first_name TEXT NOT NULL,\n"
                + " user_email TEXT NOT NULL,\n"
                + " user_password TEXT,\n"
                + " task_points INTEGER DEFAULT 0,\n"
                + " user_type TEXT DEFAULT 'STANDARD',\n"
                + " created_at TEXT NOT NULL DEFAULT (STRFTIME('%Y-%m-%d %H:%M:%S', 'NOW')),\n"
                + " CHECK(user_type IN ('ADMIN', 'PREMIUM', 'STANDARD'))\n"
                + ");";
 
        try (Connection conn = DriverManager.getConnection(url);
             java.sql.Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Users Table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


         
    public static void addUserDAO(String firstName, String userEmail,String password) {
        String url = "jdbc:sqlite:database.db";
        String sql = "INSERT INTO Users(first_name, user_email,user_password) VALUES(?,?,?)";
 
        try (Connection conn = DriverManager.getConnection(url);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, userEmail);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            System.out.println("User added succesfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
    }



    
    public static boolean LoginDAO(String email, String password) {
        String url = "jdbc:sqlite:database.db";
        String sql = "SELECT * FROM Users WHERE user_email = ? AND user_password = ?";
 
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)
             ) {
                pstmt.setString(1, email);
                pstmt.setString(2, password);
                java.sql.ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                System.out.println("User Exists: " + rs.getString("first_name"));
                return true;
            } else {
                System.out.println("User not found.");
                return false;
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

























    // Simple in-memory storage of users by email (unique identifier)
    private Map<String, StandardUser> users = new HashMap<>();

    // Save a new user
    public void save(StandardUser user) {
        if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User or email cannot be null");
        }
        users.put(user.getEmail(), user);
    }

    // Find a user by email
    public StandardUser findByEmail(String email) {
        if (email == null) {
            return null;
        }
        return users.get(email);
    }

    // Update an existing user
    public void update(StandardUser user) {
        if (user == null || user.getEmail() == null) {
            throw new IllegalArgumentException("User or email cannot be null");
        }
        if (!users.containsKey(user.getEmail())) {
            throw new IllegalArgumentException("User not found: " + user.getEmail());
        }
        users.put(user.getEmail(), user);
    }

    // Delete a user by email
    public void delete(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        users.remove(email);
    }
}
