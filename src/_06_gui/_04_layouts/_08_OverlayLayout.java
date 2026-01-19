/*
 * Overlay Layout
 * - This section explains the "OverlayLayout" layout manager in Java, which arranges components on top of each other
 *   in a single container, allowing for layering of components.
 *
 * Overview
 * - The "OverlayLayout" class is part of the javax.swing package.
 * - It positions all components within the container to occupy the same display area.
 * - The size of the container is determined by the largest component along each axis.
 * - Component alignment (X and Y) can be configured using setAlignmentX(float) and setAlignmentY(float).
 * - The stacking order is determined by the order of addition: components added later appear on top of earlier ones.
 *
 * Key Characteristics
 * - Allows overlapping or layered components.
 * - Supports alignment within the container using X/Y alignment properties.
 * - Container size adapts to the largest component in each dimension.
 * - Ideal for effects like overlays, badges, or layered images.
 *
 * Z-Order
 * - By default, components are stacked in the order they are added.
 * - Use container.setComponentZOrder(component, index) to adjust stacking dynamically:
 *   - index = 0 -> component moves to the top.
 *   - index = getComponentCount() - 1 -> component moves to the bottom.
 *
 * Usage
 * - Typically used for custom visual effects or components that must overlap.
 * - Not recommended for standard forms or grids since there is no automatic flow or layout management.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Overlay Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the frame's content pane to OverlayLayout.
     * - Components added to the container will be stacked on top of each other.
     */
    frame.getContentPane().setLayout(new OverlayLayout(frame.getContentPane()));

    /*
     * Adding Elements
     * - Adds buttons to the container.
     * - The second button ("Front") will appear on top of the first button ("Behind") because it is added last.
     */
    JButton button1 = new JButton("Front");
    JButton button2 = new JButton("Behind");
    frame.add(button1);
    frame.add(button2);

    /*
     * Set Z-Order
     * - Adjusts the stacking order of components within the container.
     * - Components with a lower index appear on top of those with a higher index.
     * - After changing the Z-order, call container.revalidate() and container.repaint() to update the display.
     */
    frame.getContentPane().setComponentZOrder(button1, 0);
    frame.getContentPane().setComponentZOrder(button2, 1);
    frame.getContentPane().revalidate();
    frame.getContentPane().repaint();

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