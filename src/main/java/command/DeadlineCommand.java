package command;

import exceptions.HandleException;
import static exceptions.ExceptionTypes.*;
import storage.Storage;
import taskmanager.TaskList;
import taskmanager.*;
import tasktypes.*;
import static constants.Constants.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class DeadlineCommand extends Command {
    String description;
    LocalDateTime by;

    public DeadlineCommand(String description, LocalDateTime by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) throws HandleException {
        Task newTask = new Deadline(description, by);

        taskList.addTask(newTask);
        try {
            storage.writeFile(newTask.toString());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        UserInterface.printAddedTask(newTask, taskList.getTaskCount());
    }
}
