package com.thoughtworks.tools;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command {

    public ListCommand(TaskRepository taskRepository) {
        super(taskRepository);
    }

    @Override
    List<String> execute() {
        final List<Task> tasks = taskRepository.all();
        final List<String> result = new ArrayList<>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }
}
