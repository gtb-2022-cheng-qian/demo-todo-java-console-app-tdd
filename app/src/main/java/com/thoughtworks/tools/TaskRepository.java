package com.thoughtworks.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final TaskMarshaller taskMarshaller = new TaskMarshaller();

    List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshaller.unmarshal(i + 1, lines.get(i)));//包括+和x标志
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void create(Task task) {
        try (var bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
            final String line = taskMarshaller.marshal(task);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }

}
