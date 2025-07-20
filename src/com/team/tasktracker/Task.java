package com.team.tasktracker;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Task {
    protected int taskId;
    protected String taskTitle;
    protected String taskDescription;
    protected StandardUser assignedUser;
    protected int taskPoints;
    private Instant createdAt;


    void setTaskPoint(){
        this.taskPoints = 10;
    }

    void setTime(){
        Instant currentTime = Instant.now();
        this.createdAt = currentTime;
    }

    Task(String taskTitle, String taskDescription, StandardUser assignedUser){
        this.taskId = 1;
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.assignedUser = assignedUser;
        setTaskPoint();
        setTime();
    }

    public Map<String,String> TaskInformation(){
        Map<String,String> TaskInfo = new HashMap<>();
        TaskInfo.put("Task ID", String.valueOf(taskId));
        TaskInfo.put("Title", taskTitle);
        TaskInfo.put("Description", taskDescription);
        TaskInfo.put("Assigned User", String.valueOf(assignedUser));
        TaskInfo.put("Points", String.valueOf(taskPoints));
        TaskInfo.put("Created at(UTC)", String.valueOf(createdAt));
        return TaskInfo;
    }
}
