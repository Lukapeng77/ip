package taskmanager;

import tasktypes.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The {@code TaskList} class manages a list of tasks.
 * It provides methods to add, remove, mark, unmark, and find tasks.
 */
public class TaskList {
    /**
     * A list of tasks managed by this task list.
     */
    private final ArrayList<Task> tasks;

    /**
     * Constructs a {@code TaskList} instance with a given list of tasks.
     *
     * @param tasks an {@code ArrayList} of {@code Task} objects to be managed.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Returns the list of tasks.
     *
     * @return an {@code ArrayList} of {@code Task} objects.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the task list.
     *
     * @return the total number of tasks.
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Adds a new task to the task list.
     *
     * @param task the {@code Task} object to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Marks a task as completed.
     *
     * @param index the index of the task to be marked as done.
     */
    public void markTask(int index) {
        tasks.get(index).markAsDone();
    }

    /**
     * Marks a task as not completed.
     *
     * @param index the index of the task to be marked as not done.
     */
    public void unmarkTask(int index) {
        tasks.get(index).markAsNotDone();
    }

    /**
     * Deletes a task from the task list.
     *
     * @param index the index of the task to be removed.
     */
    public void deleteTask(int index) {
        tasks.remove(index);
    }

    /**
     * Finds tasks that contain the specified keyword in their description.
     *
     * @param keyword the search keyword.
     * @return an {@code ArrayList} of matching {@code Task} objects.
     */
    public ArrayList<Task> findTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    /**
     * Finds tasks that are scheduled on the given date.
     *
     * @param date the date to search for tasks.
     * @return an {@code ArrayList} of matching {@code Task} objects.
     */
    public ArrayList<Task> findTasksByDate(LocalDateTime date) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task instanceof Deadline) {
                if (((Deadline) task).getBy().equals(date)) {
                    matchingTasks.add(task);
                }
            } else if (task instanceof Event) {
                if (((Event) task).getFrom().equals(date) || ((Event) task).getTo().equals(date)) {
                    matchingTasks.add(task);
                }
            }
        }
        return matchingTasks;
    }
}