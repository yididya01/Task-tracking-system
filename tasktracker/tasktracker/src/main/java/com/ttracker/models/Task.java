package com.ttracker.models;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Task {
    protected int taskId;
    protected String taskTitle;
    protected String taskDescription;
    protected StandardUser assignedUser;
    protected int taskPoints;
    private TaskStatus taskStatus;
    private Instant createdAt;


    private void setTaskPoint(){
        this.taskPoints = 10;
    }

    private void setTime(){
        Instant currentTime = Instant.now();
        this.createdAt = currentTime;
    }

    private void setTaskStatus(TaskStatus status){
        this.taskStatus = status;
    }

    Task(String taskTitle, String taskDescription, StandardUser assignedUser){
        this.taskId = 1;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.assignedUser = assignedUser;
        setTaskStatus(TaskStatus.TO_DO);
        setTaskPoint();
        setTime();
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void changeStatus(TaskStatus status){
        setTaskStatus(status);
    }

    public Map<String,String> TaskInformation(){
        Map<String,String> TaskInfo = new HashMap<>();
        TaskInfo.put("Task ID", String.valueOf(taskId));
        TaskInfo.put("Title", taskTitle);
        TaskInfo.put("Description", taskDescription);
        TaskInfo.put("Assigned User", String.valueOf(assignedUser));
        TaskInfo.put("Points", String.valueOf(taskPoints));
        TaskInfo.put("Status", String.valueOf(taskStatus));
        TaskInfo.put("Created at(UTC)", String.valueOf(createdAt));
        return TaskInfo;
    }
}
