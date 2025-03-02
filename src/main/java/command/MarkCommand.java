package command;

import storage.Storage;
import taskmanager.TaskList;
import taskmanager.*;
import tasktypes.*;

import java.io.IOException;

public class MarkCommand extends Command{
    int taskIndex;
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        taskList.markTask(taskIndex);
        Task updatedTask = taskList.getTasks().get(taskIndex);
        UserInterface.printMarkAsDone(updatedTask);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
