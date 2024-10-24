package com.uzzielvz.tasktracker;

import java.util.ArrayList;
import java.util.List;

public class TaskManager
{
    private List<Task> tasks = new ArrayList<>();
    
    public void addTask(String description)
    {
        Task newTask = new Task(description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask.getDescription() + " -" + newTask.getId());
    }
    
    public void removeTask(Task task)
    {
        tasks.remove(task);
        System.out.println("Task removed: " + task.getDescription() + " -" + task.getId());
    }
    
    public void listAllTasks(Task task)
    {
       tasks.forEach(System.out::println);
    }
    
    public void listAllTasksAreDone() 
    {
    tasks.forEach(t -> 
    {
        if (t.getStatus().equals(Status.DONE.getDescripcion())) 
        {
            System.out.println(t);
        }
    });
    }
    
    public void listTasksToDo() 
    {
    tasks.forEach(t -> 
    {
        if (t.getStatus().equals(Status.DONE.getDescripcion())) 
        {
            System.out.println(t);
        }
    });
    }
    
    public void listTasksInProgress() 
    {
    tasks.forEach(t -> 
    {
        if (t.getStatus().equals(Status.DONE.getDescripcion())) 
        {
            System.out.println(t);
        }
    });
    }
    
}
