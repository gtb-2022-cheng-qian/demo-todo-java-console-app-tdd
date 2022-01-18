package com.thoughtworks.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {

    private final TaskMarshaller taskMarshaller = new TaskMarshaller();

    List<Task> all() {
        final List<Task> tasks = loadTasks();
        return tasks.stream().filter(task -> !task.isDeleted()).collect(Collectors.toList());
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASK_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void delete(int id) {
        final var tasks = loadTasks();
        tasks.stream().filter(task -> id == task.getId()).forEach(Task::delete);

        try (var bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH)) {
           for (Task task : tasks){
               bw.write(taskMarshaller.marshal(task));
               bw.newLine();
           }
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    private List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshaller.unmarshal(i + 1, lines.get(i)));//包括+和x标志
        }
        return tasks;
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
