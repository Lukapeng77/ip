package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.*;
import tasktypes.*;

import java.io.IOException;
import java.time.LocalDateTime;

public class EventCommand extends Command{
    String description;
    LocalDateTime from;
    LocalDateTime to;
    public EventCommand(String description, LocalDateTime from, LocalDateTime to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Task newTask = new Event(description, from, to);
        taskList.addTask(newTask);
        try {
            storage.writeFile(newTask.toString());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        Ui.printAddedTask(newTask, taskList.getTaskCount());
    }
}
