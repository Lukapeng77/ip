package command;

import UserInterface.Ui;
import exceptions.HandleException;
import storage.Storage;
import taskmanager.*;
import tasktypes.*;

import parser.DateParser;

import static exceptions.ExceptionTypes.INVALID_DATE;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * The {@code CheckDateCommand} class represents a command to check for tasks scheduled on a specific date.
 */
public class CheckDateCommand extends Command {

    /**
     * The date for which tasks should be searched.
     */
    protected LocalDateTime dateTime;

    /**
     * Constructs a {@code CheckDateCommand} with the specified date string.
     * The date string is parsed into a {@code LocalDate} format.
     *
     * @param dateTimeString The string representing the date to check.
     * @throws HandleException If the date format is invalid.
     */
    public CheckDateCommand(String dateTimeString) throws HandleException {
        try {
            this.dateTime = DateParser.parseDateTime(dateTimeString);
        } catch (DateTimeParseException e) {
            throw new HandleException(INVALID_DATE);
        }
    }

    /**
     * Executes the command by searching for tasks scheduled on the specified date
     * and displaying the results to the user.
     *
     * @param taskList The task list containing all tasks.
     * @param ui       The user interface for displaying results.
     * @param storage  The storage system (not used in this command).
     * @throws HandleException If an error occurs while processing the command.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws HandleException {
        // Search for tasks matching the specified date
        ArrayList<Task> matchingTasks = taskList.findTasksByDate(dateTime);

        // Display the matching tasks
        ui.showTasksByDate(matchingTasks, dateTime);
    }
}
