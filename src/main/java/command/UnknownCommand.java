package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;

/**
 * The {@code UnknownCommand} class represents a command that is not recognized by the system.
 * It is used to handle invalid or unrecognized user inputs.
 */
public class UnknownCommand extends Command {
    /**
     * The message to be displayed when an unknown command is encountered.
     */
    private final String message;

    /**
     * Constructs an {@code UnknownCommand} with the specified error message.
     *
     * @param message The error message to be displayed when an unknown command is entered.
     */
    public UnknownCommand(String message) {
        this.message = message;
    }

    /**
     * Executes the command by displaying an error message to inform the user that the command is unknown.
     *
     * @param taskList The task list (not used in this command).
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage system (not used in this command).
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printMessage(message);
    }
}
