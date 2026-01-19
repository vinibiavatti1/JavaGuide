/*
 * GridBag Layout
 * - This section explains the "GridBagLayout" layout manager in Java, which arranges components in a flexible grid of
 *   rows and columns, allowing components to span multiple cells and to have varying sizes.
 *
 * Overview
 * - The "GridBagLayout" class is part of the java.awt package.
 * - It provides precise control over component placement, alignment, and resizing.
 * - Components are positioned using a GridBagConstraints object, which defines size, position, and behavior.
 *
 * Key Characteristics
 * - Allows components to occupy multiple rows or columns (gridwidth, gridheight).
 * - Supports weightx and weighty for proportional resizing when the container is resized.
 * - Can control anchor, fill, and insets for alignment and spacing.
 * - Ideal for complex forms, dynamic layouts, and GUIs where flexibility is needed.
 *
 * Core Constraints Properties
 * - "gridx", "gridy"          : Position of the component in the grid.
 * - "gridwidth", "gridheight" : Number of cells the component spans horizontally or vertically.
 * - "weightx", "weighty"      : How extra space is distributed among components.
 * - "anchor"                  : Alignment of the component within its cell.
 * - "fill"                    : How the component resizes within its cell (NONE, HORIZONTAL, VERTICAL, BOTH).
 * - "insets"                  : External padding around the component.
 * - "ipadx", "ipady"          : Internal padding inside the component.
 *
 * Usage
 * - Use GridBagLayout when you need a highly flexible and responsive layout.
 * - Commonly used for forms, dashboards, and resizable GUIs with complex component arrangements.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Grid Bag Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the frame's content pane to GridBagLayout.
     */
    frame.getContentPane().setLayout(new GridBagLayout());

    /*
     * Create Constraints
     * - A GridBagConstraints object is used to define the placement and sizing behavior of each component.
     * - The insets field adds spacing between components.
     */
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.insets = new Insets(5, 5, 5, 5);

    /*
     * Adding Elements
     * - Demonstrates the flexibility of GridBagLayout by using multiple rows, columns, spanning cells, and resizing.
     * - Shows how buttons can occupy multiple cells and expand when the frame is resized.
     */
    // Button 1: spans 2 columns, fills horizontally
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 2;
    constraints.weightx = 1.0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    frame.add(new JButton("Button 1 (span 2 columns)"), constraints);
    // Button 2: default size, anchored top-left
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.weightx = 0.0;
    constraints.weighty = 0.0;
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.NORTHWEST;
    frame.add(new JButton("Button 2 (anchor NW)"), constraints);
    // Button 3: fills remaining space, spans remaining columns, expands vertically and horizontally
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.weightx = 1.0;
    constraints.weighty = 1.0;
    constraints.fill = GridBagConstraints.BOTH;
    frame.add(new JButton("Button 3 (fills space)"), constraints);

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