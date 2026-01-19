/*
 * Card Layout
 * - This section explains the "CardLayout" layout manager in Java, which allows multiple components (cards) to share
 *   the same display space, showing only one at a time.
 *
 * Overview
 * - The "CardLayout" class is part of the java.awt package.
 * - It is useful for creating wizard-style interfaces, tab-like navigation, or step-by-step forms.
 * - Each card is a component (e.g., JPanel) added to the container with a unique name (String identifier).
 * - Only one card is visible at a time, and switching between cards is done programmatically.
 *
 * Key Characteristics
 * - Cards are added to the container with a name using the "add(Component comp, String name)" method.
 * - Layout does not resize cards differently; all cards share the same container size.
 * - Switching cards does not remove them from the container; they remain in memory.
 *
 * Switch Cards
 * - The CardLayout provides the following methods to switch between cards:
 *   - show(Container parent, String name) : Displays the card associated with the given name.
 *   - next(Container parent)              : Shows the next card in the order they were added.
 *   - previous(Container parent)          : Shows the previous card in the order they were added.
 *   - first(Container parent)             : Displays the first card in the container.
 *   - last(Container parent)              : Displays the last card in the container.
 *
 * Usage
 * - Use CardLayout when you want multiple panels in the same space and control which one is visible.
 * - Ideal for wizards, tab-like interfaces without using JTabbedPane, or step-based forms.
 * - Switching cards is done by calling the layout manager's methods rather than manipulating component visibility
 *   directly.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Card Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the container to CardLayout.
     * - CardLayout allows multiple components (cards) to occupy the same space, showing only one at a time.
     * - The constructor can take horizontal and vertical gaps between cards (in pixels), which affect the spacing when
     *   cards are switched.
     * - Using getContentPane() makes it explicit that the layout is being applied to the frame's content pane, which is
     *   the actual container for all added components.
     */
    CardLayout cardLayout = new CardLayout(5, 5);
    frame.getContentPane().setLayout(cardLayout);

    /*
     * Adding Elements
     * - Adds components (cards) to the container using the current CardLayout.
     * - Each component is associated with a unique name, which is used to identify and display it.
     * - Only one card is visible at a time; the others remain hidden but in memory.
     * - Example: button1 is added as "step1", button2 as "step2", and button3 as "step3".
     */
    JButton button1 = new JButton("Step 1");
    JButton button2 = new JButton("Step 2");
    JButton button3 = new JButton("Step 3");
    frame.add(button1, "step1");
    frame.add(button2, "step2");
    frame.add(button3, "step3");

    /*
     * Switch Cards
     * - Demonstrates how to change which card is visible using CardLayout methods.
     * - The CardLayout provides the following methods to switch between cards:
     *   - show(Container parent, String name) : Displays the card associated with the given name.
     *   - next(Container parent)              : Shows the next card in the order they were added.
     *   - previous(Container parent)          : Shows the previous card in the order they were added.
     *   - first(Container parent)             : Displays the first card in the container.
     *   - last(Container parent)              : Displays the last card in the container.
     * - In this example:
     *   - Clicking button1 moves to the next card.
     *   - Clicking button2 jumps directly to "step3".
     *   - Clicking button3 returns to the first card ("step1").
     */
    button1.addActionListener(evt -> cardLayout.next(frame.getContentPane()));
    button2.addActionListener(evt -> cardLayout.show(frame.getContentPane(), "step3"));
    button3.addActionListener(evt -> cardLayout.first(frame.getContentPane()));

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