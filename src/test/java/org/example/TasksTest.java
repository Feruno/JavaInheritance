package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {
    @Test
    public void matchesTrueSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean actual = simpleTask.matches("Позвонить родителям");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesFalseSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean actual = simpleTask.matches("не то");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesEmptySimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();
        todos.add(simpleTask);

        boolean actual = simpleTask.matches("  ");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesTrueEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        boolean actual = epic.matches("Молоко");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesFalseEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        boolean actual = epic.matches("иное");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesEmptyEpic() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);

        boolean actual = epic.matches("  ");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesTrueMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesTrueSecondParamMeeting() {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean actual = meeting.matches("Приложение НетоБанка");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesFalseMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean actual = meeting.matches("иное");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }

    @Test
    public void matchesEmptyMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();
        todos.add(meeting);

        boolean actual = meeting.matches("  ");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);

        System.out.println(actual);

    }


}