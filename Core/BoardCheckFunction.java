package Core;

/**
 * <b>Board Check Function</b> This interface is intended to be a base to lambda
 * expression for checking the board; given the current row and column, you need
 * return an array representing the new ones so that the board.check function
 * will know in which direction to check the board.
 */
public interface BoardCheckFunction {
    /**
     * @param row    the current row
     * @param column the current column
     * @return an array that represents the new [row, column]
     */
    public abstract int[] move(int row, int column);
}