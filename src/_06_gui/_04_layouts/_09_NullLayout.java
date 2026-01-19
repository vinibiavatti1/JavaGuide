/*
 * Null Layout
 * - This section explains the "Null Layout" in Java, where no layout manager is used and components are positioned
 *   absolutely.
 *
 * Overview
 * - In a Null Layout, the container does not automatically arrange components.
 * - Components must have their size and position explicitly set using setBounds(x, y, width, height).
 * - Provides maximum control over component placement but requires manual management of resizing and alignment.
 *
 * Key Characteristics
 * - Components are positioned absolutely within the container.
 * - Resizing the container does not automatically adjust component positions or sizes.
 * - Useful for custom UI designs where precise placement is needed.
 * - Generally discouraged for standard GUI development because it does not adapt to different screen sizes or fonts.
 *
 * Usage
 * - Use Null Layout when you need precise control over component positions.
 * - Often used in simple games, custom graphics panels, or highly specific interface designs.
 * - All positioning and sizing must be managed manually.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Null Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the frame's content pane to null.
     * - This disables automatic layout, requiring explicit position and size for all components.
     */
    frame.getContentPane().setLayout(null);

    /*
     * Adding Elements
     * - Adds components to the container with explicit bounds (x, y, width, height).
     * - Components will not move or resize automatically when the frame is resized.
     */
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    button1.setBounds(50, 30, 100, 40);
    button2.setBounds(200, 100, 120, 50);
    button3.setBounds(100, 180, 150, 40);
    frame.add(button1);
    frame.add(button2);
    frame.add(button3);

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