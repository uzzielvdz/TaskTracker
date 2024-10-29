# Task Manager

## URL project
https://github.com/uzzielvdz/TaskTracker


## Description

**Task Manager** is a command-line interface (CLI) application developed in **Java** that allows users to manage and track their tasks. The purpose of this application is to provide a simple yet powerful tool for creating, organizing, updating, and completing tasks efficiently.

## Features

* **Add tasks**: Allows users to add new tasks with a title and an optional description.
* **Delete tasks**: Removes existing tasks by their ID.
* **Update tasks**: Modifies task details, such as the title or description.
* **Mark tasks as completed**: Marks tasks as completed or pending.
* **Show all tasks**: Lists all tasks, both completed and pending.
* **Filter tasks**: Filters tasks by status (completed or pending).

## System Requirements

* **Java 8** or higher.
* **Maven** for dependency management and project build.

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/uzzielvdz/TaskTracker.git
   
2. **Navigate to the project directory**:

   cd taskTracker

3. **Build the project** using Maven:

   mvn clean install

4. **Run the application**:

   java -jar target/task-manager-1.0-SNAPSHOT.jar

## Usage

Once the application is running, you can interact with it using the following commands:

* **Add a task**:

   add "Task title" "Optional task description"

* **Delete a task**:

   delete [TASK_ID]

* **Update a task**:

   update [TASK_ID] "New title" "New optional description"

* **Mark a task as completed**:

   complete [TASK_ID]

* **List all tasks**:

   list

* **Filter completed tasks**:

   list completed

* **Filter pending tasks**:

   list pending

## Project Structure

Proyectos.Java.TaskManager/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/taskmanager/
│   │            ├── App.java          # Main entry point of the application
│   │            ├── Task.java         # Task class representing a task
│   │            ├── TaskManager.java  # Task management logic
│   │            └── CommandParser.java # CLI command parser
│   └── test/
│       └── java/
│           └── com/taskmanager/
│                └── TaskManagerTest.java # Unit tests for the task management logic
└── pom.xml

## Contribution

If you would like to contribute to this project:

1. **Fork** this repository.
2. Create a new branch (git checkout -b feature/new-feature).
3. Make your changes and **commit** them (git commit -m 'Add new feature').
4. Push to the branch and create a **pull request**.

## License

This project is licensed under the MIT License. For more information, see the LICENSE file.

