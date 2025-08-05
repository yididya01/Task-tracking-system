package com.ttracker.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class TaskDAO {
        
    public static void connectDAO() {
        String url = "jdbc:sqlite:database.db";
 
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the database.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

     
    public static void createTaskTableDAO() {
        String url = "jdbc:sqlite:database.db";
        String sql = "CREATE TABLE IF NOT EXISTS Tasks (\n"
                + " id INTEGER PRIMARY KEY,\n"
                + " task_title TEXT NOT NULL,\n"
                + " task_description TEXT NOT NULL,\n"
                + " user_id INTEGER,\n"
                + " task_status TEXT NOT NULL DEFAULT 'TO_DO',\n"
                + " task_points INTEGER NOT NULL DEFAULT 0,\n"
                + " due_date TEXT NOT NULL DEFAULT 'YYYY-MM-DD',\n"
                + " created_at TEXT NOT NULL DEFAULT (STRFTIME('%Y-%m-%d %H:%M:%S', 'NOW')),\n"
                + " FOREIGN KEY (user_id) REFERENCES Users(user_id),\n"
                + " CHECK(task_status IN ('TO_DO', 'IN_PROGRESS', 'BLOCKED', 'CANCELLED','OVERDUE','DONE'))\n"
                + ");";
 
        try (Connection conn = DriverManager.getConnection(url);
             java.sql.Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tasks Table created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

     
    public static void addTaskDAO(String taskTitle, String taskDescription,Integer user_id,String due_date) {
        String url = "jdbc:sqlite:database.db";
        String sql = "INSERT INTO Tasks(task_title, task_description,user_id,due_date) VALUES(?,?,?,?)";
 
        try (Connection conn = DriverManager.getConnection(url);
             java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, taskTitle);
            pstmt.setString(2, taskDescription);
            pstmt.setInt(3, user_id);
            pstmt.setString(4, due_date);
            pstmt.executeUpdate();
            System.out.println("Task Added succesfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
    }


    public static List<String[]> getAllTasksDAO() {
        String url = "jdbc:sqlite:database.db";
        String sql = "SELECT id, task_title, task_description,user_id,task_status,task_points,due_date,created_at FROM Tasks";
 
        List<String[]> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(sql)) {
             int columnCount = rs.getMetaData().getColumnCount();   
 
            while (rs.next()) {
                String[] row = new String[columnCount];
               for (int i = 0; i < columnCount; i++) {
                   row[i] = rs.getString(i + 1);
                 }
                list.add(row);
            }
            return list;
        } catch (SQLException e) {;
            System.out.println(e.getMessage());
            return list;
        }
    }
    
    public static List<String[]> getAllUserTasksDAO(int user_id) {
        String url = "jdbc:sqlite:database.db";
        String sql = "SELECT * FROM Tasks WHERE user_id = ?";
        
        List<String[]> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)
             ) {
                pstmt.setInt(1, user_id);
                java.sql.ResultSet rs = pstmt.executeQuery();
                int columnCount = rs.getMetaData().getColumnCount();
 
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                        rs.getString("task_title") + "\t" +
                        rs.getString("task_description") + "\t" +
                        rs.getString("user_id") + "\t" +
                        rs.getString("task_status") + "\t" +
                        rs.getString("task_points") + "\t" +
                        rs.getString("created_at"));
                        String[] row = new String[columnCount];
                        for (int i = 0; i < columnCount; i++) {
                            row[i] = rs.getString(i + 1);
                            }
                            list.add(row);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    public static void updateTaskStatus(Integer taskId,String newValue) {
        String sql = "UPDATE Tasks SET task_status = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the new value for the column.
            pstmt.setString(1, newValue);
            // Set the ID of the task to be updated.
            pstmt.setInt(2, taskId);

            // Execute the update operation.
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            System.err.println("Error updating task: " + e.getMessage());
        }
    }
}



