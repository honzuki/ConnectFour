package Core;

/**
 * <b>Game Over Exception</b> this exception is usually raised when you try to
 * play while the game is over
 */
public class GameOverException extends Exception {
    private static final long serialVersionUID = -1352044432823404110L;

    public GameOverException() {

    }

    public GameOverException(String msg) {
        super(msg);
    }
}
