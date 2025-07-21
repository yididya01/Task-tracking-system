package com.team.tasktracker;

public enum UserType {
    ADMIN(true),
    PREMIUM(false),
    STANDARD(false);

    final private boolean isUserAdmin;

    UserType(boolean isUserAdmin){
        this.isUserAdmin = isUserAdmin;
    }
}
