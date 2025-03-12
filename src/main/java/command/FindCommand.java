package command;

import storage.Storage;
import taskmanager.TaskList;
import taskmanager.UserInterface;
import tasktypes.Task;

import java.io.IOException;
import java.util.ArrayList;

public class FindCommand extends Command {
    String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, UserInterface ui, Storage storage) {
        ArrayList<Task>matchingTasks = taskList.findTask(keyword);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        UserInterface.printFindTask(matchingTasks, matchingTasks.size());
    }
}

