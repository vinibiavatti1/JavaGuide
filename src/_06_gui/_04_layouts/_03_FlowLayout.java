/*
 * Flow Layout
 * - This section explains the "FlowLayout" layout manager in Java, which arranges components in a row, flowing from
 *   left to right, wrapping to the next line when the container’s width is exceeded.
 *
 * Overview
 * - The "FlowLayout" class is part of the java.awt package.
 * - It is the default layout manager for JPanel.
 * - Components are arranged in the order they are added to the container.
 * - When the container is resized, components adjust their position to fit within the new width.
 *
 * Key Characteristics
 * - Aligns components horizontally in a single row or multiple rows if needed.
 * - Supports alignment options: LEFT, CENTER, RIGHT, LEADING, and TRAILING.
 * - Supports horizontal and vertical gaps between components via constructor parameters.
 * - Simple and flexible for small or dynamically sized panels.
 *
 * Alignment Options
 * - FlowLayout.LEFT     : Align components to the left edge of the container.
 * - FlowLayout.CENTER   : Align components centered horizontally (default).
 * - FlowLayout.RIGHT    : Align components to the right edge of the container.
 * - FlowLayout.LEADING  : Align components based on the container's component orientation (left-to-right or
 *   right-to-left).
 * - FlowLayout.TRAILING : Align components opposite to LEADING.
 *
 * Usage
 * - Use FlowLayout for panels with a small number of components arranged in a simple sequence.
 * - Ideal for toolbars, button groups, or input fields where a natural left-to-right flow is desired.
 * - Often combined with nested panels for more complex GUI arrangements.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Flow Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the frame (or panel) to FlowLayout.
     * - FlowLayout places components sequentially from left to right, automatically wrapping to the next line when
     *   there is no more horizontal space.
     * - By default, FlowLayout is the layout manager used by every JPanel.
     * - Horizontal and vertical spacing between components can be customized via constructor parameters.
     * - Alignment behavior can be configured using the following constants:
     *   - FlowLayout.LEFT     : Aligns components to the left edge of the container.
     *   - FlowLayout.CENTER   : Aligns components to the center horizontally (default).
     *   - FlowLayout.RIGHT    : Aligns components to the right edge of the container.
     *   - FlowLayout.LEADING  : Aligns components according to the container’s orientation.
     *   - FlowLayout.TRAILING : Aligns components opposite to LEADING.
     * - Using getContentPane() makes it explicit that the layout is being applied to the frame's content pane, which is
     *   the actual container for all added components.
     */
    frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

    /*
     * Adding Elements
     * - Adds components to the container using the current layout manager.
     * - With FlowLayout, components are placed in the order they are added.
     * - Components flow from left to right and wrap to the next line when needed.
     */
    frame.add(new JButton("Button 1"));
    frame.add(new JButton("Button 2"));
    frame.add(new JButton("Button 3"));
    frame.add(new JButton("Button 4"));

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