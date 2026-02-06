package _09_examples;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TicTacToe {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicTacToeFrame(false);
        });
    }
}

class TicTacToeFrame extends JFrame {
    private final String TITLE = "Tic Tac Toe! (Current Player: %s)";
    private final int BUTTON_QUANTITY = 9;
    private final int[][] VICTORY_SEQUENCES = new int[][] {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
    };

    private TicTacToePlayer currentPlayer = TicTacToePlayer.X;
    private TicTacToeButton[] buttons = new TicTacToeButton[BUTTON_QUANTITY];
    private boolean pvp = false;

    public TicTacToeFrame(boolean pvp) {
        this.setTitle(String.format(TITLE, currentPlayer.getSymbol()));
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3, 5, 5));
        this.buildButtons();
        this.setVisible(true);
        this.pvp = pvp;
    }

    public TicTacToePlayer getCurrentPlayer() {
        return currentPlayer;
    }

    private void reset() {
        currentPlayer = TicTacToePlayer.X;
        this.setTitle(String.format(TITLE, currentPlayer.getSymbol()));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].reset();
        }
    }

    private void buildButtons() {
        for (int i = 0; i < buttons.length; i++) {
            TicTacToeButton button = new TicTacToeButton();
            button.addActionListener(evt -> handleButtonClick(button));
            buttons[i] = button;
            this.add(button);
        }
    }

    private void handleButtonClick(TicTacToeButton button) {
        button.setPlayer(this.currentPlayer);
        if (checkVictory()) {
            processVictory();
            return;
        }
        if (checkTicTacToe()) {
            processTicTacToe();
            return;
        }
        swapCurrentPlayer();
        if (!this.pvp && this.currentPlayer == TicTacToePlayer.O) {
            randomPlay();
        }
    }

    private void swapCurrentPlayer() {
        currentPlayer = currentPlayer == TicTacToePlayer.X ? TicTacToePlayer.O : TicTacToePlayer.X;
        this.setTitle(String.format(TITLE, currentPlayer.getSymbol()));
    }

    private boolean checkVictory() {
        for (int i = 0; i < VICTORY_SEQUENCES.length; i++) {
            int[] sequence = VICTORY_SEQUENCES[i];
            TicTacToePlayer p1 = buttons[sequence[0]].getPlayer();
            TicTacToePlayer p2 = buttons[sequence[1]].getPlayer();
            TicTacToePlayer p3 = buttons[sequence[2]].getPlayer();
            if (p1 == null || p2 == null || p3 == null) {
                continue;
            }
            if (p1 == p2 && p2 == p3) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTicTacToe() {
        for (int i = 0; i < buttons.length; i++) {
            TicTacToeButton button = buttons[i];
            if (button.getPlayer() == null) {
                return false;
            }
        }
        return true;
    }

    private void processVictory() {
        JOptionPane.showMessageDialog(this, "Player " + currentPlayer.getSymbol() + " won!");
        this.processPlayAgain();
    }

    private void processTicTacToe() {
        JOptionPane.showMessageDialog(this, "TIC TAC TOE!");
        this.processPlayAgain();
    }

    private void processPlayAgain() {
        int option = JOptionPane.showConfirmDialog(this, "Play again?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.NO_OPTION) {
            System.exit(0);
            return;
        }
        this.reset();
    }

    private void randomPlay() {
        this.setEnabled(false);
        List<TicTacToeButton> remainingButtons = Arrays.stream(this.buttons)
                .filter(TicTacToeButton::isFree)
                .collect(Collectors.toList());
        Collections.shuffle(remainingButtons);
        remainingButtons.stream().findFirst().ifPresent(x -> x.doClick());
        this.setEnabled(true);
    }
}

class TicTacToeButton extends JButton {
    private TicTacToePlayer player = null;

    public TicTacToeButton() {
        this.reset();
    }

    public void reset() {
        this.setText("-");
        this.player = null;
        this.setEnabled(true);
    }

    public TicTacToePlayer getPlayer() {
        return player;
    }

    public void setPlayer(TicTacToePlayer player) {
        this.player = player;
        this.setText(player.getSymbol());
        this.setEnabled(false);
    }

    public boolean isFree() {
        return this.player != null;
    }
}

enum TicTacToePlayer {
    X("X"),
    O("O");

    private String symbol;

    TicTacToePlayer(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}