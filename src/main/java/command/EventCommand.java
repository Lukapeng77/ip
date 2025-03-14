package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.*;
import tasktypes.*;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * The {@code EventCommand} class represents a command to add an {@code Event} task to the task list.
 */
public class EventCommand extends Command {
    /**
     * The description of the event task.
     */
    private final String description;

    /**
     * The start date and time of the event.
     */
    private final LocalDateTime from;

    /**
     * The end date and time of the event.
     */
    private final LocalDateTime to;

    /**
     * Constructs an {@code EventCommand} with the given task description, start, and end times.
     *
     * @param description The description of the event.
     * @param from        The start date and time of the event.
     * @param to          The end date and time of the event.
     */
    public EventCommand(String description, LocalDateTime from, LocalDateTime to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the command to add a new {@code Event} task to the task list.
     * The task is saved to storage and a confirmation message is displayed to the user.
     *
     * @param taskList The task list to which the new task is added.
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage system for saving tasks.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Event(description, from, to);
        taskList.addTask(newTask);
        try {
            storage.writeFile(newTask.toString());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        Ui.printAddedTask(newTask, taskList.getTaskCount());
    }
}