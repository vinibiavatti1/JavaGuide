import javax.swing.*;
import java.awt.*;

void main() {
    SwingUtilities.invokeLater(() -> {
        GameOfLife gameOfLife = new GameOfLife(75, 75, GameOfLifeRule.of("235678/378"));
        int offset = 30;
        gameOfLife.setCell(1 + offset, 0 + offset, true);
        gameOfLife.setCell(3 + offset, 1 + offset, true);
        gameOfLife.setCell(0 + offset, 2 + offset, true);
        gameOfLife.setCell(1 + offset, 2 + offset, true);
        gameOfLife.setCell(4 + offset, 2 + offset, true);
        gameOfLife.setCell(5 + offset, 2 + offset, true);
        gameOfLife.setCell(6 + offset, 2 + offset, true);

        GameOfLifeFrame gameOfLifeFrame = new GameOfLifeFrame(gameOfLife);

        GameOfLifeProcessor gameOfLifeProcessor = new GameOfLifeProcessor(gameOfLife, 50);
        new Thread(gameOfLifeProcessor).start();
    });
}

public class GameOfLife {
    private static final int MAX_WIDTH = 999;
    private static final int MAX_HEIGHT = 999;

    private int width;
    private int height;
    private GameOfLifeRule rule;
    private boolean[][] grid;
    private boolean[][] buffer;

    public GameOfLife(int width, int height, GameOfLifeRule rule) {
        Objects.checkIndex(width, MAX_WIDTH + 1);
        Objects.checkIndex(height, MAX_HEIGHT + 1);
        Objects.requireNonNull(rule);
        this.width = width;
        this.height = height;
        this.rule = rule;
        this.grid = new boolean[height][width];
        this.buffer = new boolean[height][width];
    }

    public void setCell(int x, int y, boolean alive) {
        Objects.checkIndex(x, this.width);
        Objects.checkIndex(y, this.height);
        this.grid[y][x] = alive;
    }

    public void reset() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.grid[y][x] = false;
            }
        }
    }

    public void nextGeneration() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                int aliveNeighborQuantity = getAliveNeighborQuantity(x, y);
                GameOfLifeState newState = this.rule.getState(aliveNeighborQuantity);
                switch (newState) {
                    case GameOfLifeState.BORN -> this.buffer[y][x] = true;
                    case GameOfLifeState.KEEP -> this.buffer[y][x] = this.grid[y][x];
                    case GameOfLifeState.DIE -> this.buffer[y][x] = false;
                }
            }
        }
        this.flush();
    }

    public void print() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                IO.print(this.grid[y][x] ? "*" : " ");
            }
            IO.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GameOfLifeRule getRule() {
        return rule;
    }

    private void flush() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.grid[y][x] = this.buffer[y][x];
            }
        }
    }

    private boolean getCell(int x, int y) {
        if (x < 0 || x >= this.width) {
            return false;
        }
        if (y < 0 || y >= this.height) {
            return false;
        }
        return this.grid[y][x];
    }

    private int getAliveNeighborQuantity(int x, int y) {
        int quantity = 0;
        quantity += getCell(x - 1, y - 1) ? 1 : 0;
        quantity += getCell(x - 0, y - 1) ? 1 : 0;
        quantity += getCell(x + 1, y - 1) ? 1 : 0;
        quantity += getCell(x - 1, y - 0) ? 1 : 0;
        quantity += getCell(x + 1, y - 0) ? 1 : 0;
        quantity += getCell(x - 1, y + 1) ? 1 : 0;
        quantity += getCell(x - 0, y + 1) ? 1 : 0;
        quantity += getCell(x + 1, y + 1) ? 1 : 0;
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
        this.setSize(gameOfLife.getWidth() * SCALE, gameOfLife.getHeight() * SCALE);
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
        for (int y = 0; y < this.gameOfLife.getHeight(); y++) {
            for (int x = 0; x < this.gameOfLife.getWidth(); x++) {
                boolean alive = this.gameOfLife.getCell(x, y);
                g.setColor(alive ? Color.BLACK : Color.WHITE);
                g.fillRect(x * GameOfLifeFrame.SCALE, y * GameOfLifeFrame.SCALE, GameOfLifeFrame.SCALE, GameOfLifeFrame.SCALE);
            }
        }
        this.revalidate();
        this.repaint();
    }
}
