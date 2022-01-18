package com.thoughtworks.tools;

import java.util.List;

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
        taskRepository.create(new Task(0, taskName, false, false));
        return List.of();
    }

}
