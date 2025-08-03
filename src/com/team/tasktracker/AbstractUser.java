package com.team.tasktracker;

import java.util.Map;

public abstract class AbstractUser {
    protected String firstName;
    protected String username;
    protected String email;

    AbstractUser(String firstName, String username, String email) {
        this.setFirstName(firstName);
        this.setUsername(username);
        this.setEmail(email);

    }

    private boolean isValid(String email) {
        char[] specialChars = { '!','#','/','?','~','<','>','"','`','-', '^', '%', '$', '&', '(', '*', ')' };
        String[] emailParts = email.split("@");

        if (emailParts.length != 2) {
            return false;
        }
        char first = email.charAt(0);

        for (char c : specialChars) {
            if (c == first) {
                return false;
            }
        }

        String[] domainParts = emailParts[1].split("[.]");

        if (domainParts.length <= 1) {
            return false;
        }
        return true;
    }

    void setFirstName(String firstname) {
        if (firstname != null & firstname != "") {
            this.firstName = firstname;
        } else {
            throw new Error("Invalid First Name !!!");
        }
    }

    void setUsername(String username) {
        if (username != null & username != "" & username.length() > 5) {
            this.username = username;
        } else {
            throw new Error("Invalid Username");
        }
    }

    void setEmail(String email) {

        if (isValid(email)) {
            this.email = email;
        } else {
            throw new Error("Invalid email.");
        }
    }

   public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    abstract Map<String,String> UserInformation();
}
