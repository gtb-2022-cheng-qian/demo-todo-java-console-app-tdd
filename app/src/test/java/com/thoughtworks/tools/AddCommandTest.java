package com.thoughtworks.tools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommandTest {
    private MyTaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository=new MyTaskRepository();
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        // 创建一个匿名内部类来传递一个假的TaskRepository, 管控间接输出
//        final var taskRepository = new MyTaskRepository();
        final var command = new AddCommand(taskRepository, "add", "fizz", "buzz");

        command.execute();

        final var taskName = taskRepository.getTaskName();
        assertEquals("fizz buzz", taskName);
    }
    @Test
    void should_use_empty_name_when_noe_args_provided() {
        // 创建一个匿名内部类来传递一个假的TaskRepository
//        final var taskRepository = new MyTaskRepository();
        final var command = new AddCommand(taskRepository, "add");

        command.execute();

        final var taskName = taskRepository.getTaskName();
        assertEquals("", taskName);
    }

    private static class MyTaskRepository extends TaskRepository {
        private Task task;

        @Override
        List<String> create(Task task) {
            this.task=task;
            return List.of();
        }

        public String getTaskName(){
           return this.task.getName();
        }
    }
}
