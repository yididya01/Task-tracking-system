package com.ttracker;

import com.ttracker.dao.*;

public class Main {
    public static void main(String[] args) {
        TaskDAO.connectDAO();
        UserDAO.createUsersTableDAO();
        TaskDAO.createTaskTableDAO();
        System.out.println("Task Tracking System started!");
    }
}
