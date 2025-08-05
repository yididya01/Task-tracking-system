package com.ttracker.ui;

import javax.swing.*;

import com.ttracker.dao.TaskDAO;
import com.ttracker.dao.UserDAO;

import java.awt.*;

public class GUIManager {

    private static final String DASHBOARD = "Dashboard";
    private static final String TASKS = "Tasks";
    private static final String GAMIFICATION = "Gamification";
    private static final String ADD_TASK = "AddTask";

    private JPanel mainPanel;

    private JPanel topPanel;
    private JLabel titleLabel;

    private JPanel leftPanel;
    private JButton dashboardButton;
    private JButton tasksButton;
    private JButton gamificationButton;
    private JButton addTaskButton;
    private JButton exitButton;

    private JPanel contentPanel;
    private CardLayout cardLayout;

    private DashboardView dashboardView;
    private TaskView taskView;
    private GamificationView gamificationView;
    private AddTaskView addTaskView;

    public GUIManager() {
        initComponents();
        layoutComponents();
        setupListeners();

        cardLayout.show(contentPanel, DASHBOARD); // Show dashboard by default
    }

    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(AppColors.BACKGROUND);

        // Top panel with title
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(AppColors.PRIMARY_LIGHT);
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        titleLabel = new JLabel("Task Tracker");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(AppColors.PRIMARY_DARK);
        topPanel.add(titleLabel);

        // Left navigation panel
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(AppColors.PRIMARY_LIGHT);
        leftPanel.setBorder(BorderFactory.createEmptyBorder(50, 15, 50, 15));
        leftPanel.setPreferredSize(new Dimension(200, 0));  // Slightly wider fixed width

        dashboardButton = createNavButton("Dashboard");
        tasksButton = createNavButton("View Tasks");
        gamificationButton = createNavButton("Gamification");
        addTaskButton = createNavButton("Add Task");
        exitButton = createNavButton("Exit");

        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(dashboardButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(tasksButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(gamificationButton);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        leftPanel.add(addTaskButton);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(exitButton);

        // Center panel with CardLayout
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(AppColors.BACKGROUND);

        // Initialize views
        dashboardView = new DashboardView();
        taskView = new TaskView();
        gamificationView = new GamificationView();
        addTaskView = new AddTaskView();

        contentPanel.add(dashboardView, DASHBOARD);
        contentPanel.add(taskView, TASKS);
        contentPanel.add(gamificationView, GAMIFICATION);
        contentPanel.add(addTaskView, ADD_TASK);
    }

    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(180, 45));
        btn.setFocusPainted(false);
        btn.setBackground(AppColors.PRIMARY);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("SansSerif", Font.BOLD, 15));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(AppColors.PRIMARY_DARK);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(AppColors.PRIMARY);
            }
        });

        return btn;
    }

    private void layoutComponents() {
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
    }

    private void setupListeners() {
        dashboardButton.addActionListener(e -> cardLayout.show(contentPanel, DASHBOARD));
        tasksButton.addActionListener(e -> cardLayout.show(contentPanel, TASKS));
        gamificationButton.addActionListener(e -> cardLayout.show(contentPanel, GAMIFICATION));
        addTaskButton.addActionListener(e -> cardLayout.show(contentPanel, ADD_TASK));

        exitButton.addActionListener(e -> System.exit(0));

        addTaskView.getAddButton().addActionListener(e -> {
            String taskTitle = addTaskView.getTitleInput().trim();
            String taskDesc = addTaskView.getDescriptionInput().trim();
            String dueDate = addTaskView.getDueDateInput().trim();
            String cur_email = RegistrationAndLogin.getCurrentEmail();
            Integer user_id  = UserDAO.getUserIDByEmail(cur_email);

            if (taskTitle.isEmpty() || taskDesc.isEmpty() || dueDate.isEmpty()) {
                addTaskView.getMessageLabel().setText("Incorrect Form!!! Please enter valid input");
                addTaskView.getMessageLabel().setForeground(AppColors.ERROR);
                
                JOptionPane.showMessageDialog(addTaskView, "Incorrect Form!!! Please enter valid input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else{
                    try{

                        TaskDAO.addTaskDAO(taskTitle, taskDesc, user_id, dueDate);  
                        JOptionPane.showMessageDialog(addTaskView, "Task Added Succesfully!!!","success",JOptionPane.INFORMATION_MESSAGE);
                        addTaskView.clearFields();
                        for (String[] rowData : TaskDAO.getAllTasksDAO()) {
                            taskView.addTaskToTable(rowData[1], rowData[6]);
                         }
                        cardLayout.show(contentPanel, "Tasks");
                    }
                    catch(Error er){
                        
                addTaskView.getMessageLabel().setText("There was a problem when trying to add task to database!!!");
                addTaskView.getMessageLabel().setForeground(AppColors.ERROR);
                           er.getMessage();
                    }

                    
                    

                }
        });

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
