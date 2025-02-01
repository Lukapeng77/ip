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
    public static void showTask() {
        System.out.println("____________________________________________________________");
        for (int i = 0; i < taskLength; i++) {
            System.out.print(" " + (i + 1) + ". ");
            System.out.print(tasks[i].getDescription() + "\n");
        }
        System.out.println("____________________________________________________________");
    }

    public static void main(String[] args) {
        String chatbot_name = "Luka77";
        String output = "____________________________________________________________\n"
                + " Hello! I'm " + chatbot_name + "\n"
                + " What can I do for you?\n"
                + "____________________________________________________________\n";
        System.out.println(output);

        String line;
        Scanner in = new Scanner(System.in);

        // use a while loop for iteration
        while (true) {
            line = in.nextLine();

            switch (line) {
            case "bye":
                System.out.println("___________________________________________________\n"
                        + " Bye. Hope to see you again soon!\n"
                        + "____________________________________________________________\n");
                break;
            case "list":
                showTask();
                break;
            default:
                AddTask(line);
                break;
            }
        }
    }
}
