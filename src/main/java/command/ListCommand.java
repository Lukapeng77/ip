package command;

import storage.Storage;
import taskmanager.*;

public class ListCommand extends Command{
    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        UserInterface.printTask(taskList.getTasks(), taskList.getTaskCount());
        //taskList.showTasks();
    }
}
