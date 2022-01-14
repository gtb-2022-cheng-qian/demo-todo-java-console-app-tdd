package com.thoughtworks.tools;

import java.nio.file.Path;

public class Constants {
    private Constants() {
    }

    public static final String USER_HOME_PATH = System.getProperty("user.home");
    public static final String TODO_CONFIG_PATH = ".todo";
    public static final String TASKS_FILENAME = "tasks";
    public static final Path TASK_FILE_PATH = Path.of(USER_HOME_PATH, TODO_CONFIG_PATH, TASKS_FILENAME);
}