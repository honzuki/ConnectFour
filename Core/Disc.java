package Core;

import java.awt.Color;
import java.io.Serializable;

/**
 * <b>Disc</b> represents a disc in the board
 */
public class Disc implements Serializable {
    private static final long serialVersionUID = 8163571881074985849L;
    public static final int HIGHLIGHT_AMOUNT = 10;

    private Player owner;
    private Color color;

    /**
     * Build a new disc object
     * 
     * @param owner the owner of the disc
     */
    public Disc(Player owner) {
        if (owner == null)
            throw new NullPointerException("Disc owner is undefined");
        this.owner = owner;
        this.color = owner.getColor().darker();
    }

    /**
     * Highlights the disc
     */
    public void select() {
        color = owner.getColor().brighter();
    }

    /**
     * Removes the highlight from the disc
     */
    public void deselect() {
        color = owner.getColor().darker();
    }

    /**
     * @return the owner of the disc
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * @return
     */

    public Color getColor() {
        return color;
    }
}
