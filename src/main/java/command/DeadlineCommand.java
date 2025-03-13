package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;
import tasktypes.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class DeadlineCommand extends Command{
    String description;
    LocalDateTime by;
    public DeadlineCommand(String description, LocalDateTime by) {
        this.description = description;
        this.by = by;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Deadline(description, by);
        taskList.addTask(newTask);
        try {
            storage.writeFile(newTask.toString());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        Ui.printAddedTask(newTask, taskList.getTaskCount());
    }
}
