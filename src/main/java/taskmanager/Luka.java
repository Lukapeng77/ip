package taskmanager;

import UserInterface.Ui;
import command.Command;
import exceptions.HandleException;
import storage.Storage;
import parser.Parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The {@code Luka} class is the main entry point of the task management chatbot application.
 * It initializes all core components (UI, storage, parser, and task list) and handles
 * the execution loop for reading and processing user commands.
 */
public class Luka {
    /**
     * Handles loading and saving tasks to a file.
     */
    private Storage storage;

    /**
     * Handles user input and output messages.
     */
    private Ui ui;

    /**
     * Manages the list of tasks in memory.
     */
    private TaskList tasks;

    /**
     * The {@code Parser} instance is responsible for parsing user input into executable commands.
     * It converts raw user input into specific command objects.
     */
    private Parser parser;

    /**
     * Constructs a new instance of the Luka chatbot.
     *
     * @param filePath the file path used to load and store task data
     */
    public Luka(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            storage.createFile();
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showError("No existing task data found. Please Start with an empty task list first.");
            tasks = new TaskList(new ArrayList<>());
        }
    }

    /**
     * Starts the main loop of the chatbot.
     * Displays the welcome message, continuously reads user input,
     * parses and executes commands until the exit command is issued.
     * Any {@code HandleException} thrown during command parsing or execution
     * is caught and displayed without terminating the application.
     */
    public void run() {
        ui.printWelcomeMessage();
        parser = new Parser(tasks, ui);

        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command command = parser.parse(fullCommand);
                // Executes the command, displays messages, and updates the task file accordingly.
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            } catch (HandleException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    /**
     * The main method of the application.
     * Creates an instance of Luka and starts the chatbot.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // A relative path is used for the txt file that stores the tasks
        new Luka("./data/luka.txt").run();
    }
}