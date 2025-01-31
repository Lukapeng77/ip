import java.util.Scanner;

public class Luka77 {
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

            if (line.equals("bye")) {
                System.out.println("___________________________________________________\n"
                        + " Bye. Hope to see you again soon!\n"
                        + "____________________________________________________________\n");
            } else {
                System.out.println("___________________________________________________\n");
                System.out.println(" " + line);
                System.out.println("___________________________________________________\n");
            }
        }
    }
}
