package com.thoughtworks.tools;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AddCommand {
    private final String[] args;
    // Dependency injection (DI)
    final TaskRepository taskRepository;

    public AddCommand(TaskRepository taskRepository, String... args) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

    List<String> execute() {
        final var taskName = String.join(" ", args);
        return taskRepository.create(new Task(0, taskName, false));
    }

}
