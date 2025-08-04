package com.ttracker.abstracts;

import java.util.Map;

public abstract class AbstractUser {
    protected String firstName;
    protected String password;
    protected String email;

    public AbstractUser(String firstName, String password, String email) {
        this.setFirstName(firstName);
        this.setPassword(password);
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

    void setPassword(String password) {
        if (password != null & password != "" & password.length() > 5) {
            this.password = password;
        } else {
            throw new Error("Invalid Password");
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    public abstract Map<String,String> UserInformation();
}
