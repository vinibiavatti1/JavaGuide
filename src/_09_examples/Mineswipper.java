import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

void main() {
    SwingUtilities.invokeLater(() -> {
        new MinesweeperFrame(10, 10, 5);
    });
}

public class MinesweeperFrame extends JFrame {
    private final String TITLE = "Minesweeper (Mines: %s / Flags: %s)";
    private final int MAX_WIDTH = 10;
    private final int MAX_HEIGHT = 10;
    private final int BUTTON_WIDTH = 45;
    private final int BUTTON_HEIGHT = 45;

    private int width;
    private int height;
    private int minesQuantity;
    private int visitedTilesQuantity = 0;
    private int flagsQuantity = 0;
    private int tilesQuantity = 0;
    private MinesweeperTile[][] field;
    private List<MinesweeperTile> tiles = new ArrayList<>();

    public MinesweeperFrame(int width, int height, int minesQuantity) {
        validateProperties(width, height, minesQuantity);
        this.width = width;
        this.height = height;
        this.minesQuantity = minesQuantity;
        this.tilesQuantity = width * height;
        this.setSize(this.width * this.BUTTON_WIDTH, this.height * this.BUTTON_WIDTH);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(width, height));
        this.createField();
        this.reset();
        this.refreshTitle();
        this.setVisible(true);
    }

    private void validateProperties(int width, int height, int minesQuantity) {
        Objects.checkIndex(width, MAX_WIDTH + 1);
        Objects.checkIndex(height, MAX_HEIGHT + 1);
        Objects.checkIndex(minesQuantity, width * height);
    }

    private void refreshTitle() {
        this.setTitle(String.format(TITLE, this.minesQuantity, this.flagsQuantity));
    }

    private void createField() {
        this.field = new MinesweeperTile[this.width][this.height];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                MinesweeperTile tile = new MinesweeperTile(x, y);
                tile.addMouseListener(new ButtonMouseListener());
                this.add(tile);
                this.tiles.add(tile);
                this.field[x][y] = tile;
            }
        }
    }

    private void reset() {
        this.flagsQuantity = 0;
        this.visitedTilesQuantity = 0;
        tiles.stream().forEach(MinesweeperTile::reset);
        Collections.shuffle(tiles);
        tiles.stream().limit(this.minesQuantity).forEach(x -> x.setMine(true));
        tiles.stream().skip(this.minesQuantity).forEach(this::computeTileValue);
    }

    private void computeTileValue(MinesweeperTile tile) {
        int x = tile.getFieldX();
        int y = tile.getFieldY();
        List<MinesweeperTile> neighbors = getNeighbors(x, y);
        int neighborsMinesCount = countMineTiles(neighbors);
        tile.setValue(neighborsMinesCount);
    }

    private List<MinesweeperTile> getNeighbors(int x, int y) {
        List<MinesweeperTile> neighbors = new ArrayList<>();
        neighbors.add(getTile(x - 1, y - 1));
        neighbors.add(getTile(x - 0, y - 1));
        neighbors.add(getTile(x + 1, y - 1));
        neighbors.add(getTile(x - 1, y - 0));
        neighbors.add(getTile(x + 1, y - 0));
        neighbors.add(getTile(x - 1, y + 1));
        neighbors.add(getTile(x - 0, y + 1));
        neighbors.add(getTile(x + 1, y + 1));
        return neighbors.stream().filter(tile -> tile != null).toList();
    }

    private MinesweeperTile getTile(int x, int y) {
        if (x < 0 || x >= this.width) {
            return null;
        }
        if (y < 0 || y >= this.height) {
            return null;
        }
        return this.field[x][y];
    }

    private int countMineTiles(List<MinesweeperTile> tiles) {
        return (int) tiles.stream().filter(MinesweeperTile::isMine).count();
    }

    private boolean checkVictory() {
        return this.visitedTilesQuantity == (this.tilesQuantity - this.minesQuantity);
    }

    private void processLeftClick(MinesweeperTile tile) {
        if (tile.isVisited()) {
            return;
        }
        tile.visit();
        if (tile.isMine()) {
            JOptionPane.showMessageDialog(this, "BOOM!");
            this.reset();
            return;
        }
        if (tile.getValue() == 0) {
            getNeighbors(tile.getFieldX(), tile.getFieldY()).stream().forEach(x -> processLeftClick(x));
        }
        this.visitedTilesQuantity++;
        if (checkVictory()) {
            JOptionPane.showMessageDialog(this, "Victory!!!");
            this.reset();
        }
    }

    private void processRightClick(MinesweeperTile button) {
        if (button.isVisited()) {
            return;
        }
        if (button.getMark() == MinesweeperButtonMark.FLAG) {
            this.flagsQuantity--;
        } else if(button.getMark() == MinesweeperButtonMark.NONE) {
            this.flagsQuantity++;
        }
        button.toggleMark();
        this.refreshTitle();
    }

    private class ButtonMouseListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            MinesweeperTile tile = (MinesweeperTile) e.getComponent();
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (tile.getMark() != MinesweeperButtonMark.NONE) {
                    return;
                }
                processLeftClick(tile);
            } else {
                processRightClick(tile);
            }
        }
    }
}

