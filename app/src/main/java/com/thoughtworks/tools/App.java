/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thoughtworks.tools;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length <= 0) {
            return new ListCommand().run();
        }
        final var restArgs = Arrays.copyOfRange(args, 1, args.length);
        if (args[0].equals("add")) {
            return new AddCommand(new TaskRepository(), restArgs).execute();
        }
        return new ListCommand().run();
    }

}
