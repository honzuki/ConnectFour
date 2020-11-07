package Gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Core.FullColumnException;
import Core.GameOverException;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <b>Controls Panel</b> the controls panel for the "Connect Four" game
 */
public class ControlsPanel extends JPanel {
    private static final long serialVersionUID = -8469132797040814022L;

    private JFrame masterFrame;
    private JButton gameButtons[], clearButton;
    private Core.Game game;

    public ControlsPanel(Core.Game game, JFrame masterFrame) {
        setLayout(new BorderLayout());
        ButtonHandler bh = new ButtonHandler();

        // The game buttons
        JPanel gameButtonsPanel = new JPanel();
        gameButtonsPanel.setLayout(new GridLayout());
        gameButtons = new JButton[Core.Board.COLUMNS];
        for (int i = 0; i < gameButtons.length; i++) {
            gameButtons[i] = new JButton("" + (i + 1));
            gameButtons[i].addActionListener(bh);
            gameButtons[i].setForeground(Color.WHITE);
            gameButtons[i].setBackground(game.getCurrentPlayer().getColor().darker());
            gameButtonsPanel.add(gameButtons[i]);
        }
        add(gameButtonsPanel, BorderLayout.CENTER);

        // The clear button
        JPanel p = new JPanel();
        clearButton = new JButton("clear");
        clearButton.addActionListener(bh);
        p.add(clearButton);
        add(p, BorderLayout.SOUTH);

        this.game = game;
        this.masterFrame = masterFrame;
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == clearButton) {
                game.reset();
                for (JButton button : gameButtons) {
                    button.setEnabled(true);
                    button.setBackground(game.getCurrentPlayer().getColor().darker());
                }
                masterFrame.repaint();
            } else
                for (int bId = 0; bId < gameButtons.length; bId++)
                    if (event.getSource() == gameButtons[bId]) {
                        try {
                            boolean gameOver = game.play(bId);
                            masterFrame.repaint();
                            if (gameOver) // There's a winner
                                throw new GameOverException();
                            else
                                for (JButton button : gameButtons)
                                    button.setBackground(game.getCurrentPlayer().getColor().darker());

                        } catch (FullColumnException e) {
                            gameButtons[bId].setEnabled(false);
                        } catch (GameOverException e) {
                            for (JButton button : gameButtons)
                                button.setEnabled(false);
                            JOptionPane.showMessageDialog(masterFrame, "Game is Over!"
                                    + (game.getWinner() == null ? "" : ("\nThe WINNER is: " + game.getWinner())),
                                    "Connect Four", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
        }
    }
}
