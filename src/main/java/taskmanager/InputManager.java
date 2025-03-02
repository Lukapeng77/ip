package taskmanager;

import command.*;
import exceptions.*;
import storage.Storage;
import tasktypes.Task;
import parser.Parser;

import java.io.IOException;
import java.util.ArrayList;

public class InputManager {
    public static void main(String[] args) throws HandleException, IOException {
        Storage storage = new Storage("data/luka.txt");
        ArrayList<Task> loadedTasks = storage.load();
        TaskList taskList = new TaskList(loadedTasks); // Initialize the task list.
        UserInterface ui = new UserInterface(); // Component for user interactions.
        Parser parser = new Parser(taskList, ui);

        ui.printWelcomeMessage(); // Display a welcome message

        try {
            storage.createFile();
            for (Task task : loadedTasks) {
                taskList.addTask(task);
            }
        } catch (IOException e) {
            ui.showError("Could not load tasks: " + e.getMessage());
        }

        // Control the main application loop.
        while (true) {
            String userInput = ui.readCommand(); // Read user input.

            Command command = parser.parse(userInput);
            command.execute(taskList, ui, storage);
            storage.save(taskList.getTasks());
        }
    }
}

