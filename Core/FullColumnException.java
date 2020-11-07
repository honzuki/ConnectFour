package Core;

/**
 * <b>Full Column Exception</b> this exception is usually raised when you try to
 * select a full row
 */
public class FullColumnException extends Exception {
    private static final long serialVersionUID = -1352044432823404110L;

    public FullColumnException() {

    }

    public FullColumnException(String msg) {
        super(msg);
    }
}
