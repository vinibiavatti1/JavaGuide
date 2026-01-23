/*
 * Matte Borders
 * - This section explains matte border implementations in Swing, which provide flexible, area-based borders using solid
 *   colors or tiled icons.
 *
 * Overview
 * - Matte borders are part of the javax.swing.border package.
 * - They allow defining borders with independent thickness on each side.
 * - The border area is filled rather than drawn as a line, enabling solid blocks or repeated patterns.
 * - Commonly used for padding, separators, and visually weighted edges.
 *
 * Types of Matte Borders
 * - MatteBorder (Color)
 *   - Fills the border area with a solid color.
 *   - Supports independent thickness for top, left, bottom, and right edges.
 *   - Suitable for clean separators, emphasis lines, or consistent padding visuals.
 * - MatteBorder (Icon)
 *   - Fills the border area by tiling an icon image.
 *   - The icon is repeated to cover the entire border region.
 *   - Useful for textured, patterned, or decorative borders.
 *
 * Key Characteristics
 * - Area-based rendering rather than line-based drawing.
 * - Fine-grained control over border thickness per edge.
 * - Supports both solid colors and tiled icon patterns.
 * - Lightweight and efficient for standard Swing rendering.
 *
 * Usage
 * - Use matte borders when you need precise control over border thickness and spacing.
 * - Prefer color-based matte borders for simple separation and layout padding.
 * - Use icon-based matte borders sparingly for decorative or thematic UI elements.
 * - Often combined with other borders using compound borders to layer visuals and spacing.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Matte Borders");
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setLayout(new GridLayout(2, 1, 5, 5));

    /*
     * Borders
     * - The example below demonstrates how different border types are created and applied to JPanels.
     */
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    panel1.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.BLACK));
    panel2.setBorder(BorderFactory.createMatteBorder(16, 16, 16, 16, new ImageIcon(this.getClass().getResource("heart.png"))));
    panel1.add(new JLabel("Matte Border With Color"));
    panel2.add(new JLabel("Matte Border With Icon"));
    panel.add(panel1);
    panel.add(panel2);
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