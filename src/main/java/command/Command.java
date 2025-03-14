package command;

import exceptions.HandleException;
import storage.Storage;
import taskmanager.TaskList;
import UserInterface.Ui;

/**
 * Represents an abstract command that can be executed on the task list.
 * Subclasses of this class implement specific commands such as adding, deleting, marking and finding tasks.
 */
public abstract class Command {
    /**
     * Executes the command by performing operations on the given task list, UI, and storage.
     *
     * @param taskList The task list to operate on.
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage for saving the updated task list.
     * @throws HandleException If an error occurs during execution.
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws HandleException;

    /**
     * Determines if this command exits the Luke application.
     *
     * @return true if the command exits the program, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
