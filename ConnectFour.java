import javax.swing.JFrame;
import java.awt.Color;

import Core.Game;
import Core.Player;
import Gui.GameFrame;

/**
 * <b> Connect Four </b> the "main class" for the "Connect Four" game
 * 
 * @author honzuki
 * @version 1.0.0
 */
public class ConnectFour {
    public static void main(String[] args) {
        // For time being, players will be static red & blue;
        Game game = new Game(new Player(1, "Red Team", Color.RED), new Player(2, "Blue Team", Color.BLUE));
        JFrame gameFrame = new GameFrame(game);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setSize(600, 500);
        gameFrame.setLocationRelativeTo(null); // Sets the frame to the center of the screen
        gameFrame.setVisible(true);
    }
}
