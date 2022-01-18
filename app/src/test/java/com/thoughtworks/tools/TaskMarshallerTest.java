package com.thoughtworks.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TaskMarshallerTest {

    private TaskMarshaller taskMarshaller;

    @BeforeEach
    void setUp() {
        taskMarshaller = new TaskMarshaller();
    }

    // Unit test

    @Test
    void should_marshal_to_plain_text() {
        assertEquals("+ foo", taskMarshaller.marshal(new Task(1, "foo", false, false)));
    }

    @Test
    void should_parse_completed_property_for_task() {
        final var isCompleted = taskMarshaller.unmarshal(1, "+ task 01").isCompleted();
        assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        final var task = taskMarshaller.unmarshal(1, "+    foo   bar   ");
        assertEquals("   foo   bar   ",task.getName());
    }
}
