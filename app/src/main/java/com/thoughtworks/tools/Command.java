package com.thoughtworks.tools;

import java.util.List;

public abstract class Command {
    // Dependency injection (DI)
    final TaskRepository taskRepository;

    public Command(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    abstract List<String> execute();
}
