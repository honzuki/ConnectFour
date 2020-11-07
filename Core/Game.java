package Core;

import java.io.Serializable;

/**
 * <b>Game</b> the manager class for the "Connect Four" game
 */
public class Game implements Serializable {
    private static final long serialVersionUID = -8968395661542389368L;
    public static final int AMOUNT_OF_POINTS_TO_WIN = 4;

    private Board board;
    private Player players[];
    private Player winner;
    private int turn; // the next player to play

    /**
     * Builds a new game object, you should construct a new GameCore instance every
     * time you want to reset the game
     * <p>
     * This game requires two players to play, regardless to the order of player1 &
     * player2, the first player to play will be randomly selected
     * 
     * @param player1
     * @param player2
     */
    public Game(Player player1, Player player2) {
        if (player1 == null || player2 == null)
            throw new NullPointerException("You should provide 2 players");
        board = new Board();
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        turn = (int) (Math.random() * 2); // Randomly select the first player to play
    }

    /**
     * @return the player whose turn to play
     */
    public Player getCurrentPlayer() {
        return players[turn];
    }

    /**
     * Select a column for the current player
     * 
     * @param column the column
     * @return true if the player won, otherwise false
     */
    public boolean play(int column) throws FullColumnException, GameOverException {
        if (board.getFreeSpaces() <= 0 || winner != null)
            throw new GameOverException();
        try {
            board.addDisc(new Disc(players[turn]), column);
        } catch (FullColumnException e) {
            throw new FullColumnException("column should be between 0 to " + column);
        }

        turn = Math.abs(turn - 1); // change the turn
        winner = checkBoard();
        return winner != null;
    }

    /**
     * @return the players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * @return if exists, the winner of the game, otherwise null
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * Displays the game board
     * 
     * @param lambda the lambda expression
     */
    public void displayBoard(BoardDisplayFunction lambda) {
        // Rotate the board
        board.display((row, column, color) -> lambda.display(Board.ROWS - row - 1, column, color));
    }

    /**
     * Resets the game
     */
    public void reset() {
        board = new Board();
        turn = (int) (Math.random() * 2); // Randomly select the first player to play
        winner = null;
    }

    // Checks if anyone has won
    private Player checkBoard() {
        Player winner;
        winner = board.check((r, c) -> new int[] { r + 1, c + 1 }, AMOUNT_OF_POINTS_TO_WIN, true); // Diagonal
        winner = winner == null ? board.check((r, c) -> new int[] { r + 1, c }, AMOUNT_OF_POINTS_TO_WIN, true) : winner; // Row
        winner = winner == null ? board.check((r, c) -> new int[] { r, c + 1 }, AMOUNT_OF_POINTS_TO_WIN, true) : winner; // Column
        return winner;
    }
}