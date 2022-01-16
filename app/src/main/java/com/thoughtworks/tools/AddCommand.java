package com.thoughtworks.tools;

import java.util.List;

public class AddCommand {
    private final String[] args;
    final TaskRepository taskRepository = new TaskRepository();

    public AddCommand(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }


    List<String> execute() {
        return taskRepository.create(new Task(0, getArgs()[1], false));
    }

}
