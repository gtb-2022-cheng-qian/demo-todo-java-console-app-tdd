package com.thoughtworks.tools;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class TaskTest {

    @Nested
    class Equals{
        @Nested
        class should_return_true{
            @Test
            void when_all_properties_are_same(){
                assertEquals(new Task(1,"foo",false),new Task(1,"foo",false));
                assertEquals(new Task(1,"foo",true),new Task(1,"foo",true));
            }
        }

        @Nested
        class should_return_false{
            @Test
            void when_at_least_one_property_is_not_same(){
                assertNotEquals(new Task(1,"foo",false),new Task(2,"foo",false));
                assertNotEquals(new Task(1,"bar",true),new Task(1,"foo",true));
                assertNotEquals(new Task(1,"foo",false),new Task(1,"foo",true));
            }
        }
    }
}
