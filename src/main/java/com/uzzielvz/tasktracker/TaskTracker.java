package com.uzzielvz.tasktracker;

import java.util.Scanner;


public class TaskTracker {
    
    private static TaskManager manager = new TaskManager();

    public static void main(String[] args) 
    {
        manager.loadTasks();
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("task-cli> ");
            String input = scanner.nextLine();
            handleCommand(input);
        }
    }
    
    private static void handleCommand(String input)
    {
        String[] parts = input.split(" ", 2); // Divide solo en dos partes: comando y argumentos
        String command = parts[0].toLowerCase(); // Convierte el comando a minúsculas para evitar problemas de mayúsculas/minúsculas
        String arguments = parts.length > 1 ? parts[1] : ""; // Argumentos opcionales
        
        switch(command)
        {
            case "add":
                manager.addTask(arguments);
                break;
            case "list":
                manager.listAllTasks();
                break;
            case "list-done":
                manager.listAllTasksAreDone();
                break;
        case "list-todo":
                manager.listTasksToDo();
                break;
        case "list-inprogress":
                manager.listTasksInProgress();
                break;
        case "remove":
                int taskId = Integer.parseInt(arguments);
                Task taskToRemove = manager.findTaskById(taskId);
                if (taskToRemove != null) 
                {
                    manager.removeTask(taskToRemove);
                }
                break;
        default:
            System.out.println("Unknown command: " + command);
            break;
        }
    } 
    
    

    
}
