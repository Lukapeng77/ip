package command;

import taskmanager.TaskList;
import UserInterface.Ui;
import storage.Storage;

/**
 * The {@code HelpCommand} class is used to display all the available commands.
 */
public class HelpCommand extends Command {
    /**
     * Executes the help command, displaying the list of available commands.
     *
     * @param taskList the list of tasks (not used in this command)
     * @param ui       the UI component for displaying messages
     * @param storage  the storage component for saving tasks (not used in this command)
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        String helpMessage = "Here are the available commands:\n"
                + "1. todo <description> - Adds a new todo task\n"
                + "2. deadline <description> /by <date> - Adds a new deadline task\n"
                + "3. event <description> /from <start> /to <end> - Adds a new event task\n"
                + "4. list - Lists all current tasks\n"
                + "5. mark <task number> - Marks a task as completed\n"
                + "6. unmark <task number> - Marks a task as incomplete\n"
                + "7. delete <task number> - Deletes a task\n"
                + "8. find <keyword> - Finds tasks by keyword\n"
                + "9. checkDate <date> - Finds tasks by a specific date\n"
                + "10. bye - Exits the application\n"
                + "11. help - Shows this help message";

        ui.printMessage(helpMessage);
    }
}

