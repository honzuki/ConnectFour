package Core;

import java.awt.Color;

/**
 * <b>Board Display Function</b> This interface is intended to be a base to
 * lambda expression for displaying the board
 */
public interface BoardDisplayFunction {
    /**
     * This function will be called for any full cell
     * 
     * @param row    the row of the cell
     * @param column the column of the cell
     * @param color  the color of the cell
     */
    public abstract void display(int row, int column, Color color);
}