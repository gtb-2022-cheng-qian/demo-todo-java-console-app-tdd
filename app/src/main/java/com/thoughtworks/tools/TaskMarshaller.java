package com.thoughtworks.tools;

public class TaskMarshaller {

    String marshal(Task task) {
        final var completedSign = task.isCompleted() ? "x" : "+";
        final var deletedSign = task.isDeleted() ? "x" : "+";
        return completedSign + " " + deletedSign + " " + task.getName();
    }

    Task unmarshal(int id, String line) {
        final var fields = line.split(" ", 3);//不包括+和x标志
        final var name = fields[2];
        final boolean isCompleted = fields[0].equals("x");
        final boolean isDeleted = fields[1].equals("x");
        return new Task(id, name, isCompleted, isDeleted);
    }
}
