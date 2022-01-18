package com.thoughtworks.tools;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RemoveCommandTest {
    @Test
    void should_remove_multiple_tasks() {
        final var taskRepository = mock(TaskRepository.class);

        RemoveCommand command = new RemoveCommand(taskRepository, "1", "3");
        command.execute();

        verify(taskRepository).delete(1);
        verify(taskRepository).delete(3);
    }
}
