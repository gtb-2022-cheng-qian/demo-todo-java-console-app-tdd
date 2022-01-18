package com.thoughtworks.tools;

import java.util.List;

public class UnknownCommand extends Command {
    private final String commandName;

    public UnknownCommand(TaskRepository repository, String commandName) {
        super(repository);
        this.commandName = commandName;
    }

    @Override
    List<String> execute() { // List<String>返回值类型并不固定
        return List.of("Unknown command: " + commandName + "!");
    }
}
