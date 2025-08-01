package com.team.tasktracker.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TaskView extends JPanel {

    private JTextField taskTitleField;
    private JComboBox<String> statusComboBox;
    private JButton addTaskButton;
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private JLabel messageLabel;

    public TaskView() {
        setLayout(new BorderLayout());
        setBackground(AppColors.BACKGROUND);

        // Title Label
        JLabel titleLabel = new JLabel("Task Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(AppColors.TEXT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Message Label
        messageLabel = new JLabel(" ");
        messageLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        messageLabel.setForeground(AppColors.ERROR);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        add(messageLabel, BorderLayout.AFTER_LAST_LINE);

        // Form Panel
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        formPanel.setBackground(AppColors.PRIMARY_LIGHT);

        JLabel taskLabel = new JLabel("Task Title:");
        taskLabel.setForeground(AppColors.TEXT);
        taskTitleField = new JTextField(20);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setForeground(AppColors.TEXT);
        statusComboBox = new JComboBox<>(new String[]{"Pending", "In Progress", "Completed"});

        addTaskButton = new JButton("Add Task");
        addTaskButton.setBackground(AppColors.PRIMARY);
        addTaskButton.setForeground(Color.WHITE);
        addTaskButton.setFocusPainted(false);
        addTaskButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        formPanel.add(taskLabel);
        formPanel.add(taskTitleField);
        formPanel.add(statusLabel);
        formPanel.add(statusComboBox);
        formPanel.add(addTaskButton);
        add(formPanel, BorderLayout.SOUTH);

        // Table
        String[] columnNames = {"Task Title", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taskTable = new JTable(tableModel);
        taskTable.setFillsViewportHeight(true);
        taskTable.setFont(new Font("SansSerif", Font.PLAIN, 13));
        taskTable.setRowHeight(22);
        taskTable.setGridColor(AppColors.PRIMARY_LIGHT);
        taskTable.setSelectionBackground(AppColors.PRIMARY_DARK);
        taskTable.setSelectionForeground(Color.WHITE);

        JScrollPane tableScrollPane = new JScrollPane(taskTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        add(tableScrollPane, BorderLayout.CENTER);

        // Button Action
        addTaskButton.addActionListener((ActionEvent e) -> {
            String title = taskTitleField.getText().trim();
            String status = (String) statusComboBox.getSelectedItem();

            if (title.isEmpty()) {
                messageLabel.setText("Task title cannot be empty.");
                messageLabel.setForeground(AppColors.ERROR);
                return;
            }

            tableModel.addRow(new Object[]{title, status});
            taskTitleField.setText("");
            statusComboBox.setSelectedIndex(0);

            messageLabel.setText("Task added successfully!");
            messageLabel.setForeground(AppColors.SUCCESS);

            Timer timer = new Timer(3000, evt -> messageLabel.setText(" "));
            timer.setRepeats(false);
            timer.start();
        });
    }
    public void addTaskToTable(String title, String status) {
        tableModel.addRow(new Object[]{title, status});
    }

    // → ADD: Helper method to show message with color and auto-clear after 3 seconds
    public void showMessage(String message, Color color) {
        messageLabel.setText(message);
        messageLabel.setForeground(color);

        Timer timer = new Timer(3000, e -> messageLabel.setText(" "));
        timer.setRepeats(false);
        timer.start();
    }
}

