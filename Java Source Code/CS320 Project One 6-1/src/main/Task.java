package main;

public class Task {
    private String taskId;
    private String taskName;
    private String taskDescription;

    public Task(String taskId, String taskName, String taskDescription)
    {
        // set the parameters to be equal to the parameters of the object if the conditions pass
        setTaskId(taskId);
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }

    // Getter for taskId 
    public String getTaskId(){return taskId;}

    // Setter for taskId = private so it can't be changed outside of the class
    private void setTaskId(String taskId)
    {
        // Check to see if the taskId meets the requirements
        if(taskId == null || taskId.isEmpty() || taskId.length() > 10)
        {
            throw new IllegalArgumentException("Invalid Task Id");
        }

        // set value for taskId
        this.taskId = taskId;
    }

    // Getter for taskName
    public String getTaskName(){return taskName;}

    // Setter for taskName
    public void setTaskName(String taskName) 
    {
        // Check to see if the taskName meets the requirements
        if(taskName == null || taskName.isEmpty() || taskName.length() > 20)
        {
            throw new IllegalArgumentException("Invalid Task Name");
        }
        // set value for taskName
        this.taskName = taskName;
    }

    // Getter for taskDescription
    public String getTaskDescription(){return taskDescription;}

    // Setter for taskDescription
    public void setTaskDescription(String taskDescription) 
    {
        // Check to see if the taskDescription meets the requirements
        if(taskDescription == null || taskDescription.isEmpty() || taskDescription.length() > 50)
        {
            throw new IllegalArgumentException("Invalid Task Description");
        }

        // set value for taskDescription
        this.taskDescription = taskDescription;
    }
}
