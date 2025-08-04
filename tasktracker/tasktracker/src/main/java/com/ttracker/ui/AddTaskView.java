package com.ttracker.ui;


import javax.swing.*;


import java.awt.*;

public class AddTaskView extends JPanel {

    private final JTextField titleField;
    private final JTextArea descriptionArea;
    private final JSpinner user_id;
    private final JTextField dueDateField;
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

        JLabel assigned_user = new JLabel("Assigned User ID:");
        assigned_user.setForeground(AppColors.TEXT);
        SpinnerModel model = new SpinnerNumberModel(1, 0, 100, 1);
        user_id = new JSpinner(model);

        JLabel dueDateLabel = new JLabel("Due Date (YYYY-MM-DD):");
        dueDateLabel.setForeground(AppColors.TEXT);
        dueDateField = new JTextField();

        formPanel.add(titleLabel);     formPanel.add(titleField);
        formPanel.add(descLabel);      formPanel.add(descScroll);
        formPanel.add(assigned_user);  formPanel.add(user_id);
        formPanel.add(dueDateLabel);   formPanel.add(dueDateField);

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

    public String getDueDateInput() {
        return dueDateField.getText();
    }

    public Integer getUserIDInput() {
        return (Integer) user_id.getValue();
    }

    public void clearFields() {
        titleField.setText("");
        descriptionArea.setText("");
        user_id.setValue(1);
        dueDateField.setText("");
    }
}
