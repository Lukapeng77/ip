package taskmanager;

import tasktypes.*;
import exceptions.*;

public class TaskManager {
    private final TaskList tasklist;
    private final UserInterface ui;

    public TaskManager(TaskList tasklist, UserInterface ui) {
        this.tasklist = tasklist;
        this.ui = ui;
    }

    public void InputProcess(String userInput) throws HandleException {
        Task newTask;
        String[] parts = userInput.split(" ", 2);
        String type = parts[0];
        String[] details;

        // Need to check the list tasks case before check the input length
        if (type.equals("list")) {
            tasklist.showTasks();
        }
        // Handle error message for empty description.
        else if (parts.length < 2 || parts[1].isEmpty()) {
            throw new HandleException("OOPS!!! The description of a todo cannot be empty.");
        } else if (type.equals("todo")) {
            newTask = new Todo(parts[1]);
            tasklist.addTask(newTask);

        } else if (type.equals("deadline")) {
            details = parts[1].split(" /by", 2);
            newTask = new Deadline(details[0], details[1]);
            tasklist.addTask(newTask);

        } else if (type.equals("event")) {
            details = parts[1].split(" /from ", 2);
            String[] durations = details[1].split(" /to ", 2);
            newTask = new Event(details[0], durations[0], durations[1]);
            tasklist.addTask(newTask);

        } else if (type.equals("mark")) {
            try {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                if (taskIndex > 0 && taskIndex <= tasklist.taskLength) {
                    tasklist.markTask(taskIndex - 1);
                } else {
                    System.out.println("Out of bounds!");
                }
            } catch (Exception e) {
                System.out.println("Error marking task!");
            }
        } else if (type.equals("unmark")) {
            try {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                if (taskIndex > 0 && taskIndex <= tasklist.taskLength) {
                    tasklist.unmarkTask(taskIndex - 1);
                } else {
                    System.out.println("Out of bounds!");
                }
            } catch (Exception e) {
                System.out.println("Error marking task!");
            }
        }
        else if (type.equals("delete")) {
                try {
                    int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                    if (taskIndex > 0 && taskIndex <= tasklist.taskLength) {
                        tasklist.deleteTask(taskIndex - 1);
                    } else {
                        System.out.println("Out of bounds!");
                    }
                } catch (Exception e) {
                    System.out.println("Error deleting task!");
                }
            } else {
                // Handle error message for invalid input or general error
                throw new HandleException(" OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }
    }