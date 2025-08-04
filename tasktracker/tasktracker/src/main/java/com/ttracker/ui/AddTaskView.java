package com.team.tasktracker.ui;

import com.team.tasktracker.ui.AppColors;

import javax.swing.*;
import java.awt.*;

public class AddTaskView extends JPanel {

    private final JTextField titleField;
    private final JTextArea descriptionArea;
    private final JComboBox<String> priorityCombo;
    private final JTextField dueDateField;
    private final JComboBox<String> categoryCombo;
    private final JButton addButton;

    public AddTaskView() {
        setLayout(new BorderLayout(20, 20));
        setBackground(AppColors.BACKGROUND);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel header = new JLabel("Add New Task");
        header.setFont(new Font("SansSerif", Font.BOLD, 22));
        header.setForeground(AppColors.PRIMARY);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        add(header, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 15, 15));
        formPanel.setBackground(AppColors.BACKGROUND);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setForeground(AppColors.TEXT);
        titleField = new JTextField();

        JLabel descLabel = new JLabel("Description:");
        descLabel.setForeground(AppColors.TEXT);
        descriptionArea = new JTextArea(3, 20);
        JScrollPane descScroll = new JScrollPane(descriptionArea);

        JLabel priorityLabel = new JLabel("Priority:");
        priorityLabel.setForeground(AppColors.TEXT);
        priorityCombo = new JComboBox<>(new String[]{"Low", "Medium", "High"});

        JLabel dueDateLabel = new JLabel("Due Date (YYYY-MM-DD):");
        dueDateLabel.setForeground(AppColors.TEXT);
        dueDateField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setForeground(AppColors.TEXT);
        categoryCombo = new JComboBox<>(new String[]{"Work", "Personal", "Study", "Other"});

        formPanel.add(titleLabel);     formPanel.add(titleField);
        formPanel.add(descLabel);      formPanel.add(descScroll);
        formPanel.add(priorityLabel);  formPanel.add(priorityCombo);
        formPanel.add(dueDateLabel);   formPanel.add(dueDateField);
        formPanel.add(categoryLabel);  formPanel.add(categoryCombo);

        add(formPanel, BorderLayout.CENTER);

        addButton = new JButton("Add Task");
        addButton.setBackground(AppColors.PRIMARY);
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(AppColors.BACKGROUND);
        buttonPanel.add(addButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(AppColors.BACKGROUND);

        JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.setBackground(AppColors.BACKGROUND);
        messagePanel.add(messageLabel);

        bottomPanel.add(messagePanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

    }
    private final JLabel messageLabel = new JLabel(" ");
    public JLabel getMessageLabel() { return messageLabel; }

    public JButton getAddButton() {
        return addButton;
    }

    public String getTitleInput() {
        return titleField.getText();
    }

    public String getDescriptionInput() {
        return descriptionArea.getText();
    }

    public String getPriorityInput() {
        return (String) priorityCombo.getSelectedItem();
    }

    public String getDueDateInput() {
        return dueDateField.getText();
    }

    public String getCategoryInput() {
        return (String) categoryCombo.getSelectedItem();
    }

    public void clearFields() {
        titleField.setText("");
        descriptionArea.setText("");
        priorityCombo.setSelectedIndex(0);
        dueDateField.setText("");
        categoryCombo.setSelectedIndex(0);
    }
}
