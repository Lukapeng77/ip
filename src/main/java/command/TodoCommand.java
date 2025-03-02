package command;

import storage.Storage;
import taskmanager.*;
import tasktypes.*;

import java.io.IOException;

public class TodoCommand extends Command{
    String description;
    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        Task newTask = new Todo(description);
        taskList.addTask(newTask);
        try {
            storage.writeFile(newTask.toString());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        UserInterface.printAddedTask(newTask, taskList.getTaskCount());
    }
}
