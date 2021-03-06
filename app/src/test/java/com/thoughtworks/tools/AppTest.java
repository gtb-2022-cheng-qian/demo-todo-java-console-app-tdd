/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.thoughtworks.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        TestUtil.writeDataFile(List.of(
                "+ + task 01",
                "+ + task 02",
                "x + task 03",
                "x + task 04"));
        app = new App();
    }

    @Nested
    class ListCommand {
        @Nested
        class WhenThereAreExistingTasks {
            @Test
            void should_list_existing_tasks() {
                // integration test
                // Given
                // When
                final var result = app.run("list");
                // Then
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "1 task 01",
                                "2 task 02",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        result);
            }
        }
    }

    @Nested
    class AddCommand {
        @Nested
        class WhenSingleWordProvidedAsName {
            @Test
            void should_use_single_word_as_name() {
                // AAA
                // Arrange-Act-Assert

                // Given - Arrange
                // When - Act
                app.run("add", "foobar");
                // Then - Assert
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "1 task 01",
                                "2 task 02",
                                "5 foobar",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        result);
            }
        }

        @Nested
        class WhenMultipleWordProvidedAsName {
            @Test
            void should_use_all_words_as_name() {
                // AAA
                // Arrange-Act-Assert

                // Given - Arrange
                // When - Act
                app.run("add", "fizz", "buzz");
                // Then - Assert
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "1 task 01",
                                "2 task 02",
                                "5 fizz buzz",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        result);
            }
        }
    }

    @Nested
    class RemoveCommand {
        @Nested
        class WhenRemoveSingleTask {
            @Test
            void should_remove_one_task() {
                app.run("remove", "1");
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "2 task 02",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        result);
            }
        }

        @Nested
        class WhenRemoveMultipleTask {
            @Test
            void should_remove_some_tasks() {
                app.run("remove", "1", "3");
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "2 task 02",
                                "# Completed",
                                "4 task 04"),
                        result);
            }
        }
    }

    @Nested
    class UnknownCommand {
        @Nested
        class WhenCmdNameIsUnknown {
            @Test
            void should_give_hint() {
                final var result = app.run("foobar");
                Assertions.assertEquals(List.of("Unknown command: foobar!"), result);
            }
        }
    }
}
