package com.thoughtworks.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskFactoryTest {

    private TaskMarshaller taskMarshaller;

    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    // Unit test
    @Test
    void should_parse_completed_property_for_task() {
        final var isCompleted = taskMarshaller.unmarshal(1, "+ task 01").isCompleted();
        Assertions.assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        final var task = taskMarshaller.unmarshal(1, "+    foo   bar   ");
        Assertions.assertEquals("   foo   bar   ",task.getName());
    }
}
