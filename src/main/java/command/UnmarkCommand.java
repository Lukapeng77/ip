package command;

import storage.Storage;
import taskmanager.TaskList;
import taskmanager.*;
import tasktypes.*;

import java.io.IOException;

public class UnmarkCommand extends Command{
    int taskIndex;
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        taskList.unmarkTask(taskIndex);
        Task updatedTask = taskList.getTasks().get(taskIndex);
        UserInterface.printMarkAsUndone(updatedTask);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
