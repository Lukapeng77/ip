package UserInterface;

import tasktypes.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static constants.Constants.*;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    public String readCommand() {
        System.out.println("\nEnter your command:");
        return scanner.nextLine();
    }

    public void printWelcomeMessage() {
        String chatbot_name = "Luka";
        showLine();
        System.out.println(" Hello! I'm " + chatbot_name + "\n" + " What can I do for you?");
        showLine();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public static void showLine() {
        System.out.println(LINE_SEPARATOR);
    }

    public void showError(String message) {
        System.err.println("Error: " + message); // Display the error
    }

    public static void printMarkAsDone(Task task) {
        showLine();
        System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        showLine();
    }

    public static void printMarkAsUndone(Task task) {
        showLine();
        System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        showLine();
    }

    public static void printTask(ArrayList<Task> task, int taskCount) {
        showLine();
        if (task.isEmpty()) {
            System.out.println("You don't have any tasks yet. Need to add a new one first!");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + task.get(i).toFileFormat());
            }
        }
        showLine();
    }

    public static void printAddedTask(Task task, int taskCount) {
        showLine();
        System.out.printf(INDENT + "Got it. I've added this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
        showLine();
    }

    public static void printDeleteTask(Task task, int taskCount) {
        showLine();
        System.out.printf(INDENT + "Noted. I've removed this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
        showLine();
    }

    public static void printFindTask(ArrayList<Task> matchingTasks, int taskCount) {
        showLine();
        System.out.println("Here are the matching tasks in your list:");
        if (taskCount == 0) {
            System.out.println("No matching tasks found :(");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < taskCount; i += 1) {
                System.out.println((i + 1) + "." + matchingTasks.get(i).toString());
            }
        }
        showLine();
    }

    public void showTasksByDate(ArrayList<Task> matchingTasks, LocalDate checkDate) {
        showLine();
        System.out.println("Here are the list of tasks that are due on " + checkDate + ":");
        for (int i = 0; i < matchingTasks.size(); i++) {
            System.out.println((i + 1) + ". " + matchingTasks.get(i).toFileFormat());
        }
        System.out.println("You have " + matchingTasks.size() + " tasks in the list.");
        showLine();
    }

    public void printGoodbyeMessage() {
        showLine();
        System.out.println("Bye. Hope to see you again soon!\n");
        showLine();
    }
}
