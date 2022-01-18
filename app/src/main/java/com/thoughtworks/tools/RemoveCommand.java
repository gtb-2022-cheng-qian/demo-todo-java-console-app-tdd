package com.thoughtworks.tools;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveCommand extends Command{
    private final String[] args;

    public RemoveCommand(TaskRepository taskRepository, String... args) {
        super(taskRepository);
        this.args = args;
    }

    @Override
    public List<String> execute() {
        final var ids = Stream.of(args)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        taskRepository.all().stream()
                .filter(task -> ids.contains(task.getId()))
                .forEach(task -> taskRepository.delete(task.getId()));
        return List.of();
    }
}
