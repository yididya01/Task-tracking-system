package com.ttracker.service;

// import java.util.List;

// import src.main.java.com.ttracker.abstracts.AbstractManager;
// import src.main.java.com.ttracker.models.StandardUser;
// import src.main.java.com.ttracker.models.Task;
// import src.main.java.com.ttracker.models.TaskStatus;

// public class TaskManager extends AbstractManager {

//     private TaskDAO taskDAO;

//     public TaskManager(TaskDAO taskDAO, FileHandler fileHandler, LogWriter logWriter) {
//         super(fileHandler, logWriter);
//         this.taskDAO = taskDAO;
//     }


//     public Task createTask(String title, String description, StandardUser assignedUser) {
//         try {
//             Task task = new Task(title, description, assignedUser);
//             taskDAO.save(task);
//             logOperation("Created Task: " + title);
//             return task;
//         } catch (Exception e) {
//             handleError(e);
//             return null;
//         }
//     }


//     public Task getTask(int id) {
//         try {
//             return taskDAO.findById(id);
//         } catch (Exception e) {
//             handleError(e);
//             return null;
//         }
//     }


//     public void updateTaskStatus(int taskId, TaskStatus newStatus) {
//         try {
//             Task task = getTask(taskId);
//             task.changeStatus(newStatus);
//             taskDAO.update(task);
//             logOperation("Updated Task Status: " + taskId);
//         } catch (Exception e) {
//             handleError(e);
//         }
//     }


//     @Override
//     public void delete(int id) {
//         try {
//             taskDAO.delete(id);
//             logOperation("Deleted Task: " + id);
//         } catch (Exception e) {
//             handleError(e);
//         }
//     }

//     @Override
//     public void save() {
        
//     }

//     @Override
//     public void load(int id) {
        
//     }

//     @Override
//     public boolean validate(Object entity) {
//         if (entity instanceof Task) {
//             Task task = (Task) entity;
//             return task.taskTitle != null && task.taskDescription != null;
//         }
//         return false;
//     }
// }