public class MinesweeperTile extends JButton {
    private static final float FONT_SIZE = 18f;
    private static final int FONT_STYLE = Font.BOLD;
    private static final String UNKNOWN_TEXT = "?";
    private static final ImageIcon FLAG_ICON;
    private static final ImageIcon BOMB_ICON;
    private static final Color[] COLORS = new Color[] {
            new Color(000, 000, 000),
            new Color(000, 000, 255),
            new Color(000, 128, 000),
            new Color(255, 000, 000),
            new Color(000, 000, 128),
            new Color(128, 000, 000),
            new Color(000, 128, 128),
            new Color(000, 000, 000),
            new Color(128, 128, 128),
    };

    static {
        FLAG_ICON = new ImageIcon(MinesweeperTile.class.getResource("/gui/flag_green.png"));
        BOMB_ICON = new ImageIcon(MinesweeperTile.class.getResource("/gui/bomb.png"));
    }

    private int x;
    private int y;
    private MinesweeperButtonMark mark = MinesweeperButtonMark.NONE;
    private boolean visited = false;
    private int value = 0;
    private boolean mine;

    public MinesweeperTile(int x, int y) {
        this.x = x;
        this.y = y;
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setFont(this.getFont().deriveFont(FONT_STYLE, FONT_SIZE));
        this.setUI(new MetalButtonUI() {
            protected Color getDisabledTextColor() {
                return COLORS[getValue()];
            }
        });
    }

    public void reset() {
        this.setValue(0);
        this.setMine(false);
        this.setText("");
        this.setBackground(null);
        this.setIcon(null);
        this.setVisited(false);
        this.mark = MinesweeperButtonMark.NONE;
        this.setEnabled(true);
    }

    public int getFieldX() {
        return x;
    }

    public int getFieldY() {
        return y;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isMine() {
        return mine;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public MinesweeperButtonMark getMark() {
        return mark;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void visit() {
        this.mark = MinesweeperButtonMark.NONE;
        this.setIcon(null);
        if (this.isMine()) {
            this.setIcon(this.BOMB_ICON);
            this.setBackground(Color.RED);
            return;
        }
        if (this.getValue() != 0) {
            this.setText(String.valueOf(this.getValue()));
        }
        this.setEnabled(false);
        this.setVisited(true);
    }

    public void toggleMark() {
        switch (this.mark) {
            case NONE:
                this.mark = MinesweeperButtonMark.FLAG;
                this.setText("");
                this.setIcon(FLAG_ICON);
                break;
            case FLAG:
                this.mark = MinesweeperButtonMark.UNKNOWN;
                this.setIcon(null);
                this.setText(UNKNOWN_TEXT);
                break;
            case UNKNOWN:
                this.mark = MinesweeperButtonMark.NONE;
                this.setText("");
                break;
        }
        this.repaint();
        this.revalidate();
    }
}

public enum MinesweeperButtonMark {
    NONE,
    FLAG,
    UNKNOWN
}
