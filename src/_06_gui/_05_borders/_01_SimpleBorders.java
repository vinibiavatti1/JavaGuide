/*
 * Simple Borders
 * - This section explains the simple border implementations provided by Swing, used to visually delimit components with
 *   minimal styling and low visual complexity.
 *
 * Overview
 * - Simple borders are part of the javax.swing.border package.
 * - They provide basic visual separation and decoration without complex painting logic.
 * - Commonly used for spacing, grouping, or subtle visual feedback in Swing layouts.
 *
 * Types of Simple Borders
 * - LineBorder
 *   - Draws a single or multiple-pixel line around a component.
 *   - Supports custom color, thickness, and optional rounded corners.
 * - EtchedBorder (RAISED)
 *   - Creates a border that appears raised by using highlight and shadow colors.
 *   - Gives a subtle 3D effect, making the component appear slightly elevated.
 * - EtchedBorder (LOWERED)
 *   - Creates a border that appears lowered or recessed.
 *   - Uses inverted highlight and shadow to simulate depth.
 * - BevelBorder (RAISED)
 *   - Produces a strong raised 3D effect using two layers of highlight and shadow.
 *   - Commonly used to emphasize buttons or interactive areas.
 * - BevelBorder (LOWERED)
 *   - Produces a lowered 3D effect, making the component look pressed or embedded.
 *   - Often used to indicate selected or active states.
 * - EmptyBorder
 *   - Adds transparent space around a component without drawing any visible border.
 *   - Primarily used for padding and layout control.
 *
 * Key Characteristics
 * - Lightweight and efficient to render.
 * - Focused on basic visuals: lines, depth effects, or spacing.
 * - Easily composable with other borders using compound borders.
 *
 * Usage
 * - Use simple borders when you need clear visual separation or spacing with minimal styling.
 * - Ideal for basic UI layouts, padding control, and subtle visual cues.
 * - Prefer these borders over custom painting for simplicity and consistency.
 */
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Simple Borders");
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setLayout(new GridLayout(3, 2, 5, 5));

    /*
     * Borders
     * - The example below demonstrates how different border types are created and applied to JPanels.
     */
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panel2.setBorder(BorderFactory.createEtchedBorder());
    panel3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    panel4.setBorder(BorderFactory.createRaisedBevelBorder());
    panel5.setBorder(BorderFactory.createLoweredBevelBorder());
    panel6.setBorder(BorderFactory.createEmptyBorder());
    panel1.add(new JLabel("Line Border"));
    panel2.add(new JLabel("Etched Border"));
    panel3.add(new JLabel("Etched Border (RAISED)"));
    panel4.add(new JLabel("Bevel Border"));
    panel5.add(new JLabel("Lowered Bevel Border"));
    panel6.add(new JLabel("Empty Border"));
    panel.add(panel1);
    panel.add(panel2);
    panel.add(panel3);
    panel.add(panel4);
    panel.add(panel5);
    panel.add(panel6);
    frame.add(panel);

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