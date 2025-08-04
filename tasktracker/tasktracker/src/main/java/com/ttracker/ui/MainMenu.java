package com.ttracker.ui;

import javax.swing.*;

public class MainMenu {

    public static void main(String[] args) {
        // Swing UI must run on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Task Tracker");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 700); // starting size, resizable

            GUIManager guiManager = new GUIManager();
            frame.setContentPane(guiManager.getMainPanel());

            frame.setLocationRelativeTo(null); // center screen
            frame.setVisible(true);
        });
    }
}
