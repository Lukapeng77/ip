package command;

import UserInterface.Ui;
import storage.Storage;
import taskmanager.*;

public class ExitCommand extends Command{

        @Override
        public void execute(TaskList taskList, Ui ui, Storage storage) {
            ui.printGoodbyeMessage();
        }
        @Override
        public boolean isExit() {
            return true;
        }
}
