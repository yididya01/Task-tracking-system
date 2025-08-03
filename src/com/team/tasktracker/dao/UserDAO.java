package com.team.tasktracker.dao;

import com.team.tasktracker.StandardUser;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
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
