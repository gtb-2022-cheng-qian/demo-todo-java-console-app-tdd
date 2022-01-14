package com.thoughtworks.tools;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        final var fields = line.split(" ", 2);//不包括+和x标志
        final var name = fields[1];
        final boolean isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted);
    }
}