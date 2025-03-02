package command;

import storage.Storage;
import taskmanager.*;
import tasktypes.*;

import java.io.IOException;

public class EventCommand extends Command{
    String description;
    String from;
    String to;
    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        Task newTask = new Event(description, from, to);
        taskList.addTask(newTask);
        try {
            storage.writeFile(newTask.toString());
        } catch (IOException e) {
            ui.printMessage("Error writing to file: " + e.getMessage());
        }
        UserInterface.printAddedTask(newTask, taskList.getTaskCount());
    }
}
