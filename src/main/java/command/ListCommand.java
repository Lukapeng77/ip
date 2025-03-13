package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.*;

public class ListCommand extends Command{
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Ui.printTask(taskList.getTasks(), taskList.getTaskCount());
    }
}
