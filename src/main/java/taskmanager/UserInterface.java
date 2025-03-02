package taskmanager;

import tasktypes.Task;

import java.util.ArrayList;
import java.util.Scanner;

import static constants.Constants.*;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public String readCommand() {
        System.out.println("\nEnter your command:");
        return scanner.nextLine();
    }

    public void printWelcomeMessage() {
        String chatbot_name = "Luka";
        showLine();
        System.out.println(" Hello! I'm " + chatbot_name + "\n" + " What can I do for you?\n");
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
        System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
    }

    public static void printMarkAsUndone(Task task) {
        System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
    }

    public static void printTask(ArrayList<Task> task, int taskCount) {
        int listIndex = 1;
        for (int i = 0; i < taskCount; i++) {
            System.out.printf(INDENT + "%d. %s%n", "", listIndex, task.get(i).toString());
            listIndex++;
        }
    }

    public static void printAddedTask(Task task, int taskCount) {
        System.out.printf(INDENT + "Got it. I've added this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
    }

    public static void printDeleteTask(Task task, int taskCount) {
        System.out.printf(INDENT + "Noted. I've removed this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
    }

    public static void printFindTask(ArrayList<Task> tasks, int taskCount, String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        int count = 0;
        for (int i = 0; i < taskCount; i++) {
            Task task = tasks.get(i);
            if (task.getDescription().contains(keyword)) {
                System.out.println((i + 1) + "." + task);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No matching tasks found :(");
        }
    }

    public void printGoodbyeMessage() {
        showLine();
        System.out.println("Bye. Hope to see you again soon!\n");
        showLine();
    }
}
