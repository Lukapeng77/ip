package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;

/**
 * Represents a command to exit the Luka application.
 */
public class ExitCommand extends Command {
    /**
     * Executes the command by displaying a goodbye message.
     *
     * @param taskList The task list (not used in this command).
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage that saves tasks inputted by users (not used in this command).
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printGoodbyeMessage();
    }

    /**
     * Indicates that this command exits the Luke application.
     *
     * @return true, as this command is for exiting.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
