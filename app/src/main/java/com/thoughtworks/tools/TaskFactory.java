package com.thoughtworks.tools;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        final var name = line.split(" ", 2)[1];//不包括+和x标志
        return new Task(id, name);
    }
}