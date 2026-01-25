/*
 * Panel (JPanel)
 * - This section explains the JPanel component in Swing, which is a generic lightweight container used to group,
 *   organize, and layout other UI components.
 *
 * Overview
 * - JPanel is part of the javax.swing package.
 * - It extends JComponent and serves as a flexible container for other Swing components.
 * - By default, it uses FlowLayout, but supports any LayoutManager.
 *
 * Key Characteristics
 * - Acts as a container; it does not provide windowing features by itself.
 * - Supports custom layouts via LayoutManager (e.g., BorderLayout, GridLayout, BoxLayout).
 * - Can be nested inside other containers such as JFrame, JDialog, or other JPanels.
 * - Supports custom painting by overriding paintComponent.
 * - Fully lightweight and double-buffered for smooth rendering.
 *
 * Usage
 * - Use JPanel to logically group related components (buttons, fields, labels, etc.).
 * - Ideal for structuring complex UIs by composing multiple panels.
 * - Commonly used to apply specific layouts or borders to a group of components.
 * - Serves as the base for custom reusable UI components.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Component");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Component
     * - The example below shows the usage of the component.
     */
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createTitledBorder("Title"));
    frame.add(panel);

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