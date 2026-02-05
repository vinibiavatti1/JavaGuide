/*
 * Separator (JSeparator)
 * - This section explains the JSeparator component in Swing, which represents a visual divider used to separate
 *   groups of related components within a user interface.
 *
 * Overview
 * - JSeparator is part of the javax.swing package.
 * - It extends JComponent and provides a lightweight, non-interactive visual element.
 * - Commonly used in menus, toolbars, forms, and layout groupings.
 *
 * Key Characteristics
 * - Can be oriented horizontally or vertically.
 * - Does not receive focus or user input.
 * - Adapts its appearance to the current Look and Feel.
 * - Often used to improve visual structure and readability of interfaces.
 *
 * Usage
 * - Use JSeparator to visually separate sections of content.
 * - Helps group related UI elements without additional containers.
 * - Especially useful in layouts with multiple rows or columns.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Label");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    /*
     * Separator
     * - Demonstrates adding a horizontal JSeparator between components.
     * - The separator creates a visual division between "Content 1" and "Content 2".
     * - Commonly used in vertical layouts to separate logical sections.
     */
    frame.add(new JLabel("Content 1"));
    frame.add(new JSeparator());
    frame.add(new JLabel("Content 2"));

    /*
     * Set Visible
     * - Makes the frame visible on the screen to demonstrate the component in action.
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
