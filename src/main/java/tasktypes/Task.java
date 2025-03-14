package tasktypes;

/**
 * Represents a generic task in the task list.
 * This class serves as a base class for different types of tasks
 * such as todos, deadlines, and events.
 */

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description. By default, the task is not done.
     *
     * @param description The text description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a status icon indicating whether the task is done.
     *
     * @return A string representing a check mark if done, or a space if not done.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Sets the done status of the task.
     *
     * @param isDone True if the task is done, false otherwise.
     */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Formats the task for file storage, including its done status and description.
     *
     * @return A string representation of the task suitable for file storage.
     */
    public String toFileFormat() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }

    /**
     * Returns a string representation of the task, including its status icon and description.
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "]" + this.getDescription();
    }
}
