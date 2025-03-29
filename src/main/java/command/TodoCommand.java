package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;
import tasktypes.Todo;
import tasktypes.Task;

import java.io.IOException;

/**
 * The {@code TodoCommand} class represents a command to add a {@code Todo} task to the task list.
 */
public class TodoCommand extends Command {
    /**
     * The description of the to-do task.
     */
    private final String description;

    /**
     * Constructs a {@code TodoCommand} with the given description.
     *
     * @param description The description of the to-do task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the command to add a new {@code Todo} task to the task list.
     * The task is saved to storage and a confirmation message is displayed to the user.
     *
     * @param taskList The task list to which the new task is added.
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage system for saving tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Todo(description);
        taskList.addTask(newTask);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        Ui.printAddedTask(newTask, taskList.getTaskCount());
    }
}
