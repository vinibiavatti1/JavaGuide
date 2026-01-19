/*
 * Grid Layout
 * - This section explains the "GridLayout" layout manager in Java, which arranges components in a rectangular grid of
 *   rows and columns.
 *
 * Overview
 * - The "GridLayout" class is part of the java.awt package.
 * - It divides the container into equal-sized cells, placing one component per cell.
 * - All cells in the grid have the same width and height, so components are uniformly sized.
 *
 * Key Characteristics
 * - Components are added in row-major order, filling each row from left to right before moving to the next.
 * - Rows and columns are specified when creating the GridLayout, but either can be set to zero to adjust dynamically.
 * - Supports horizontal and vertical gaps between cells via constructor parameters.
 * - Components are resized automatically to fill the cell; alignment settings are ignored.
 *
 * Constructor Options
 * - GridLayout(int rows, int cols) : Creates a grid with the specified number of rows and columns.
 * - GridLayout(int rows, int cols, int hgap, int vgap) : Creates a grid with gaps between cells.
 *
 * Usage
 * - Use GridLayout when you want a uniform grid of components with consistent sizing.
 * - Ideal for calculators, keypads, button panels, or any layout where components must align evenly.
 * - Simple and predictable; does not require manual size or alignment adjustments.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Grid Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the container to GridLayout.
     * - GridLayout arranges components in a grid with a specified number of rows and columns.
     * - All cells in the grid are forced to have equal width and height, and components are resized to fill their cell.
     * - Horizontal and vertical gaps between cells can be specified via the constructor.
     * - In this example, the grid has 3 rows, 3 columns, and a 5-pixel gap between components both horizontally and
     *   vertically.
     * - Using getContentPane() makes it explicit that the layout is being applied to the frame's content pane, which is
     *   the actual container for all added components.
     */
    frame.getContentPane().setLayout(new GridLayout(3, 3, 5, 5));

    /*
     * Adding Elements
     * - Adds components to the container using the current GridLayout.
     * - Components are placed sequentially in row-major order: left to right, top to bottom.
     * - Each component is resized to fill the cell completely.
     * - All cells are equal in size, ensuring uniform spacing and alignment for all components.
     */
    frame.add(new JButton("Button 1"));
    frame.add(new JButton("Button 2"));
    frame.add(new JButton("Button 3"));
    frame.add(new JButton("Button 4"));
    frame.add(new JButton("Button 5"));
    frame.add(new JButton("Button 6"));
    frame.add(new JButton("Button 7"));
    frame.add(new JButton("Button 8"));
    frame.add(new JButton("Button 9"));

    /*
     * Set Visible
     * - Makes the frame visible on the screen to demonstrate the layout in action.
     */
    frame.setVisible(true);
}

/*
 * EDT Initialization
 * - Launches the Swing application safely by scheduling the GUI initialization on the Event Dispatch Thread (EDT).
 */
void main() {
    SwingUtilities.invokeLater(() -> {
        example();
    });
}