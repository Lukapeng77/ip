import java.util.Scanner;

public class Luka77 {
    //Create a String array to store the tasks
    public static Task[] tasks = new Task[100];
    public static int taskLength = 0;

    // Add task function
    public static void AddTask(String task) {
        System.out.println("____________________________________________________________\n"
                + " added: " + task + "\n"
                + "____________________________________________________________");
        Task newTask = new Task(task);
        tasks[taskLength] = newTask;
        taskLength++;
    }

    // Show tasks function
    public static void showTasks() {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskLength; i++) {
            System.out.print(" " + (i + 1) + "." + "[" + tasks[i].getStatusIcon() + "] ");
            System.out.print(tasks[i].getDescription() + "\n");
        }
        System.out.println("____________________________________________________________");
    }

    // Mark task function
    public static void markTask(int index) {
        tasks[index].markAsDone();
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done:");
        System.out.print("[" + tasks[index].getStatusIcon() + "] ");
        System.out.print(tasks[index].getDescription() + "\n");
        System.out.println("____________________________________________________________");
    }

    // Unmark task function
    public static void unmarkTask(int index) {
        tasks[index].markAsNotDone();
        System.out.println("____________________________________________________________");
        System.out.println("Ok, I've marked this task as not done yet:");
        System.out.print("[" + tasks[index].getStatusIcon() + "] ");
        System.out.print(tasks[index].getDescription() + "\n");
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        String chatbot_name = "Luka77";
        String output = "____________________________________________________________\n"
                + " Hello! I'm " + chatbot_name + "\n"
                + " What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(output);

        String task;
        Scanner in = new Scanner(System.in);

        // use a while loop for iteration
        while (true) {
            task = in.nextLine();
            if (task.equals("bye")) {
                break;
            } else if (task.equals("list")) {
                showTasks();
            } else if (task.startsWith("mark ")) {
                try {
                    int taskIndex = Integer.parseInt(task.split(" ")[1]);
                    if (taskIndex > 0 && taskIndex <= taskLength) {
                        markTask(taskIndex);
                    } else {
                        System.out.println("Out of bounds!");
                    }
                } catch (Exception e) {
                    System.out.println("Error marking task!");
                }
            } else if (task.startsWith("unmark ")) {
                try {
                    int taskIndex = Integer.parseInt(task.split(" ")[1]);
                    if (taskIndex > 0 && taskIndex <= taskLength) {
                        unmarkTask(taskIndex);
                    } else {
                        System.out.println("Out of bounds!");
                    }
                } catch (Exception e) {
                    System.out.println("Error marking task!");
                }
            } else {
                AddTask(task);
            }
        }
    }
}
