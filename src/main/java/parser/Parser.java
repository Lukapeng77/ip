package parser;

import taskmanager.*;
import exceptions.*;
import command.*;
import static constants.Constants.*;
import java.time.LocalDateTime;

import static exceptions.ExceptionTypes.*;

public class Parser {
    private final TaskList tasklist;
    private final UserInterface ui;

    public Parser(TaskList tasklist, UserInterface ui) {
        this.tasklist = tasklist;
        this.ui = ui;
    }

    public Command parse(String userInput) throws HandleException {
        String[] parts = userInput.split(" ", 2);
        String type = parts[0];
        String[] details;

        // Need to check the list tasks case before check the input length
        if (type.equals("bye")) {
            return new ExitCommand();
        } else if (type.equals("list")) {
            return new ListCommand();
        }
        // Handle error message for empty description.
        else if (parts.length < 2 || parts[1].isEmpty()) {
            throw new HandleException(MISSING_INPUT);
        } else if (type.equals("todo")) {
            return new TodoCommand(parts[1]);

        } else if (type.equals("deadline")) {
            details = parts[1].split(" /by ", 2);
            LocalDateTime by = LocalDateTime.parse(details[1], INPUT_DATE_FORMAT);
            return new DeadlineCommand(details[0], by);

        } else if (type.equals("event")) {
            details = parts[1].split(" /from ", 2);
            String[] durations = details[1].split(" /to ", 2);
            LocalDateTime from = LocalDateTime.parse(durations[0], INPUT_DATE_FORMAT);
            LocalDateTime to = LocalDateTime.parse(durations[1], INPUT_DATE_FORMAT);
            return new EventCommand(details[0], from, to);

        } else if (type.equals("mark")) {
            try {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                if (taskIndex > 0 && taskIndex <= tasklist.getTasks().size()) {
                    return new MarkCommand(taskIndex - 1);
                } else {
                    System.out.println("Out of bounds!");
                }
            } catch (Exception e) {
                System.out.println("Error marking task!");
            }
        } else if (type.equals("unmark")) {
            try {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                if (taskIndex > 0 && taskIndex <= tasklist.getTasks().size()) {
                    return new UnmarkCommand(taskIndex - 1);
                } else {
                    System.out.println("Out of bounds!");
                }
            } catch (Exception e) {
                System.out.println("Error marking task!");
            }
        } else if (type.equals("delete")) {
            try {
                int taskIndex = Integer.parseInt(userInput.split(" ")[1]);
                if (taskIndex > 0 && taskIndex <= tasklist.getTasks().size()) {
                    return new DeleteCommand(taskIndex - 1);
                } else {
                    System.out.println("Out of bounds!");
                }
            } catch (Exception e) {
                System.out.println("Error deleting task!");
            }
        } else if (type.equals("find")) {
            String keyword = userInput.substring(5);
            return new FindCommand(keyword);
        } else if (type.equals("checkDate")) {
            //details = parts[1].split(" /by ", 2);
            return new CheckDateCommand(parts[1]);
        } else {
            // Handle error message for invalid input or general error
            throw new HandleException(INVALID_INPUT);
        }
        return new UnknownCommand("Sorry I have no idea what you mean, please give the command with a keyword!");
    }
}