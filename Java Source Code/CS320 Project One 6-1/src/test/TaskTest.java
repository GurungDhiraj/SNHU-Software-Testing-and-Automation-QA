package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Assertions;

import main.Task;

public class TaskTest {
    @Test // Check if parameters are being passed, accepted, and stored
    public void testCorrectTaskParameters()
    {
        Task task = new Task("TaskID12", "TaskName", "LongLongTaskDescription");
        assertTrue(task.getTaskId().equals("TaskID12"));
        assertTrue(task.getTaskName().equals("TaskName"));
        assertTrue(task.getTaskDescription().equals("LongLongTaskDescription"));
    }

    @Test // Tests to see if the setters are working correctly
    public void testCorrectTaskSetters()
    {
        Task task = new Task("TaskID12", "TaskName", "LongLongTaskDescription");
        // Use the setters to set new string values
        task.setTaskName("NEWTaskName");
        task.setTaskDescription("NEWLongLongTaskDescription");

        // Check if the new string values are set correctly
        assertTrue(task.getTaskName().equals("NEWTaskName"));
        assertTrue(task.getTaskDescription().equals("NEWLongLongTaskDescription"));
    }

    @CsvSource({
        // Testing the taskID parameter
        ", TaskName, LongLongTaskDescription", // Tests for Null taskID value
        "'', TaskName, LongLongTaskDescription", // Tests for Blank taskID value
        "1234567890123, TaskName, LongLongTaskDescription", // Tests for Too Long taskID values
        //Testing the taskName parameter
        "123, , LongLongTaskDescription", // Tests for Null taskName value
        "123, '', LongLongTaskDescription", // Tests for Blank taskName value 
        "123, OneTaskNameTwoTaskName, LongLongTaskDescription", // Tests for Too Long taskName values (OneTaskName = 11 chars long)
        // Testing the taskDescription parameter
        "123, TaskName, ", // Tests for Null taskDescription value 
        "123, TaskName, ''", // Tests for Blank taskDescription value
        "123, TaskName, OneDescriptionTwoDescriptionThreeDescriptionFourDescriptionFiveDescription", // Tests for Too Long taskDescription values (OneDescription = 14 chars)
    })
    
    @ParameterizedTest // Tests to see if program handles null, blank, and incorrect values 
    public void testTaskIncorrectValues(String taskId, String taskName, String taskDescription)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(taskId, taskName, taskDescription);
        });
    }
}
