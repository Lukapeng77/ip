package UserInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import tasktypes.Task;

import static constants.Constants.*;

/**
 * The {@code Ui} class handles all user interactions, including printing messages
 * and reading user commands.
 */
public class Ui {
    /**
     * Scanner for reading user input.
     */
    private final Scanner scanner;

    /**
     * Constructs a {@code Ui} instance and initializes the input scanner.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Reads the user input from the command line.
     *
     * @return the user's input as a string.
     */
    public String readCommand() {
        System.out.println("\nEnter your command:");
        return scanner.nextLine();
    }

    /**
     * Prints the welcome message when the application starts.
     */
    public void printWelcomeMessage() {
        String chatbot_name = "Luka";
        showLine();
        System.out.println(" Hello! I'm " + chatbot_name + "\n" + " What can I do for you?");
        showLine();
    }

    /**
     * Prints a given message to the console.
     *
     * @param message the message to be displayed.
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prints a horizontal line separator.
     */
    public static void showLine() {
        System.out.println(LINE_SEPARATOR);
    }

    /**
     * Displays an error message.
     *
     * @param message the error message to be displayed.
     */
    public void showError(String message) {
        System.err.println("Error: " + message); // Display the error
    }

    /**
     * Prints a message indicating that a task has been marked as done.
     *
     * @param task the task that has been marked as done.
     */
    public static void printMarkAsDone(Task task) {
        showLine();
        System.out.printf(INDENT + "Nice! I've marked this task as done:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        showLine();
    }

    /**
     * Prints a message indicating that a task has been marked as not done.
     *
     * @param task the task that has been marked as not done.
     */
    public static void printMarkAsUndone(Task task) {
        showLine();
        System.out.printf(INDENT + "OK, I've marked this task as not done yet:%n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        showLine();
    }

    /**
     * Prints the list of tasks.
     *
     * @param task      the list of tasks to display.
     * @param taskCount the total number of tasks in the list.
     */
    public static void printTask(ArrayList<Task> task, int taskCount) {
        showLine();
        if (task.isEmpty()) {
            System.out.println("You don't have any tasks yet. Need to add a new one first!");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + task.get(i).toFileFormat());
            }
            System.out.println("You have " + taskCount + " tasks in the list.");
        }
        showLine();
    }

    /**
     * Prints a message indicating that a task has been added.
     *
     * @param task      the task that was added.
     * @param taskCount the new total number of tasks in the list.
     */
    public static void printAddedTask(Task task, int taskCount) {
        showLine();
        System.out.printf(INDENT + "Got it. I've added this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
        showLine();
    }

    /**
     * Prints a message indicating that a task has been deleted.
     *
     * @param task      the task that was deleted.
     * @param taskCount the new total number of tasks in the list.
     */
    public static void printDeleteTask(Task task, int taskCount) {
        showLine();
        System.out.printf(INDENT + "Noted. I've removed this task:\n", "");
        System.out.printf(INDENT + "%s\n", "", task.toString());
        System.out.printf(INDENT + "Now you have %d tasks in the list.%n", "", taskCount);
        showLine();
    }

    /**
     * Prints a list of tasks that match a search query.
     *
     * @param matchingTasks the list of tasks that match the query.
     * @param taskCount     the number of matching tasks.
     */
    public static void printFindTask(ArrayList<Task> matchingTasks, int taskCount) {
        showLine();
        if (taskCount == 0) {
            System.out.println("No matching tasks found :(");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + "." + matchingTasks.get(i).toString());
            }
        }
        showLine();
    }

    /**
     * Prints a list of tasks that are due on a specific date.
     *
     * @param matchingTasks the list of tasks due on the specified date.
     * @param checkDate     the date for which tasks are being checked.
     */
    public void showTasksByDate(ArrayList<Task> matchingTasks, LocalDateTime checkDate) {
        showLine();
        System.out.println("Here are the list of tasks that are due on " + checkDate.format(OUTPUT_DATE_FORMAT) + ":");
        for (int i = 0; i < matchingTasks.size(); i++) {
            System.out.println((i + 1) + ". " + matchingTasks.get(i).toFileFormat());
        }
        System.out.println("You have " + matchingTasks.size() + " tasks in the list.");
        showLine();
    }

    /**
     * Prints the goodbye message when the application exits.
     */
    public void printGoodbyeMessage() {
        showLine();
        System.out.println("Bye. Hope to see you again soon!");
        showLine();
    }
}