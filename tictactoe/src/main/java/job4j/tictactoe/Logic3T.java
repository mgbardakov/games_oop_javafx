package job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;


public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean isWinnerX() {
       return checkWin(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return checkWin(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table).flatMap(Arrays::stream).map(x -> !x.hasMarkO() && !x.hasMarkX())
                     .reduce((x, y) -> x || y).orElse(true);
    }

    /**
     * checks if someone wins
     * @param predicate - X or O
     * @return win/doesn't win
     */
    public boolean checkWin(Predicate<Figure3T> predicate) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (checkLine(i, j, 1, 0, predicate)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1, predicate)) {
                    return true;
                }
                if (checkLine(i, j, 0, 1, predicate)) {
                    return true;
                }
                if (checkLine(i, j, 1, -1, predicate)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * @param x - start x coordinate
     * @param y - start y coordinate
     * @param vx - delta x
     * @param vy - delta y
     * @param pred - X or O
     * @return if there is win
     */
    private boolean checkLine(int x, int y, int vx, int vy, Predicate<Figure3T> pred) {
        final int far_x = x + (2) * vx;
        final int far_y = y + (2) * vy;
        if (!isValidCell(far_x, far_y)) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!pred.test(table[y + i * vy][x + i * vx])) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param x - x coordinate
     * @param y - y coordinate
     * @return valid cell/ non valid cell
     */
    public boolean isValidCell(int x, int y) {
        return (x < table.length && y < table.length)
                && (x >= 0 && y >= 0);
    }
}
