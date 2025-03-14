package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;
import tasktypes.*;

import java.io.IOException;

/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {
    int taskIndex;

    /**
     * Creates a MarkCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be marked as done (zero-based).
     */
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command by marking the task as done,
     * displaying a message after the task is successfully marked as done, and saving the updated list to storage.
     * If the index is out of bounds, an error message is displayed.
     *
     * @param taskList The task list containing the task.
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage for saving the updated task list.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.markTask(taskIndex);
        Task updatedTask = taskList.getTasks().get(taskIndex);
        Ui.printMarkAsDone(updatedTask);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
