package taskmanager;

import tasktypes.*;

import java.util.ArrayList;

import static constants.Constants.*;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    // Return an ArrayList of Tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    // Add task function
    public void addTask(Task task) {
        tasks.add(task);

        System.out.println(LINE_SEPARATOR
                + "Got it. I've added this task:" + "\n"
                + task.toString() + "\n"
                + "Now you have " + tasks.size() + " tasks in the list." + "\n"
                + LINE_SEPARATOR);

    }

    // Show tasks function
    public void showTasks() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i).toFileFormat());
        }
        System.out.println(LINE_SEPARATOR);
    }

    // Mark task function
    public void markTask(int index) {
        tasks.get(index).markAsDone();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Nice! I've marked this task as done:");
        System.out.print("[" + tasks.get(index).getStatusIcon() + "] ");
        System.out.print(tasks.get(index).getDescription() + "\n");
        System.out.println(LINE_SEPARATOR);
    }

    // Unmark task function
    public void unmarkTask(int index) {
        tasks.get(index).markAsNotDone();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.print("[" + tasks.get(index).getStatusIcon() + "] ");
        System.out.print(tasks.get(index).getDescription() + "\n");
        System.out.println(LINE_SEPARATOR);
    }

    // delete task function
    public void deleteTask(int index) {
        Task removedTask = tasks.remove(index);
        System.out.println(LINE_SEPARATOR);
        System.out.println("Noted. I've removed this task:\n" + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        System.out.println(LINE_SEPARATOR);
    }
}