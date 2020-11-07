package Gui;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Color;

/**
 * <b>Board Panel</b> the board panel for the "Connect Four" game
 */
public class BoardPanel extends JPanel {
    private static final long serialVersionUID = -8080032447282162359L;
    private JPanel board[][];
    private Core.Game game;

    public BoardPanel(Core.Game game) {
        setLayout(new GridLayout(Core.Board.ROWS, Core.Board.COLUMNS));

        // Adds every space on the board as a panel
        board = new JPanel[Core.Board.ROWS][Core.Board.COLUMNS];
        for (int r = 0; r < board.length; r++)
            for (int c = 0; c < board[r].length; c++) {
                add(board[r][c] = new JPanel());
                board[r][c].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                board[r][c].setBackground(new Color(0, 0, 0, 0)); // The background hides the circles
                board[r][c].setVisible(true);
            }

        this.game = game;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.displayBoard((row, column, color) -> {
            g.setColor(color);
            // draws a circle in this panel
            g.fillOval(board[row][column].getX(), board[row][column].getY(), board[row][column].getWidth(),
                    board[row][column].getHeight());
            g.setColor(Color.GRAY);
            g.drawOval(board[row][column].getX(), board[row][column].getY(), board[row][column].getWidth(),
                    board[row][column].getHeight());
        });

    }
}
