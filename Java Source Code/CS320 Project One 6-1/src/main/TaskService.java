package main;

import java.util.HashMap;

public class TaskService {
    // Object of TaskService
    private static TaskService instance;

    // Create a hashmap to contain the task list
    public HashMap<String, Task> taskList = new HashMap<>();

    // private constructor
    private TaskService(){}
    
    public static TaskService getInstanceTaskService()
    {
        // Create an instance of the TaskService if one doesn't already exist
        if (instance == null)
        {
            instance = new TaskService();
        }
        return instance;
    
    }

    public void addTask(Task task)
    {
        // Only add if the unique taskId is not already there
        taskList.putIfAbsent(task.getTaskId(), task);
    }

    public void deleteTask(String taskId)
    {
        // Remove the given key value pairs from hashMap
        taskList.remove(taskId);
    }

    public void updateTask(String taskId, Task newTask)
    {   
        // Store info from Hashmap into a temporary task object
        Task tempTask = taskList.get(taskId);
        
        // Check to see if the hashMap has the given taskId
        if(tempTask == null)
        {
            throw new IllegalArgumentException("Task Does Not Exist");
        }
        else
        {
            // If hashMap does contain the given taskId then update the data
            taskList.replace(taskId, newTask);
        }
    }
}
