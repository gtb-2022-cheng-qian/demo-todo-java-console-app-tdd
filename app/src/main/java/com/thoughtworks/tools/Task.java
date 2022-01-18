package com.thoughtworks.tools;

import java.util.Objects;

public class Task {
    private final int id;
    private final String name;
    public boolean isCompleted;
    private boolean delete;

    public Task(int id, String name, boolean isCompleted, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
        this.delete = isDeleted;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", delete=" + delete +
                ", isCompleted=" + isCompleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && delete == task.delete && isCompleted == task.isCompleted && name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, delete, isCompleted);
    }

    public boolean isDeleted() {
        return this.delete;
    }

    public void delete() {
        this.delete = true;
    }
}
