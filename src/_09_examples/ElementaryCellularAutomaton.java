import javax.swing.*;
import java.awt.*;

void main() {
    SwingUtilities.invokeLater(() -> {
        ElementaryCellularAutomaton elementaryCellularAutomaton = new ElementaryCellularAutomaton(250, 400);
        elementaryCellularAutomaton.setCell(0, elementaryCellularAutomaton.getColumns() / 2, true);
        elementaryCellularAutomaton.process(ElementaryCellularAutomatonRule.of(30));
        ElementaryCellularAutomatonFrame elementaryCellularAutomatonFrame = new ElementaryCellularAutomatonFrame(elementaryCellularAutomaton);
    });
}

public class ElementaryCellularAutomaton {
    private static final int MAX_ROWS = 999;
    private static final int MAX_COLUMNS = 999;

    private int rows;
    private int columns;
    private boolean[][] grid;

    public ElementaryCellularAutomaton(int rows, int columns) {
        Objects.checkIndex(rows, MAX_ROWS + 1);
        Objects.checkIndex(columns, MAX_COLUMNS + 1);
        this.rows = rows;
        this.columns = columns;
        this.grid = new boolean[rows][columns];
    }

    public void process(ElementaryCellularAutomatonRule rule) {
        Objects.requireNonNull(rule);
        for (int row = 1; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                boolean[] topPixels = this.getTopCells(row, column);
                boolean result = rule.get(topPixels[0], topPixels[1], topPixels[2]);
                this.grid[row][column] = result;
            }
        }
    }

    public void reset() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.grid[row][column] = false;
            }
        }
    }

    public boolean getCell(int row, int column) {
        if (row < 0 || row >= this.rows) {
            return false;
        }
        if (column < 0 || column >= this.columns) {
            return false;
        }
        return this.grid[row][column];
    }

    public void setCell(int row, int column, boolean active) {
        Objects.checkIndex(row, rows);
        Objects.checkIndex(column, columns);
        this.grid[row][column] = active;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    private boolean[] getTopCells(int row, int column) {
        boolean[] topPixels = new boolean[3];
        topPixels[0] = this.getCell(row-1, column-1);
        topPixels[1] = this.getCell(row-1, column);
        topPixels[2] = this.getCell(row-1, column+1);
        return topPixels;
    }

    public void print() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                IO.print(this.grid[row][column] ? "*" : "_");
            }
            IO.println();
        }
    }
}

public static class ElementaryCellularAutomatonRule {
    private Map<String, Boolean> map = new HashMap<>();

    private ElementaryCellularAutomatonRule(int rule) {
        Objects.checkIndex(rule, 256);
        this.map = this.buildMap(toBinaryString(rule));
    }

    public static ElementaryCellularAutomatonRule of(int rule) {
        return new ElementaryCellularAutomatonRule(rule);
    }

    public boolean get(boolean left, boolean middle, boolean right) {
        String key = toBinaryDigit(left) + toBinaryDigit(middle) + toBinaryDigit(right);
        return this.map.get(key);
    }

    private Map<String, Boolean> buildMap(String binaryString) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("000", binaryString.charAt(7) == '1');
        map.put("001", binaryString.charAt(6) == '1');
        map.put("010", binaryString.charAt(5) == '1');
        map.put("011", binaryString.charAt(4) == '1');
        map.put("100", binaryString.charAt(3) == '1');
        map.put("101", binaryString.charAt(2) == '1');
        map.put("110", binaryString.charAt(1) == '1');
        map.put("111", binaryString.charAt(0) == '1');
        return map;
    }

    private String toBinaryString(int rule) {
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(rule));
        while (binaryString.length() < 8) {
            binaryString.insert(0, 0);
        }
        return binaryString.toString();
    }

    private String toBinaryDigit(boolean active) {
        return active ? "1" : "0";
    }
}

public class ElementaryCellularAutomatonFrame extends JFrame {
    private static final int SCALE = 2;

    private ElementaryCellularAutomatonCanvas canvas;

    public ElementaryCellularAutomatonFrame(ElementaryCellularAutomaton elementaryCellularAutomaton) {
        this.canvas = new ElementaryCellularAutomatonCanvas(elementaryCellularAutomaton);
        this.setTitle("Elementary Cellular Automaton");
        this.setSize(elementaryCellularAutomaton.getColumns() * SCALE, elementaryCellularAutomaton.getRows() * SCALE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(this.canvas);
        this.setVisible(true);
    }
}

public class ElementaryCellularAutomatonCanvas extends JPanel {
    private ElementaryCellularAutomaton elementaryCellularAutomaton;

    public ElementaryCellularAutomatonCanvas(ElementaryCellularAutomaton elementaryCellularAutomaton) {
        this.elementaryCellularAutomaton = elementaryCellularAutomaton;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int scale = ElementaryCellularAutomatonFrame.SCALE;
        for (int row = 0; row < this.elementaryCellularAutomaton.getRows(); row++) {
            for (int column = 0; column < this.elementaryCellularAutomaton.getColumns(); column++) {
                g.setColor(this.elementaryCellularAutomaton.getCell(row, column) ? Color.BLACK : Color.WHITE);
                g.fillRect(column*scale, row*scale, scale, scale);
            }
        }
    }
}