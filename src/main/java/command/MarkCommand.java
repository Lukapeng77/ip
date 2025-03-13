package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;
import tasktypes.*;

import java.io.IOException;

public class MarkCommand extends Command{
    int taskIndex;
    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.markTask(taskIndex);
        Task updatedTask = taskList.getTasks().get(taskIndex);
        Ui.printMarkAsDone(updatedTask);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
