package com.uzzielvz.tasktracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskManager
{
    private List<Task> tasks = new ArrayList<>();
    
    public TaskManager()
    {
        this.tasks = loadTasks();
    }
    
    public void addTask(String description)
    {
        Task newTask = new Task(description);
        tasks.add(newTask);
        saveTasks();
        System.out.println("Task added: " + newTask.getDescription() + " -" + newTask.getId());
        
    }
    
    public void removeTask(Task task)
    {
        tasks.remove(task);
        saveTasks();
        System.out.println("Task removed: " + task.getDescription() + " -" + task.getId());
    }
    
    public void listAllTasks()
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
        if (t.getStatus().equals(Status.TODO.getDescripcion())) 
        {
            System.out.println(t);
        }
    });
    }
    
    public void listTasksInProgress() 
    {
    tasks.forEach(t -> 
    {
        if (t.getStatus().equals(Status.IN_PROGRESS.getDescripcion())) 
        {
            System.out.println(t);
        }
    });
    }
    
    public List<Task> loadTasks()
    {
        try(Reader reader  = new FileReader("tasks.json"))
        {
            Gson gson = new Gson();
            Type taskListType = new TypeToken<List<Task>>(){}.getType();
            return gson.fromJson(reader, taskListType);
        } catch (IOException e)
        {
            return new ArrayList();
        }
    }
    
    public void saveTasks()
    {
        try(Writer writer = new FileWriter("tasks.json"))
        {
            Gson gson = new Gson();
            gson.toJson(tasks, writer);
        }
        catch(IOException e)
        {
        }
    }
    
    public Task findTaskById(int id)
    {
        return tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

}
