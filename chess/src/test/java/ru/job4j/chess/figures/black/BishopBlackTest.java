package ru.job4j.chess.figures.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        Figure bishop = new BishopBlack(Cell.A1);
        assertThat(bishop.position(), is(Cell.A1));
    }

    @Test
    public void copyTest() {
        Figure bishop = new BishopBlack(Cell.A1);
        bishop = bishop.copy(Cell.C3);
        assertThat(bishop.position(), is(Cell.C3));
    }

    @Test
    public void wayTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(bishop.position(), Cell.G5);
        assertThat(way, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = IllegalStateException.class)
    public void wayExceptionTest() {
        Figure bishop = new BishopBlack(Cell.C1);
        bishop.way(bishop.position(), Cell.C2);
    }

}
