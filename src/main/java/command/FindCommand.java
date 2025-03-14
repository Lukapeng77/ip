package command;

import storage.Storage;
import taskmanager.TaskList;
import UserInterface.Ui;
import tasktypes.Task;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a command to find tasks that match a given keyword.
 */
public class FindCommand extends Command {
    String keyword;

    /**
     * Creates a FindCommand with the specified keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the command by searching for tasks containing the keyword
     * and displaying the results.
     *
     * @param taskList The task list to search in.
     * @param ui       The user interface for displaying messages.
     * @param storage  The storage that saves tasks inputted by users.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ArrayList<Task> matchingTasks = taskList.findTask(keyword);
        try {
            storage.save(taskList.getTasks());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Ui.printFindTask(matchingTasks, matchingTasks.size());
    }
}

