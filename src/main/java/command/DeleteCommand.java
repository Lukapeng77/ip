package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;

import java.io.IOException;

public class DeleteCommand extends Command{
    int taskIndex;
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Ui.printDeleteTask(taskList.getTasks().get(taskIndex), taskList.getTaskCount() - 1);
        taskList.deleteTask(taskIndex);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
