package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
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

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] res = todos.search("Позвонить родителям");

        Task[] expected = {simpleTask};

        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void shouldSearchEmptySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] res = todos.search("");

        Task[] expected = {simpleTask};

        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void shouldSearchNonExistingElementSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] res = todos.search("zzzzzzzz");

        Task[] expected = {};

        Assertions.assertArrayEquals(expected, res);
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

        Task[] expected = {meeting};

        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void shouldSearchNonExistingElementMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] res = todos.search("zzzzzzzzzz");

        Task[] expected = {};

        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void shouldSearchEmptyMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] res = todos.search("");

        Task[] expected = {meeting};

        Assertions.assertArrayEquals(expected, res);
    }


    @Test
    public void shouldSearchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] res = todos.search("Молоко");

        Task[] expected = {epic};

        Assertions.assertArrayEquals(expected, res);

    }

    @Test
    public void shouldSearchEmptyEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] res = todos.search("");

        Task[] expected = {epic};

        Assertions.assertArrayEquals(expected, res);

    }

    @Test
    public void shouldSearchNonExistingElementEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        Task[] res = todos.search("zzzzzzzzzzzzzzzz");

        Task[] expected = {};

        Assertions.assertArrayEquals(expected, res);

    }

    @Test
    public void shouldSearchMultiTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить молоко");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
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

        Task[] res = todos.search("молоко");

        Task[] expected = {simpleTask, epic};
        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void shouldSearchOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
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

        Task[] res = todos.search("Выкатка");

        Task[] expected = {meeting};
        Assertions.assertArrayEquals(expected, res);
    }

    @Test
    public void shouldSearchNoTaskSuitable() {
        SimpleTask simpleTask = new SimpleTask(5, "Купить хлеб");

        String[] subtasks = {"молоко", "яйца", "хлеб"};
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

        Task[] res = todos.search("багет");

        Task[] expected = {};
        Assertions.assertArrayEquals(expected, res);
    }
}