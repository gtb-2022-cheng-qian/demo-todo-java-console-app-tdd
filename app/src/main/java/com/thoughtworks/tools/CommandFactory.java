package com.thoughtworks.tools;

import java.util.Arrays;

public class CommandFactory {
    private CommandFactory() {
    }

    static Command create(TaskRepository repository, String[] args) {
        final var commandName = args[0];
        final var restArgs = Arrays.copyOfRange(args, 1, args.length);

        Command command = new UnknownCommand(repository, commandName);
        if (commandName.equals("list")) {
            command = new ListCommand(repository);
        }
        if (commandName.equals("add")) {
            command = new AddCommand(repository, restArgs);
        }
        if (commandName.equals("remove")) {
            command = new RemoveCommand(repository, restArgs);
        }
        return command;
    }
}
