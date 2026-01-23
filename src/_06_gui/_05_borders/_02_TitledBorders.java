/*
 * Titled Borders
 * - This section explains titled borders in Swing, which combine a border with a textual title to label and group
 *   related components.
 *
 * Overview
 * - Titled borders are part of the javax.swing.border package.
 * - They decorate an existing border with a text label.
 * - Commonly used to visually group components and provide contextual information.
 * - The title is rendered on top of the border and does not affect component layout.
 *
 * Types of Titled Borders
 * - TitledBorder (Default)
 *   - Uses a default border provided by the current Look and Feel.
 *   - Suitable for standard grouping with minimal configuration.
 * - TitledBorder (With Custom Border)
 *   - Wraps a user-defined border (e.g., LineBorder, MatteBorder).
 *   - Allows full control over the visual style of the border.
 *   - Commonly used to match custom UI themes.
 *
 * Title Justification
 * - TitledBorder.LEFT     : Aligns the title to the left edge of the border.
 * - TitledBorder.CENTER   : Centers the title horizontally within the border.
 * - TitledBorder.RIGHT    : Aligns the title to the right edge of the border.
 * - TitledBorder.LEADING  : Aligns the title to the leading edge (left in LTR, right in RTL).
 * - TitledBorder.TRAILING : Aligns the title to the trailing edge (right in LTR, left in RTL).
 *
 * Title Position
 * - TitledBorder.ABOVE_TOP    : Places the title above the top border.
 * - TitledBorder.TOP          : Places the title at the top border.
 * - TitledBorder.BELOW_TOP    : Places the title just below the top border.
 * - TitledBorder.ABOVE_BOTTOM : Places the title just above the bottom border.
 * - TitledBorder.BOTTOM       : Places the title at the bottom border.
 * - TitledBorder.BELOW_BOTTOM : Places the title just below the bottom border.
 *
 * Key Characteristics
 * - Combines textual labeling with visual grouping.
 * - Fully customizable appearance through font, color, and border composition.
 * - Integrates seamlessly with Swing Look and Feel.
 * - Lightweight and consistent with Swing rendering.
 *
 * Usage
 * - Use titled borders to label groups of related components.
 * - Ideal for forms, settings panels, radio buttons, and configuration sections.
 * - Prefer concise titles to avoid visual clutter.
 * - Often combined with simple or matte borders for clean visual structure.
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Titled Borders");
    frame.setSize(500, 500);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panel.setLayout(new GridLayout(4, 2, 5, 5));

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
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();
    panel1.setBorder(BorderFactory.createTitledBorder("Title"));
    panel2.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.CENTER, TitledBorder.TOP));
    panel3.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.RIGHT, TitledBorder.TOP));
    panel4.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.LEFT, TitledBorder.ABOVE_TOP));
    panel5.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.LEFT, TitledBorder.BELOW_TOP));
    panel6.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.LEFT, TitledBorder.ABOVE_BOTTOM));
    panel7.setBorder(BorderFactory.createTitledBorder(null, "Title", TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
    panel8.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Title"));
    panel1.add(new JLabel("Title Border (Default)"));
    panel2.add(new JLabel("Title Border (CENTER, TOP)"));
    panel3.add(new JLabel("Title Border (RIGHT, TOP)"));
    panel4.add(new JLabel("Title Border (LEFT, ABOVE_TOP)"));
    panel5.add(new JLabel("Title Border (LEFT, BELOW_TOP)"));
    panel6.add(new JLabel("Title Border (LEFT, ABOVE_BOTTOM)"));
    panel7.add(new JLabel("Title Border (LEFT, BELOW_BOTTOM)"));
    panel8.add(new JLabel("Title Border (Custom Border)"));
    panel.add(panel1);
    panel.add(panel2);
    panel.add(panel3);
    panel.add(panel4);
    panel.add(panel5);
    panel.add(panel6);
    panel.add(panel7);
    panel.add(panel8);
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