package taskmanager;

import exceptions.*;
import java.util.ArrayList;

public class InputManager {
    public static void main(String[] args) throws HandleException {
        TaskList taskList = new TaskList(new ArrayList<>()); // Initialize the task list.
        UserInterface ui = new UserInterface(); // Component for user interactions.
        TaskManager taskManager = new TaskManager(taskList, ui);

        ui.printWelcomeMessage(); // Display a welcome message

        // Control the main application loop.
        while (true) {
            String userInput = ui.readInput(); // Read user input.

            if (userInput.equalsIgnoreCase("bye")) {
                ui.printGoodbyeMessage();
                return;
            } else {
                taskManager.InputProcess(userInput);
            }
        }
    }
}
