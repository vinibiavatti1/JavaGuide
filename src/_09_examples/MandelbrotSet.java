import javax.swing.*;
import java.awt.*;

void main() {
    SwingUtilities.invokeLater(() -> {
        MandelbrotSet mandelbrotSet = new MandelbrotSet(600, 800);
        mandelbrotSet.process(MandelbrotSet.VIEWPORT_MIN, MandelbrotSet.VIEWPORT_MAX, 50);
        MandelbrotSetFrame mandelbrotSetFrame = new MandelbrotSetFrame(mandelbrotSet);
    });
}

public class MandelbrotSet {
    public static final Complex VIEWPORT_MIN = Complex.of(-2.0, -1.2);
    public static final Complex VIEWPORT_MAX = Complex.of(0.5, 1.2);

    private static final int MAX_ROWS = 9999;
    private static final int MAX_COLUMNS = 9999;

    private int rows;
    private int columns;
    private int[][] grid;
    private int maxIterations;

    public MandelbrotSet(int rows, int columns) {
        Objects.checkIndex(rows, MAX_ROWS + 1);
        Objects.checkIndex(columns, MAX_COLUMNS + 1);
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
    }

    public void reset() {
        for (int row = 0; row < this.rows; row++) {
            for (int column = 0; column < this.columns; column++) {
                this.grid[row][column] = 0;
            }
        }
    }

    public void process(Complex from, Complex to, int maxIterations) {
        this.maxIterations = maxIterations;
        double realRange = to.getReal() - from.getReal();
        double imagRange = to.getImag() - from.getImag();
        double realStep = realRange / this.columns;
        double imagStep = imagRange / this.rows;

        double imag = to.getImag();
        for (int row = 0; row < this.rows; row++) {
            double real = from.getReal();
            for (int column = 0; column < this.columns; column++) {
                Complex complex = Complex.of(real, imag);
                int value = computeComplex(complex, maxIterations);
                this.grid[row][column] = value;
                real += realStep;
            }
            imag -= imagStep;
        }
    }

    public double getPixelValue(int row, int column) {
        Objects.checkIndex(row, this.rows);
        Objects.checkIndex(column, this.columns);
        return this.grid[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    private int computeComplex(Complex complex, int maxIterations) {
        Complex z = Complex.of(0, 0);
        int iteration = 0;
        while(iteration < maxIterations) {
            z = z.mul(z).add(complex); // Formula: z^2 + c
            double distance = Math.sqrt((z.getReal() * z.getReal()) + (z.getImag() * z.getImag()));
            if (distance > 2) {
                break;
            }
            iteration++;
        }
        return iteration;
    }
}

public static class Complex {
    private double real;
    private double imag;

    public static Complex of(double real, double imag) {
        return new Complex(real, imag);
    }

    private Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex complex) {
        return Complex.of(this.real + complex.getReal(), this.imag + complex.getImag());
    }

    public Complex mul(Complex complex) {
        double a = this.real;
        double b = this.imag;
        double c = complex.getReal();
        double d = complex.getImag();
        double real = (a * c) - (b * d);
        double imag = (a * d) + (b * c);
        return Complex.of(real, imag);
    }

    @Override
    public String toString() {
        return String.format("%f + %fi", this.real, this.imag);
    }
}

public class MandelbrotSetFrame extends JFrame {
    private MandelbrotSet mandelbrotSet;

    public MandelbrotSetFrame(MandelbrotSet mandelbrotSet) {
        this.mandelbrotSet = mandelbrotSet;
        this.setTitle("Mandelbrot Set");
        this.setSize(mandelbrotSet.getColumns(), mandelbrotSet.getRows());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(new MandelbrotSetPanel(mandelbrotSet));
        this.setVisible(true);
    }
}

public class MandelbrotSetPanel extends JPanel {
    private MandelbrotSet mandelbrotSet;

    public MandelbrotSetPanel(MandelbrotSet mandelbrotSet) {
        this.mandelbrotSet = mandelbrotSet;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < this.mandelbrotSet.getRows(); row++) {
            for (int column = 0; column < this.mandelbrotSet.getColumns(); column++) {
                double value = this.mandelbrotSet.getPixelValue(row, column);
                g.setColor(value == this.mandelbrotSet.getMaxIterations() ? Color.BLACK : Color.WHITE);
                g.fillRect(column, row, 1, 1);
            }
        }
    }
}