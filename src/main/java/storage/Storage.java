package storage;

import tasktypes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath; // The file path where tasks are stored.

    public Storage(String filePath) {
        this.filePath = filePath;
    }

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

    public void writeFile(String input) throws IOException {
        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.append(input).append(System.lineSeparator());
        }
    }

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

    public void save(ArrayList<Task> tasks) throws IOException {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat() + System.lineSeparator());
            }
        }
    }

    private Task parseLineToTask(String line) {
        String[] parts = line.split(" \\| ");
        String type = parts[0];
        Task task = null;

        try {
            task = switch (type) {
                case "T" -> new Todo(parts[2].trim());
                case "D" -> new Deadline(parts[2].trim(), parts[3].trim());
                case "E" -> new Event(parts[2].trim(), parts[3].trim(), parts[4].trim());
                default -> task;
            };

            if (task != null) {
                boolean isDone = parts[1].trim().equals("1");
                task.setDone(isDone);
            }
        } catch (Exception e) {
            System.err.println("Failed to parse line into task: " + line);
        }
        return task;
    }
}
