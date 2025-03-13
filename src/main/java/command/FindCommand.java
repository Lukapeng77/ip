package command;

import storage.Storage;
import taskmanager.TaskList;
import UserInterface.Ui;
import tasktypes.Task;

import java.io.IOException;
import java.util.ArrayList;

public class FindCommand extends Command {
    String keyword;

    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ArrayList<Task>matchingTasks = taskList.findTask(keyword);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Ui.printFindTask(matchingTasks, matchingTasks.size());
    }
}

