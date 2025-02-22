package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Task;
import main.TaskService;

public class TaskServiceTest {
    @Test
    void testGetInstanceTaskService()
    {
        Assertions.assertNotNull(TaskService.getInstanceTaskService());
    }
    
    @Test
    void testAddTask()
    {
        // Create a new Task object
        Task task = new Task("TaskID12", "TaskName", "LongLongTaskDescription");
        // Add the task object to hashMap
        TaskService.getInstanceTaskService().addTask(task);
        // Check if addTask is working correctly
        assertTrue(task.equals(TaskService.getInstanceTaskService().taskList.get("TaskID12")));
    }
    
    @Test
    void testDeleteTask()
    {
        // Create a new Task object
        Task task = new Task("TaskID12", "TaskName", "LongLongTaskDescription");
        // Add the task object to hashMap
        TaskService.getInstanceTaskService().addTask(task);
        
        //Delete the task
        TaskService.getInstanceTaskService().deleteTask("TaskID12");
        // Check if deleteTask is working correctly
        assertFalse(TaskService.getInstanceTaskService().taskList.containsValue(task));

    }
   
    @Test
    void testUpdatetask()
    {
        // Create a new Task object
        Task task = new Task("TaskID12", "TaskName", "LongLongTaskDescription");
        // Add the task object to hashMap
        TaskService.getInstanceTaskService().addTask(task);

        // Create a new Task object with the same id to update the hashMap
        Task newTask = new Task("TaskID12", "NEWTaskName", "NEWLongLongTaskDescription");
        // Update the hashMap
        TaskService.getInstanceTaskService().updateTask("TaskID12", newTask);
        //Check to see if hashMap updated correctly
        assertTrue(newTask.equals(TaskService.getInstanceTaskService().taskList.get("TaskID12")));
    }
}
