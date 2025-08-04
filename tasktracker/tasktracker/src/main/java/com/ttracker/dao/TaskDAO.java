package src.main.java.com.ttracker.dao;

import com.team.tasktracker.Task;

import java.util.HashMap;
import java.util.Map;


public class TaskDAO {

    // Simulate database with a HashMap
    private Map<Integer, Task> taskDatabase = new HashMap<>();
    private int idCounter = 1;

    // Save a new task and assign a unique ID
    public void save(Task task) {
        task.setTaskId(idCounter++);
        taskDatabase.put(task.getTaskId(), task);
    }

    // Find a task by its ID
    public Task findById(int id) {
        return taskDatabase.get(id);
    }

    // Update an existing task
    public void update(Task task) {
        int id = task.getTaskId();
        if (taskDatabase.containsKey(id)) {
            taskDatabase.put(id, task);
        }
    }

    // Delete a task by its ID
    public void delete(int id) {
        taskDatabase.remove(id);


    }
    // Returns the total number of tasks stored
    public int getTotalTasks() {
        return taskDatabase.size();
    }

    public Map<Integer, Task> getAllTasks() {
        return new HashMap<>(taskDatabase);
    }

}



