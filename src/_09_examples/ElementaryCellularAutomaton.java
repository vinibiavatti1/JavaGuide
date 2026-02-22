import javax.swing.*;
import java.awt.*;

void main() {
    SwingUtilities.invokeLater(() -> {
        ElementaryCellularAutomaton elementaryCellularAutomaton = new ElementaryCellularAutomaton(400, 250);
        ElementaryCellularAutomatonFrame elementaryCellularAutomatonFrame = new ElementaryCellularAutomatonFrame(elementaryCellularAutomaton);
        elementaryCellularAutomaton.process(30);
    });
}

public class ElementaryCellularAutomaton {
    private static final int MAX_WIDTH = 999;
    private static final int MAX_HEIGHT = 999;

    private int width;
    private int height;
    private boolean[][] grid;

    public ElementaryCellularAutomaton(int width, int height) {
        Objects.checkIndex(width, MAX_WIDTH);
        Objects.checkIndex(height, MAX_HEIGHT);
        this.width = width;
        this.height = height;
        this.grid = new boolean[height][width];
    }

    public void process(int decimalRule) {
        this.reset();
        this.setCell(Math.round(this.width / 2), 0, true);
        ElementaryCellularAutomatonRule rule = new ElementaryCellularAutomatonRule(decimalRule);
        for (int y = 1; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                boolean[] topPixels = this.getTopCells(x, y);
                boolean result = rule.get(topPixels[0], topPixels[1], topPixels[2]);
                this.grid[y][x] = result;
            }
        }
    }

    public void reset() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.grid[y][x] = false;
            }
        }
    }

    public boolean getCell(int x, int y) {
        if (x < 0 || x >= this.width) {
            return false;
        }
        if (y < 0 || y >= this.height) {
            return false;
        }
        return this.grid[y][x];
    }

    public void setCell(int x, int y, boolean active) {
        Objects.checkIndex(x, width);
        Objects.checkIndex(y, height);
        this.grid[y][x] = active;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private boolean[] getTopCells(int x, int y) {
        boolean[] topPixels = new boolean[3];
        topPixels[0] = this.getCell(x-1, y-1);
        topPixels[1] = this.getCell(x+0, y-1);
        topPixels[2] = this.getCell(x+1, y-1);
        return topPixels;
    }
}

public class ElementaryCellularAutomatonRule {
    private Map<String, Boolean> map = new HashMap<>();

    public ElementaryCellularAutomatonRule(int rule) {
        this.map = this.buildMap(toBinaryString(rule));
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
        for (int i = binaryString.length(); i < 8; i++) {
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
        this.setSize(elementaryCellularAutomaton.getWidth() * SCALE, elementaryCellularAutomaton.getHeight() * SCALE);
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
        super.paintComponents(g);
        int scale = ElementaryCellularAutomatonFrame.SCALE;
        for (int y = 0; y < this.elementaryCellularAutomaton.getHeight(); y++) {
            for (int x = 0; x < this.elementaryCellularAutomaton.getWidth(); x++) {
                if (this.elementaryCellularAutomaton.getCell(x, y)) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }

                g.drawRect(x*scale, y*scale, 1, 1);
            }
        }
    }
}