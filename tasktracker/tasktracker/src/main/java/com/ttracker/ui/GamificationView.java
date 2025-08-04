package com.ttracker.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamificationView extends JPanel {

    public GamificationView() {
        setLayout(new BorderLayout());
        setBackground(AppColors.BACKGROUND);

        // Title
        JLabel titleLabel = new JLabel("Gamification Overview");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(AppColors.TEXT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Cards
        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 20, 20));
        cardsPanel.setBackground(AppColors.BACKGROUND);
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        cardsPanel.add(createStatCard("Points", "1,200", AppColors.PRIMARY, "Total points earned by completing tasks"));
        cardsPanel.add(createStatCard("Badges", "7", AppColors.SUCCESS, "Number of achievement badges unlocked"));
        cardsPanel.add(createStatCard("Level", "5", AppColors.PRIMARY_DARK, "Current user level based on progress"));

        add(cardsPanel, BorderLayout.CENTER);
    }

    private JPanel createStatCard(String title, String value, Color bgColor, String tooltip) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(bgColor);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bgColor.darker(), 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        card.setPreferredSize(new Dimension(200, 150));
        card.setToolTipText(tooltip);

        // Hover effect
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.setBackground(bgColor.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.setBackground(bgColor);
            }
        });

        // Title + optional icon (uses emoji, or you can later use real icons)
        JLabel titleLabel = new JLabel(" " + title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        titleLabel.setIcon(getIconForTitle(title));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        valueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    // Basic icons (you can replace with real ones from resources if needed)
    private Icon getIconForTitle(String title) {
        String emoji = switch (title.toLowerCase()) {
            case "points" -> "\uD83D\uDCB0";    // money bag
            case "badges" -> "\uD83C\uDFC5";   // medal
            case "level" -> "\u2B06\uFE0F";     // arrow up
            default -> "";
        };
        return new JLabel(emoji).getIcon();
    }
}
