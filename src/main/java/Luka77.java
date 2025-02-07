import java.util.Scanner;

public class Luka77 {
    //Create an array of tasks list to store the tasks
    public static Task[] tasks = new Task[100];
    public static int taskLength = 0;

    // Add task function
    public static void AddTask(Task task) {
        tasks[taskLength] = task;
        taskLength++;

        System.out.println("____________________________________________________________\n"
                + "Got it. I've added this task:" + "\n"
                + task.toString() + "\n"
                + "Now you have " + taskLength + " tasks in the list." + "\n"
                + "____________________________________________________________");

    }

    // Show tasks function
    public static void showTasks() {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskLength; i++) {
            System.out.println((i+1) + "." + tasks[i].toFileFormat());
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

    public static void main(String[] args) throws Exception {
        String chatbot_name = "Luka77";
        String output = "____________________________________________________________\n"
                + " Hello! I'm " + chatbot_name + "\n"
                + " What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(output);

        // use a while loop for iteration
        while (true) {
            Scanner userInput = new Scanner(System.in);
            String task = userInput.nextLine();
            Task newTask;

            String[] parts = task.split(" ", 2);
            String type = parts[0];
            String[] details;

            if (type.equals("bye")) {
                System.out.println("____________________________________________________________\n"
                        + "Bye. Hope to see you again soon!\n"
                        + "____________________________________________________________\n");
                break;
            } else if (type.equals("list")) {
                showTasks();
            } else if (type.equals("todo")) {
                newTask = new Todo(parts[1]);
                AddTask(newTask);

            } else if (type.equals("deadline")) {
                details = parts[1].split(" /by", 2);
                newTask = new Deadline(details[0], details[1]);
                AddTask(newTask);

            } else if (type.equals("event")) {
                details = parts[1].split(" /from ", 2);
                String[] durations = details[1].split(" /to ", 2);
                newTask = new Event(details[0], durations[0], durations[1]);
                AddTask(newTask);

            } else if (type.equals("mark")) {
                try {
                    int taskIndex = Integer.parseInt(task.split(" ")[1]);
                    if (taskIndex > 0 && taskIndex <= taskLength) {
                        markTask(taskIndex - 1);
                    } else {
                        System.out.println("Out of bounds!");
                    }
                } catch (Exception e) {
                    System.out.println("Error marking task!");
                }
            } else if (type.equals("unmark")) {
                try {
                    int taskIndex = Integer.parseInt(task.split(" ")[1]);
                    if (taskIndex > 0 && taskIndex <= taskLength) {
                        unmarkTask(taskIndex - 1);
                    } else {
                        System.out.println("Out of bounds!");
                    }
                } catch (Exception e) {
                    System.out.println("Error marking task!");
                }
            } else {
                // Handle error message for invalid input
                throw new Exception("User input is invalid task type!");
            }
        }
    }
}
