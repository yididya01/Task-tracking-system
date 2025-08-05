package com.ttracker.ui;

import javax.swing.*;

import com.ttracker.dao.TaskDAO;
import com.ttracker.dao.UserDAO;
import com.ttracker.util.FileLogger;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class DashboardView extends JPanel {

    public DashboardView() {
        setLayout(new BorderLayout());
        setBackground(AppColors.BACKGROUND);

        // Top title
        JLabel titleLabel = new JLabel("Dashboard Overview", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        titleLabel.setForeground(AppColors.PRIMARY_DARK);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Center cards panel
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(AppColors.BACKGROUND);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // Task Completed Card
        String cur_email = RegistrationAndLogin.getCurrentEmail();
        Integer user_id  = UserDAO.getUserIDByEmail(cur_email);
        List<String[]> taskCreated = TaskDAO.getAllUserTasksDAO(user_id);
        int taskCreatedSize = taskCreated.size();
        String taskCrString = String.valueOf(taskCreatedSize);
        JPanel taskCard = createCard("Tasks", taskCrString);
        gbc.gridx = 0;
        gbc.gridy = 0;
        cardPanel.add(taskCard, gbc);

        // Points Earned Card
        JPanel pointsCard = createCard("Points Earned", taskCrString);
        gbc.gridx = 1;
        cardPanel.add(pointsCard, gbc);

        // Badges Card
        JPanel badgesCard = createCard("Badges", "3");
        gbc.gridx = 2;
        cardPanel.add(badgesCard, gbc);

        add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createCard(String title, String value) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(220, 160));
        card.setBackground(AppColors.PRIMARY_LIGHT);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppColors.PRIMARY_DARK, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(AppColors.PRIMARY_DARK);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 15, 0));

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
        valueLabel.setForeground(AppColors.PRIMARY);
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(titleLabel);
        card.add(valueLabel);

        return card;
    }
}
