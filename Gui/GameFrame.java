package Gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * <b>Game Frame</b> the main frame of the "Connect Four" game
 */
public class GameFrame extends JFrame {
    private static final long serialVersionUID = -2489516805904380125L;

    public GameFrame(Core.Game game) {
        setLayout(new BorderLayout());
        add(new BoardPanel(game), BorderLayout.CENTER);
        // The ControlsPanel needs a way to repaint the BoardPanel
        add(new ControlsPanel(game, this), BorderLayout.SOUTH);
    }
}
