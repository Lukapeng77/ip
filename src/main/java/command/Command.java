package command;

import exceptions.HandleException;
import storage.Storage;
import taskmanager.TaskList;
import UserInterface.Ui;

public class Command {
    public void execute(TaskList taskList, Ui ui, Storage storage) throws HandleException {

    }

    public boolean isExit() {
        return false;
    }
}
