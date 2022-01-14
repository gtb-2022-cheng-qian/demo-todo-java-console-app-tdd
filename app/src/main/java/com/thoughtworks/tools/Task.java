package com.thoughtworks.tools;

public record Task(int id, String name) {

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }
}