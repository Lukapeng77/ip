package command;

import storage.Storage;
import taskmanager.TaskList;
import taskmanager.*;

public class UnknownCommand extends Command{
    String message;
    public UnknownCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        ui.printMessage(message);
    }
}
