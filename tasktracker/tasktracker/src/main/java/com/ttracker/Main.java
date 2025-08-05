package com.ttracker;

import javax.swing.SwingUtilities;

import com.ttracker.dao.*;
import com.ttracker.ui.RegistrationAndLogin;

public class Main {
    public static void main(String[] args) {
        TaskDAO.connectDAO();
        UserDAO.createUsersTableDAO();
        TaskDAO.createTaskTableDAO();
        SwingUtilities.invokeLater(() -> {
                        RegistrationAndLogin.main(new String[]{});
                    });
        System.out.println("Task Tracking System started!");
    }
}
