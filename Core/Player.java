package Core;

import java.awt.Color;
import java.io.Serializable;

/**
 * <b>Player</b> represents a player object in the game
 */
public class Player implements Serializable {
    private static final long serialVersionUID = -1282970494060775270L;

    private int id;
    private String name;
    private Color color;

    /**
     * Builds a player object
     * 
     * @param id    the player id; players with the same id will be considered the
     *              same player
     * @param color the player color
     */
    public Player(int id, String name, Color color) {
        if (color == null)
            throw new NullPointerException("color in undefined");
        if (name == null)
            throw new NullPointerException("name in undefined");
        this.id = id;
        this.name = name;
        this.color = color;
    }

    /**
     * @return the player id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the player color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return true if they're the same player, otherwise false
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Player))
            return false;
        return this.id == ((Player) obj).id;
    }

    public String toString() {
        return name;
    }
}
