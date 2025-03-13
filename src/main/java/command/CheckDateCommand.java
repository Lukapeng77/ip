package command;

import static exceptions.ExceptionTypes.*;

import exceptions.HandleException;
import storage.Storage;
import taskmanager.*;
import tasktypes.*;
import static constants.Constants.SEARCH_DATE_FORMAT;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class CheckDateCommand extends Command {

    protected LocalDate dateTime;


    public CheckDateCommand(String dateTimeString) throws HandleException {
        try {
            this.dateTime = LocalDate.parse(dateTimeString, SEARCH_DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new HandleException(INVALID_DATE);
        }
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) throws HandleException {

        // Search for tasks matching the specified date
        ArrayList<Task> matchingTasks = taskList.findTasksByDate(dateTime);

        ui.showTasksByDate(matchingTasks, dateTime);
    }
}