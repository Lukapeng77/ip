package command;

import exceptions.HandleException;
import storage.Storage;
import taskmanager.TaskList;
import taskmanager.UserInterface;

public class Command {
    public void execute(TaskList taskList, UserInterface ui, Storage storage) throws HandleException {

    }

    public boolean isExit() {
        return false;
    }
}
