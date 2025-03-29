package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;
import tasktypes.*;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * The {@code DeadlineCommand} class represents a command to add a {@code Deadline} task to the task list.
 */
public class DeadlineCommand extends Command {
    /**
     * The description of the deadline task.
     */
    private final String description;

    /**
     * The due date and time of the deadline task.
     */
    private final LocalDateTime by;

    /**
     * Constructs a {@code DeadlineCommand} with the given task description and deadline.
     *
     * @param description The description of the deadline task.
     * @param by          The due date and time of the deadline task.
     */
    public DeadlineCommand(String description, LocalDateTime by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the command to add a new {@code Deadline} task to the task list.
     * The task is saved to storage and a confirmation message is displayed to the user.
     *
     * @param taskList The task list to which the new task is added.
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage system for saving tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Deadline(description, by);
        taskList.addTask(newTask);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        Ui.printAddedTask(newTask, taskList.getTaskCount());
    }
}
