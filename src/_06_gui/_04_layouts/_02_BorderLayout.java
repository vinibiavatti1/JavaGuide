/*
 * Border Layout
 * - This section explains the "BorderLayout" layout manager in Java, which arranges components in five distinct
 *   regions within a container, controlling how space is distributed horizontally and vertically.
 *
 * Overview
 * - The "BorderLayout" class is part of the java.awt package.
 * - It is the default layout manager for JFrame, JDialog, and other top-level containers.
 * - It divides the container into five areas: North, South, East, West, and Center.
 * - Each region can hold at most one component; adding another replaces the previous one.
 *
 * Key Characteristics
 * - The Center region takes up all remaining available space.
 * - North and South components are stretched horizontally.
 * - East and West components are stretched vertically.
 * - Supports horizontal and vertical gaps between components via constructor parameters.
 *
 * Constraints
 * - BorderLayout.NORTH  : Positions the component at the top of the container.
 * - BorderLayout.SOUTH  : Positions the component at the bottom of the container.
 * - BorderLayout.EAST   : Positions the component on the right side.
 * - BorderLayout.WEST   : Positions the component on the left side.
 * - BorderLayout.CENTER : Positions the component in the center, occupying remaining space.
 *
 * Usage
 * - Use BorderLayout when you need a simple and well-structured main window layout.
 * - Ideal for applications with headers, footers, side panels, and a main content area.
 * - Commonly combined with other layout managers inside nested panels for complex UIs.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Border Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the frame to BorderLayout.
     * - By default, JFrame uses BorderLayout for its content pane, so this explicitly reinforces it.
     * - BorderLayout arranges components in five regions: PAGE_START, PAGE_END, LINE_START, LINE_END, and CENTER.
     * - Using getContentPane() makes it explicit that the layout is being applied to the frame's content pane, which is
     *   the actual container for all added components.
     */
    frame.getContentPane().setLayout(new BorderLayout());

    /*
     * Adding Elements
     * - Components are added to the frame using the add() method with a position constraint.
     * - The position defines the region of the BorderLayout where the component will be placed.
     * - Possible position values:
     *   - BorderLayout.PAGE_START : Top of the container.
     *   - BorderLayout.PAGE_END   : Bottom of the container.
     *   - BorderLayout.LINE_START : Left side of the container.
     *   - BorderLayout.LINE_END   : Right side of the container.
     *   - BorderLayout.CENTER     : Center, occupying remaining space.
     */
    frame.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
    frame.add(new JButton("LINE_START"), BorderLayout.LINE_START);
    frame.add(new JButton("CENTER"), BorderLayout.CENTER);
    frame.add(new JButton("LINE_END"), BorderLayout.LINE_END);
    frame.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);

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