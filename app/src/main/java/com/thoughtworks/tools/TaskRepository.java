package com.thoughtworks.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            final var id = i + 1;
            final var line = lines.get(i);//包括+和x标志
            final var name = line;//不包括+和x标志
            final var task = new Task(id, name);
            tasks.add(task);
        }
        return tasks;
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new todoCannotReadFileException();
        }
    }
}