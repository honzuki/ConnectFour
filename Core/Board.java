package Core;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <b>Board</b> represent the board of the "Connect Four" game
 */
public class Board implements Serializable {
    private static final long serialVersionUID = 4675189212619049933L;

    public static final int ROWS = 6, COLUMNS = 7;

    private Disc board[][];
    private int freeSpaces; // The amount of empty cells in the board

    /**
     * Builds a new board for the game
     */
    public Board() {
        board = new Disc[ROWS][COLUMNS];
        freeSpaces = ROWS * COLUMNS;
    }

    /**
     * Insert a disc to the board
     * 
     * @param disc   the disc
     * @param column the column to insert into
     */
    public void addDisc(Disc disc, int column) throws FullColumnException {
        if (column < 0 || column >= COLUMNS)
            throw new IllegalArgumentException("column should be between 0 to " + column);

        // Find the row
        int row = 0;
        for (; row < ROWS && board[row][column] != null; row++)
            ;
        if (row >= ROWS)
            throw new FullColumnException();

        board[row][column] = disc;
        freeSpaces--;
    }

    /**
     * Checks the board with a specific lambda expression for a specific amount of
     * discs owned by the same player
     * 
     * @param lambda         the lambda expression
     * @param requiredAmount the minimum amount
     * @return if exists, the player that meets the requirements, otherwise null
     */
    public Player check(BoardCheckFunction lambda, int requiredAmount, boolean highlight) {
        // The board is arranged from top to bottom
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++)
                if (board[row][column] != null) {
                    // Check for victory
                    Player player = board[row][column].getOwner();
                    ArrayList<Disc> discs = new ArrayList<>();
                    for (int space[] = new int[] { row, column }; inBounds(space[0], space[1])
                            && board[space[0]][space[1]] != null
                            && board[space[0]][space[1]].getOwner() == player; space = lambda.move(space[0], space[1]))
                        discs.add(board[space[0]][space[1]]);
                    if (discs.size() >= requiredAmount) {
                        if (highlight)
                            for (Disc disc : discs)
                                disc.select();
                        return player;
                    }
                }
        }
        return null; // failed
    }

    /**
     * Displays the board using a lambda expression
     * 
     * @param lambda the lambda expression
     */
    public void display(BoardDisplayFunction lambda) {
        for (int row = 0; row < ROWS; row++)
            for (int column = 0; column < COLUMNS; column++)
                if (board[row][column] != null)
                    lambda.display(row, column, board[row][column].getColor());
    }

    /**
     * @return the amount of free spaces in the board
     */
    public int getFreeSpaces() {
        return freeSpaces;
    }

    private boolean inBounds(int row, int column) {
        return !(row < 0 || row >= ROWS || column < 0 || column >= COLUMNS);
    }
}
