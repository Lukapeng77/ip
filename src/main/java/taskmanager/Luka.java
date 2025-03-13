package taskmanager;

import UserInterface.Ui;
import command.Command;
import exceptions.HandleException;
import storage.Storage;
import parser.Parser;
import tasktypes.Task;

import java.io.IOException;
import java.util.ArrayList;

public class Luka {

    public static void main(String[] args) throws HandleException, IOException {
        Storage storage = new Storage("data/luka.txt");
        ArrayList<Task> loadedTasks = storage.load();
        TaskList taskList = new TaskList(loadedTasks); // Initialize the task list.
        Ui ui = new Ui(); // Component for user interactions.
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
        boolean isExit = false;
        while (!isExit) {
            String userInput = ui.readCommand(); // Read user input.

            Command command = parser.parse(userInput);
            command.execute(taskList, ui, storage);
            storage.save(taskList.getTasks());
            isExit = command.isExit();
        }
    }
}

