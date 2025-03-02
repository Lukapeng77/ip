package parser;

import taskmanager.*;
import exceptions.*;
import command.*;

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
            throw new MissingInputException();
        } else if (type.equals("todo")) {
            return new TodoCommand(parts[1]);

        } else if (type.equals("deadline")) {
            details = parts[1].split(" /by", 2);
            return new DeadlineCommand(details[0], details[1]);

        } else if (type.equals("event")) {
            details = parts[1].split(" /from ", 2);
            String[] durations = details[1].split(" /to ", 2);
            return new EventCommand(details[0], durations[0], durations[1]);

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
        } else {
            // Handle error message for invalid input or general error
            throw new InvalidInputException();
        }
        return new UnknownCommand("Sorry, I don't know what do you mean :((");
    }
}