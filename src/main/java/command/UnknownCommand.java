package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.TaskList;

public class UnknownCommand extends Command{
    String message;
    public UnknownCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printMessage(message);
    }
}
