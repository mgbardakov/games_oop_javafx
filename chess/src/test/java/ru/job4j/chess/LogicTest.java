package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void moveWhenNoFigureTest() {
        boolean moved = new Logic().move(Cell.E1, Cell.A2);
        assertThat(moved, is(false));
    }

    @Test
    public void moveWhenNotBlockedTest() {
        Logic testLogic = new Logic();
        testLogic.add(new BishopBlack(Cell.C1));
        boolean moved = testLogic.move(Cell.C1, Cell.E3);
        assertThat(moved, is(true));
    }

    @Test
    public void moveWhenBlockedTest() {
        Logic testLogic = new Logic();
        testLogic.add(new BishopBlack(Cell.C1));
        testLogic.add(new BishopBlack(Cell.D2));
        boolean moved = testLogic.move(Cell.C1, Cell.E3);
        assertThat(moved, is(false));
    }
}
