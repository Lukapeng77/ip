package command;

import storage.Storage;
import taskmanager.TaskList;
import taskmanager.UserInterface;

import java.io.IOException;

public class FindCommand extends Command {
    String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        UserInterface.printFindTask(taskList.getTasks(), taskList.getTaskCount(), keyword);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

