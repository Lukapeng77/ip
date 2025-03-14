package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;

import java.io.IOException;
/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command{
    int taskIndex;
    /**
     * Creates a DeleteCommand with the specified task index.
     *
     * @param taskIndex The index of the task to be deleted (zero-based).
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command by deleting the task at the specified index,
     * displaying a message after the specified task is deleted, and saving the updated list to storage.
     * If the index is out of bounds, an error message is displayed.
     *
     * @param taskList   The task list where the task will be deleted.
     * @param ui      The user interface for displaying messages.
     * @param storage The storage for saving the updated task list.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Ui.printDeleteTask(taskList.getTasks().get(taskIndex), taskList.getTaskCount() - 1);
        taskList.deleteTask(taskIndex);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
