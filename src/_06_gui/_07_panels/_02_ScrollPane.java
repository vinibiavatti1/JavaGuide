/*
 * Scroll Pane (JScrollPane)
 * - This section explains the JScrollPane component in Swing, which provides a scrollable viewport for lightweight
 *   components such as JTextArea, JTable, JList, or any custom component.
 *
 * Overview
 * - JScrollPane is part of the javax.swing package.
 * - It allows vertical and/or horizontal scrolling when the content exceeds the visible area.
 * - The scroll pane can wrap any component that extends JComponent.
 * - Scrollbars can be configured to appear always, as needed, or never.
 *
 * Key Characteristics
 * - Supports vertical and horizontal scrollbars independently.
 * - Provides a viewport to display the wrapped component.
 * - Integrates seamlessly with the Swing Look and Feel, including modern themes.
 * - Supports keyboard navigation, mouse wheel scrolling, and programmatic scrolling.
 *
 * Scroll Pane Constants
 * - ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS / HORIZONTAL_SCROLLBAR_ALWAYS
 *   - Always visible.
 * - ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED / HORIZONTAL_SCROLLBAR_AS_NEEDED (Default)
 *   - Visible only when content exceeds viewport.
 * - ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER / HORIZONTAL_SCROLLBAR_NEVER
 *   - Never visible.
 *
 * Usage
 * - Use JScrollPane whenever a component can have content larger than the available space.
 * - Commonly used with JTextArea, JTable, JList, JPanel (with complex layouts), and custom components.
 * - Always wrap the component in a JScrollPane rather than adding scrollbars manually.
 * - Configure scrollbars to fit the UI design, for example, always visible for fixed menus or tool panels.
 * - Can be nested inside other containers like JPanel or JFrame for flexible layout management.
 */
import javax.swing.*;
import java.awt.*;

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
     * Inner Component
     * - JTextArea is a multi-line text component in Swing that allows the user to enter and edit plain text.
     * - It can be wrapped inside a JScrollPane to provide scrolling functionality when the content exceeds the visible
     *   area.
     */
    JTextArea textArea = new JTextArea();

    /*
     * Scroll Pane
     * - JScrollPane provides a scrollable viewport for components like JTextArea, allowing both vertical and horizontal
     *   scrolling.
     * - By setting VERTICAL_SCROLLBAR_ALWAYS and HORIZONTAL_SCROLLBAR_ALWAYS, the scrollbars are permanently visible,
     *   regardless of whether the content exceeds the viewport.
     * - Adding the JScrollPane to a container like JFrame or JPanel allows the wrapped component to be scrollable
     *   without modifying its internal behavior.
     */
    JScrollPane scrollPane = new JScrollPane(
            textArea,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );
    frame.add(scrollPane);

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