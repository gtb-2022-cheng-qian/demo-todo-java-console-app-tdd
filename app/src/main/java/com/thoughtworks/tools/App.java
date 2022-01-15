/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thoughtworks.tools;

import java.util.ArrayList;
import java.util.List;

public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        final List<Task> tasks = taskRepository.loadTasks();
        final List<String> result = new ArrayList<>();

        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));

        return result;
    }
}
