package taskmanager;

import UserInterface.Ui;
import command.Command;
import exceptions.HandleException;
import storage.Storage;
import parser.Parser;
import tasktypes.Task;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code Luka} class serves as the main entry point for the task manager application.
 * It initializes the required components, handles user interactions, and manages task storage.
 */
public class Luka {

    /**
     * The main method that starts the task manager application.
     * It initializes the storage, task list, user interface, and command parser.
     * The program runs in a loop, continuously accepting and executing user commands until an exit command is issued.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws HandleException If an error occurs while processing user commands.
     * @throws IOException     If an error occurs while reading or writing to the storage file.
     */
    public static void main(String[] args) throws HandleException, IOException {
        // Initialize storage and load existing tasks
        Storage storage = new Storage("data/luka.txt");
        ArrayList<Task> loadedTasks = storage.load();
        TaskList taskList = new TaskList(loadedTasks); // Initialize the task list.
        Ui ui = new Ui(); // Component for user interactions.
        Parser parser = new Parser(taskList, ui);

        // Display a welcome message
        ui.printWelcomeMessage();

        try {
            // Create file if it does not exist and load tasks
            storage.createFile();
            for (Task task : loadedTasks) {
                taskList.addTask(task);
            }
        } catch (IOException e) {
            ui.showError("Could not load tasks: " + e.getMessage());
        }

        // Main application loop
        boolean isExit = false;
        while (!isExit) {
            String userInput = ui.readCommand(); // Read user input

            Command command = parser.parse(userInput); // Parse the input into a command
            command.execute(taskList, ui, storage); // Execute the command
            storage.save(taskList.getTasks()); // Save the updated task list
            isExit = command.isExit(); // Check if the exit command was issued
        }
    }
}