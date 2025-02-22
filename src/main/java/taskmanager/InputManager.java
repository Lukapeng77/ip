package taskmanager;

import exceptions.*;
import tasktypes.Task;

import java.io.IOException;
import java.util.ArrayList;

public class InputManager {
    public static void main(String[] args) throws HandleException, IOException {
        Storage storage = new Storage("./data/luka.txt");
        ArrayList<Task> loadedTasks = storage.load();
        TaskList taskList = new TaskList(loadedTasks); // Initialize the task list.
        UserInterface ui = new UserInterface(); // Component for user interactions.
        TaskManager taskManager = new TaskManager(taskList, ui);

        ui.printWelcomeMessage(); // Display a welcome message

        try {
            storage.createFile();
            for(Task task : loadedTasks){
                taskList.addTask(task);
            }
        } catch (IOException e) {
            ui.printMessage("Could not load tasks: " + e.getMessage());
        }

        // Control the main application loop.
        while (true) {
            String userInput = ui.readInput(); // Read user input.

            if (userInput.equalsIgnoreCase("bye")) {
                ui.printGoodbyeMessage();
                return;
            } else {
                taskManager.inputProcess(userInput);
                storage.save(taskList.getTasks());
            }
        }
    }
}
