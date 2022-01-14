package com.thoughtworks.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskFactoryTest {
    @Test
    void should_parse_completed_property_for_task() {
        final var isCompleted = TaskFactory.createTask(1, "+ task 01").isCompleted();
        Assertions.assertFalse(isCompleted);
    }
}
