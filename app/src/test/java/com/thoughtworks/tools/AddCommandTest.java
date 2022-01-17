package com.thoughtworks.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AddCommandTest {
    private TaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        // 使用Mockito mock()来做test double，即使用一个假TaskRepository作为替身，实现间接输出
        taskRepository = mock(TaskRepository.class);
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        final AddCommand command = createCommand("fizz", "buzz");

        command.execute();

        verify(taskRepository).create(new Task(0, "fizz buzz", false));
    }

    @Test
    void should_use_empty_name_when_noe_args_provided() {
        final AddCommand command = createCommand();

        command.execute();

        verify(taskRepository).create(new Task(0, "", false));
    }

    private AddCommand createCommand(String... strings) {
        return new AddCommand(taskRepository, strings);
    }

}
