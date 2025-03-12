package command;

import storage.Storage;
import taskmanager.TaskList;
import taskmanager.*;
import tasktypes.*;
import java.io.IOException;

public class DeadlineCommand extends Command{
    String description;
    String by;
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
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
