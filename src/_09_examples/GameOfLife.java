import javax.swing.*;
import java.awt.*;

void main() {
    SwingUtilities.invokeLater(() -> {
        GameOfLifeRule rule = GameOfLifeRule.of(GameOfLifeRuleVariation.GOL.getNotation());
        GameOfLife gameOfLife = new GameOfLife(75, 100, rule);
        int offsetRows = 35;
        int offsetColumns = 60;
        gameOfLife.setCell(0 + offsetRows, 1 + offsetColumns, true);
        gameOfLife.setCell(1 + offsetRows, 3 + offsetColumns, true);
        gameOfLife.setCell(2 + offsetRows, 0 + offsetColumns, true);
        gameOfLife.setCell(2 + offsetRows, 1 + offsetColumns, true);
        gameOfLife.setCell(2 + offsetRows, 4 + offsetColumns, true);
        gameOfLife.setCell(2 + offsetRows, 5 + offsetColumns, true);
        gameOfLife.setCell(2 + offsetRows, 6 + offsetColumns, true);

        GameOfLifeFrame gameOfLifeFrame = new GameOfLifeFrame(gameOfLife);

        GameOfLifeProcessor gameOfLifeProcessor = new GameOfLifeProcessor(gameOfLife, 50);
        new Thread(gameOfLifeProcessor).start();
    });
}

public class GameOfLife {
    private static final int MAX_WIDTH = 999;
    private static final int MAX_HEIGHT = 999;

    private int rows;
    private int columns;
    private GameOfLifeRule rule;
    private boolean[][] grid;
    private boolean[][] buffer;

    public GameOfLife(int rows, int columns, GameOfLifeRule rule) {
        Objects.checkIndex(rows, MAX_WIDTH + 1);
        Objects.checkIndex(columns, MAX_HEIGHT + 1);
        Objects.requireNonNull(rule);
        this.rows = rows;
        this.columns = columns;
        this.rule = rule;
        this.grid = new boolean[rows][columns];
        this.buffer = new boolean[rows][columns];
    }

    public void setCell(int row, int column, boolean alive) {
        Objects.checkIndex(row, this.rows);
        Objects.checkIndex(column, this.columns);
        this.grid[row][column] = alive;
    }

    public void reset() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.grid[row][column] = false;
            }
        }
    }

    public void nextGeneration() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                int aliveNeighborQuantity = getAliveNeighborQuantity(row, column);
                GameOfLifeState newState = this.rule.getState(aliveNeighborQuantity);
                switch (newState) {
                    case GameOfLifeState.BORN -> this.buffer[row][column] = true;
                    case GameOfLifeState.KEEP -> this.buffer[row][column] = this.grid[row][column];
                    case GameOfLifeState.DIE -> this.buffer[row][column] = false;
                }
            }
        }
        this.flush();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public GameOfLifeRule getRule() {
        return rule;
    }

    private void flush() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.grid[row][column] = this.buffer[row][column];
            }
        }
    }

    private boolean getCell(int row, int column) {
        if (row < 0 || row >= this.rows) {
            return false;
        }
        if (column < 0 || column >= this.columns) {
            return false;
        }
        return this.grid[row][column];
    }

    private int getAliveNeighborQuantity(int row, int column) {
        int quantity = 0;
        quantity += getCell(row - 1, column - 1) ? 1 : 0;
        quantity += getCell(row - 1, column - 0) ? 1 : 0;
        quantity += getCell(row - 1, column + 1) ? 1 : 0;
        quantity += getCell(row - 0, column - 1) ? 1 : 0;
        quantity += getCell(row - 0, column + 1) ? 1 : 0;
        quantity += getCell(row + 1, column - 1) ? 1 : 0;
        quantity += getCell(row + 1, column - 0) ? 1 : 0;
        quantity += getCell(row + 1, column + 1) ? 1 : 0;
        return quantity;
    }
}

public static class GameOfLifeRule {
    private static final String DELIMITER = "/";

