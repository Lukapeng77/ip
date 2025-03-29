package parser;

import UserInterface.Ui;
import taskmanager.*;
import exceptions.*;
import command.*;

import static constants.Constants.*;

import java.time.LocalDateTime;

import static constants.Constants.INVALID_FIND_TASK;

/**
 * The {@code Parser} class is responsible for processing user input and
 * converting it into executable commands.
 */
public class Parser {
    /**
     * The task list that holds the current tasks.
     */
    private final TaskList tasklist;
    /**
     * The user interface component for interaction with the user.
     */
    private final Ui ui;

    /**
     * Constructs a {@code Parser} object that takes in a task list and user interface.
     *
     * @param tasklist The list of tasks to be managed.
     * @param ui       The user interface for displaying messages.
     */
    public Parser(TaskList tasklist, Ui ui) {
        this.tasklist = tasklist;
        this.ui = ui;
    }

    /**
     * Parses the user input and returns the corresponding command.
     *
     * @param userInput The raw user input string.
     * @return A {@code Command} object corresponding to the input.
     * @throws HandleException If the input is invalid or missing required details.
     */
    public Command parse(String userInput) throws HandleException {
        String[] parts = userInput.split(" ", 2);
        String type = parts[0];
        String[] details;

        // Check for exit and list commands before processing further.
        if (type.equals(COMMAND_GOODBYE)) {
            return new ExitCommand();
        } else if (type.equals(COMMAND_HELP)) {
            return new HelpCommand();
        } else if (type.equals(COMMAND_LIST)) {
            return new ListCommand();
        } else if (type.equals(COMMAND_TODO)) {
            return new TodoCommand(parts[1]);

        } else if (type.equals(COMMAND_DEADLINE)) {
            details = parts[1].split(IDENTIFIER_BY, 2);
            LocalDateTime by = DateParser.parseDateTime(details[1]);
            return new DeadlineCommand(details[0], by);

        } else if (type.equals(COMMAND_EVENT)) {
            details = parts[1].split(IDENTIFIER_FROM, 2);
            String[] durations = details[1].split(IDENTIFIER_TO, 2);
            LocalDateTime from = DateParser.parseDateTime(durations[0]);
            LocalDateTime to = DateParser.parseDateTime(durations[1]);
            return new EventCommand(details[0], from, to);

        } else if (type.equals(COMMAND_MARK)) {
            return processMarkCommand(userInput);
        } else if (type.equals(COMMAND_UNMARK)) {
            return processUnmarkCommand(userInput);
        } else if (type.equals(COMMAND_DELETE)) {
            return processDeleteCommand(userInput);
        } else if (type.equals(COMMAND_FIND)) {
            return processFindCommand(userInput);
        } else if (type.equals(COMMAND_CHECK_DATE)) {
            return processCheckDateCommand(userInput);
        }// Handle error message for empty description.
        else if (parts.length < 2 || parts[1].isEmpty()) {
            throw new HandleException(INVALID_INPUT);
        } else {
            throw new HandleException(INVALID_INPUT);
        }
    }

    /**
     * Processes a mark command to mark a task as completed.
     *
     * @param userInput The raw user input string.
     * @return A {@code MarkCommand} if the input is valid.
     */
    private Command processMarkCommand(String userInput) {
        try {
            int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
            if (taskIndex > 0 && taskIndex <= tasklist.getTasks().size()) {
                return new MarkCommand(taskIndex - 1);
            } else {
                System.out.println(MESSAGE_BOUNDARY_ERROR);
            }
        } catch (Exception e) {
            System.out.println(MESSAGE_MARKING_ERROR);
        }
        return new UnknownCommand(UNKNOWN_COMMAND);
    }

    /**
     * Processes an unmark command to mark a task as incomplete.
     *
     * @param userInput The raw user input string.
     * @return An {@code UnmarkCommand} if the input is valid.
     */
    private Command processUnmarkCommand(String userInput) {
        try {
            int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
            if (taskIndex > 0 && taskIndex <= tasklist.getTasks().size()) {
                return new UnmarkCommand(taskIndex - 1);
            } else {
                System.out.println(MESSAGE_BOUNDARY_ERROR);
            }
        } catch (Exception e) {
            System.out.println(MESSAGE_MARKING_ERROR);
        }
        return new UnknownCommand(UNKNOWN_COMMAND);
    }

    /**
     * Processes a delete command to remove a task from the list.
     *
     * @param userInput The raw user input string.
     * @return A {@code DeleteCommand} if the input is valid.
     */
    private Command processDeleteCommand(String userInput) {
        try {
            int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
            if (taskIndex > 0 && taskIndex <= tasklist.getTasks().size()) {
                return new DeleteCommand(taskIndex - 1);
            } else {
                System.out.println(MESSAGE_BOUNDARY_ERROR);
            }
        } catch (Exception e) {
            System.out.println(MESSAGE_DELETING_ERROR);
        }
        return new UnknownCommand(UNKNOWN_COMMAND);
    }

    /**
     * Processes a find command to search for tasks containing a keyword.
     *
     * @param userInput The raw user input string.
     * @return A {@code FindCommand} if the input is valid.
     */
    private Command processFindCommand(String userInput) {
        try {
            if (userInput.length() <= 5) {
                throw new HandleException(INVALID_FIND_TASK);
            }
            String keyword = userInput.substring(5).trim();
            if (keyword.isEmpty()) {
                throw new HandleException(INVALID_FIND_TASK);
            }
            return new FindCommand(keyword);
        } catch (HandleException e) {
            System.out.println(e.getMessage());
        }
        return new UnknownCommand(UNKNOWN_COMMAND);
    }

    /**
     * Processes a check date command to search for tasks scheduled on a specific date.
     *
     * @param userInput The raw user input string.
     * @return A {@code CheckDateCommand} if the input is valid.
     */
    private Command processCheckDateCommand(String userInput) {
        try {
            if (userInput.length() <= 10) {
                throw new HandleException(MISSING_CHECK_DATE_BODY);
            }
            String dateTimeString = userInput.substring(10).trim();
            if (dateTimeString.isEmpty()) {
                throw new HandleException(MISSING_CHECK_DATE_BODY);
            }
            return new CheckDateCommand(dateTimeString);
        } catch (HandleException e) {
            System.out.println(e.getMessage());
        }
        return new UnknownCommand(UNKNOWN_COMMAND);
    }

}
