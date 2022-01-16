/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thoughtworks.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length > 0 && args[0].equals("add")) {
            return execute(args);
        }
        return listCommand.run();
    }

    private List<String> execute(String[] args) {
        try (var bw = Files.newBufferedWriter(Constants.TASK_FILE_PATH, StandardOpenOption.APPEND)) {
            final var taskName = args[1];
            bw.write("+ " + taskName);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
        return List.of();
    }
}