    private String keep;
    private String born;

    private GameOfLifeRule(String keep, String born) {
        this.keep = keep;
        this.born = born;
    }

    public static GameOfLifeRule of(String notation) {
        Objects.requireNonNull(notation);
        String[] parts = notation.split(DELIMITER);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid notation: " + notation);
        }
        return new GameOfLifeRule(parts[0], parts[1]);
    }

    public GameOfLifeState getState(int aliveNeighborQuantity) {
        String aliveNeighborQuantityStr = String.valueOf(aliveNeighborQuantity);
        if (born.contains(aliveNeighborQuantityStr)) {
            return GameOfLifeState.BORN;
        }
        if (keep.contains(aliveNeighborQuantityStr)) {
            return GameOfLifeState.KEEP;
        }
        return GameOfLifeState.DIE;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", this.keep, this.born);
    }
}

public class GameOfLifeProcessor implements Runnable {
    private GameOfLife gameOfLife;
    private long delayMs;
    private volatile boolean running = true;

    public GameOfLifeProcessor(GameOfLife gameOfLife, long delayMs) {
        this.gameOfLife = gameOfLife;
        this.delayMs = delayMs;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (this.running) {
            try {
                Thread.sleep(this.delayMs);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.gameOfLife.nextGeneration();
        }
    }
}

public enum GameOfLifeState {
    BORN,
    KEEP,
    DIE
}

public class GameOfLifeFrame extends JFrame {
    private static final int SCALE = 8;
    private GameOfLife gameOfLife;

    public GameOfLifeFrame(GameOfLife gameOfLife) {
        Objects.requireNonNull(gameOfLife);
        this.gameOfLife = gameOfLife;
        this.setTitle(String.format("Game of Life (%s)", this.gameOfLife.rule));
        this.setSize(gameOfLife.getColumns() * SCALE, gameOfLife.getRows() * SCALE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new GameOfLifePanel(gameOfLife));
        this.setVisible(true);
    }
}

public class GameOfLifePanel extends JPanel {
    private GameOfLife gameOfLife;

    public GameOfLifePanel(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < this.gameOfLife.getRows(); row++) {
            for (int column = 0; column < this.gameOfLife.getColumns(); column++) {
                boolean alive = this.gameOfLife.getCell(row, column);
                g.setColor(alive ? Color.BLACK : Color.WHITE);
                g.fillRect(column * GameOfLifeFrame.SCALE, row * GameOfLifeFrame.SCALE, GameOfLifeFrame.SCALE, GameOfLifeFrame.SCALE);
            }
        }
        this.revalidate();
        this.repaint();
    }
}

public enum GameOfLifeRuleVariation {
    GOL("Game of Life", "23/3"),
    HIGH_LIFE("High Life", "23/36"),
    ASSIMILATION("Assimilation", "4567/345"),
    TWO_X_TWO("2×2", "125/36"),
    DAY_AND_NIGHT("Day and Night", "34578/3678"),
    AMOEBA("Amoeba", "1358/357"),
    MOVE("Move", "245/368"),
    PSEUDO_LIFE("Pseudo Life", "238/357"),
    DI_AMOEBA("Di Amoeba", "5678/35678"),
    THREE_FOUR("34", "34/34"),
    LONG_LIFE("Long Life", "5/345"),
    STAINS("Stains", "235678/3678"),
    SEEDS("Seeds", "/2"),
    MAZE("Maze", "12345/3"),
    COAGULATION("Coagulation", "235678/378"),
    WALLED_CITIES("Walled Cities", "2345/45678"),
    GNARL("Gnarl", "1/1"),
    REPLICATOR("Replicator", "1357/1357"),
    MYSTERY("Mystery", "05678/3458");

    private String name;
    private String notation;

    GameOfLifeRuleVariation(String name, String notation) {
        this.name = name;
        this.notation = notation;
    }

    public String getName() {
        return name;
    }

    public String getNotation() {
        return notation;
    }
}