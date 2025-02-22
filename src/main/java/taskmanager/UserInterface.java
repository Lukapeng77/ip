package taskmanager;

import java.util.Scanner;
import static constants.Constants.*;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public void printWelcomeMessage() {
        String chatbot_name = "Luka";
        System.out.println(LINE_SEPARATOR
                + " Hello! I'm " + chatbot_name + "\n"
                + " What can I do for you?\n"
                + LINE_SEPARATOR);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGoodbyeMessage() {
        System.out.println(LINE_SEPARATOR
                + "Bye. Hope to see you again soon!\n"
                + LINE_SEPARATOR);
    }
}
