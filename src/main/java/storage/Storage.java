package storage;

import tasktypes.*;

import parser.DateParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The {@code Storage} class handles reading, writing, and managing task data in a file.
 * It ensures persistent storage of tasks by saving and loading them from the specified file.
 */
public class Storage {
    /**
     * The file path where tasks are stored.
     */
    private final String filePath;

    /**
     * Constructs a {@code Storage} instance with the specified file path.
     *
     * @param filePath the file path where tasks will be stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Creates the task file if it does not exist, along with its parent directories.
     *
     * @throws IOException if an I/O error occurs while creating the file.
     */
    public void createFile() throws IOException {
        File file = new File(filePath);

        // Ensure the parent directories exist (if there are any)
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        // Create the file if it doesn't already exist
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * Writes a new task entry to the file.
     *
     * @param input the task information to be written to the file.
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void writeFile(String input) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.append(input).append(System.lineSeparator());
        }
    }

    /**
     * Loads tasks from the file and returns them as an {@code ArrayList}.
     *
     * @return an {@code ArrayList} of tasks retrieved from the file.
     */
    public ArrayList<Task> load() {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    Task task = parseLineToTask(line);
                    if (task != null) {
                        loadedTasks.add(task);
                    }
                }
            } catch (IOException e) {
                System.out.println("Unable to read tasks from file: " + e.getMessage());
            }
        }
        return loadedTasks;
    }

    /**
     * Saves the current task list to the file, overwriting existing content.
     *
     * @param tasks the list of tasks to be saved.
     * @throws IOException if an I/O error occurs during file writing.
     */
    public void save(ArrayList<Task> tasks) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat() + System.lineSeparator());
            }
        }
    }

    /**
     * Parses a line from the file and converts it into a {@code Task} object.
     *
     * @param userInput a string representing a stored task.
     * @return a {@code Task} object parsed from the input line, or {@code null} if parsing fails.
     */
    private Task parseLineToTask(String userInput) {
        String[] parts = userInput.split(" \\| ");
        String type = parts[0];
        Task task = null;

        try {
            switch (type) {
            case "T":
                task = new Todo(parts[2].trim());
                break;
            case "D":
                LocalDateTime by = DateParser.parseDateTime(parts[3].trim());
                task = new Deadline(parts[2].trim(), by);
                break;
            case "E":
                LocalDateTime from = DateParser.parseDateTime(parts[3]);
                LocalDateTime to = DateParser.parseDateTime(parts[4]);
                task = new Event(parts[2].trim(), from, to);
                break;
            }
            if (task != null) {
                boolean isDone = parts[1].trim().equals("1");
                task.setDone(isDone);
            }
        } catch (Exception e) {
            System.err.println("Failed to parse line into task: " + userInput);
        }
        return task;
    }
}
