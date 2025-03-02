package command;

import storage.Storage;
import taskmanager.*;

public class ExitCommand extends Command{

        @Override
        public void execute(TaskList taskList, UserInterface ui, Storage storage) {
            ui.printGoodbyeMessage();
        }
        @Override
        public boolean isExit() {
            return true;
        }
}
