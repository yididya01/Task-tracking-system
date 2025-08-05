package com.ttracker;

import com.ttracker.dao.*;
import com.ttracker.ui.MainMenu;

public class Main {
    public static void main(String[] args) {
        // Initialize database
        TaskDAO.connectDAO();
        UserDAO.createUsersTableDAO();
        TaskDAO.createTaskTableDAO();
        System.out.println("Task Tracking System started!");

        // Launch GUI
        MainMenu.launch(); // call a new static method in MainMenu
    }
}
