package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] res = todos.search("Позвонить родителям");

        SimpleTask expected = simpleTask;

        Assertions.assertArrayEquals(new SimpleTask[]{expected}, res);

        System.out.println(Arrays.deepToString(res));
        System.out.println(expected);
    }

    @Test
    public void shouldSearchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] res = todos.search("Выкатка 3й версии приложения");

        Meeting expected = meeting;

        Assertions.assertArrayEquals(new Meeting[]{expected}, res);

        System.out.println(Arrays.deepToString(res));
        System.out.println(expected);
    }

    @Test
    public void shouldSearchEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] res = todos.search("Молоко");

        Epic expected = epic;

        Assertions.assertArrayEquals(new Epic[]{expected}, res);

        System.out.println(Arrays.deepToString(res));
        System.out.println(expected);
    }



}