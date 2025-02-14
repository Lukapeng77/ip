import tasktypes.*;
import static constants.Constants.*;

public class TaskList {
    private final Task[] tasks;
    int taskLength = 0;

    public TaskList(){
        tasks = new Task[LIST_SIZE];
    }

    // Add task function
    public void addTask(Task task) {
        tasks[taskLength] = task;
        taskLength++;

        System.out.println(LINE_SEPARATOR
                + "Got it. I've added this task:" + "\n"
                + task.toString() + "\n"
                + "Now you have " + taskLength + " tasks in the list." + "\n"
                + LINE_SEPARATOR);

    }

    // Show tasks function
    public void showTasks() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskLength; i++) {
            System.out.println((i + 1) + "." + tasks[i].toFileFormat());
        }
        System.out.println(LINE_SEPARATOR);
    }

    // Mark task function
    public void markTask(int index) {
        tasks[index].markAsDone();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Nice! I've marked this task as done:");
        System.out.print("[" + tasks[index].getStatusIcon() + "] ");
        System.out.print(tasks[index].getDescription() + "\n");
        System.out.println(LINE_SEPARATOR);
    }

    // Unmark task function
    public void unmarkTask(int index) {
        tasks[index].markAsNotDone();
        System.out.println(LINE_SEPARATOR);
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.print("[" + tasks[index].getStatusIcon() + "] ");
        System.out.print(tasks[index].getDescription() + "\n");
        System.out.println(LINE_SEPARATOR);
    }
}
