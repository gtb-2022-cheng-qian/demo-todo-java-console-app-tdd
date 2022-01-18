package com.thoughtworks.tools;

import java.util.List;

public class RemoveCommand {
    private TaskRepository taskRepository;
    private String[] args;

    public RemoveCommand(TaskRepository taskRepository, String... args) {
        this.taskRepository = taskRepository;
        this.args = args;
    }

    public List<String> execute() {
        this.taskRepository.delete(Integer.parseInt(args[0]));
        return List.of();
    }
}
