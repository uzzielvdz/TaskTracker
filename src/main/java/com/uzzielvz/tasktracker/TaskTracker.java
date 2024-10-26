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
        String argument1 = parts.length > 1 ? parts[1] : ""; // Argumentos opcionales
        String argument2 = parts.length > 2 ? parts[1] : "";
        
        switch(command)
        {
            case "add":
                manager.addTask(argument1);
                break;
            case "list":
                switch (argument1)
                {
                    case ("all") -> manager.listAllTasks();
                    case("done") -> manager.listAllTasksAreDone();
                    case("todo") -> manager.listTasksToDo();
                    case("in-progress") -> manager.listTasksInProgress();
                }

            case "update":
                if (!argument1.isEmpty() && !argument2.isEmpty()) { // Verifica que ambos argumentos estén presentes
                try {
                    int taskId = Integer.parseInt(argument1); // Intenta convertir el primer argumento a entero
                    Task taskToUpdate = manager.findTaskById(taskId);
                    if (taskToUpdate != null) {
                        switch (argument2.toLowerCase()) {
                            case "done":
                                taskToUpdate.markAsDone(); // Marca como hecho
                                System.out.println("Task " + taskId + " marked as done.");
                                break;
                            case "inprogress":
                                taskToUpdate.markAsInProgress(); // Marca como en progreso
                                System.out.println("Task " + taskId + " marked as in progress.");
                                break;
                            default:
                                System.out.println("Unknown status: " + argument2);
                                break;
                        }
                        manager.saveTasks(); // Guarda los cambios después de la actualización
                    } else {
                        System.out.println("Task not found with ID: " + taskId);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid task ID: " + argument1);
                }
            } else {
                System.out.println("Both task ID and status are required to update a task.");
            }
            break;
            case "remove":
                try{
                    int taskId = Integer.parseInt(argument1);
                    Task taskToRemove = manager.findTaskById(taskId);
                    if (taskToRemove != null) 
                    {
                        manager.removeTask(taskToRemove);
                    }
                    else {
                        System.out.println("Task not found with ID: " + taskId);
                    }
                } catch (NumberFormatException e)
                {
                    System.out.println("Invalid task ID: " + argument1);
                }
                break;
            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    } 
}
