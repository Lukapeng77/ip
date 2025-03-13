package parser;

import UserInterface.Ui;
import taskmanager.*;
import exceptions.*;
import command.*;
import static constants.Constants.*;
import java.time.LocalDateTime;
import static exceptions.ExceptionTypes.*;

public class Parser {
    private final TaskList tasklist;
    private final Ui ui;

    public Parser(TaskList tasklist, Ui ui) {
        this.tasklist = tasklist;
        this.ui = ui;
    }

    public Command parse(String userInput) throws HandleException {
        String[] parts = userInput.split(" ", 2);
        String type = parts[0];
        String[] details;

        // Need to check the list tasks case before check the input length
        if (type.equals(COMMAND_GOODBYE)) {
            return new ExitCommand();
        } else if (type.equals(COMMAND_LIST)) {
            return new ListCommand();
        }
        // Handle error message for empty description.
        else if (parts.length < 2 || parts[1].isEmpty()) {
            throw new HandleException(MISSING_INPUT);
        } else if (type.equals(COMMAND_TODO)) {
            return new TodoCommand(parts[1]);

        } else if (type.equals(COMMAND_DEADLINE)) {
            details = parts[1].split(IDENTIFIER_BY, 2);
            LocalDateTime by = LocalDateTime.parse(details[1], INPUT_DATE_FORMAT);
            return new DeadlineCommand(details[0], by);

        } else if (type.equals(COMMAND_EVENT)) {
            details = parts[1].split(IDENTIFIER_FROM, 2);
            String[] durations = details[1].split(IDENTIFIER_TO, 2);
            LocalDateTime from = LocalDateTime.parse(durations[0], INPUT_DATE_FORMAT);
            LocalDateTime to = LocalDateTime.parse(durations[1], INPUT_DATE_FORMAT);
            return new EventCommand(details[0], from, to);

        } else if (type.equals(COMMAND_MARK)) {
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
        } else if (type.equals(COMMAND_UNMARK)) {
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
        } else if (type.equals(COMMAND_DELETE)) {
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
        } else if (type.equals(COMMAND_FIND)) {
            String keyword = userInput.substring(5);
            return new FindCommand(keyword);
        } else if (type.equals(COMMAND_CHECK_DATE)) {
            //details = parts[1].split(" /by ", 2);
            return new CheckDateCommand(parts[1]);
        } else {
            throw new HandleException(INVALID_INPUT);
        }
        return new UnknownCommand(UNKNOWN_COMMAND);
    }
}