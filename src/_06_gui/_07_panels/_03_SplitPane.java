/*
 * Split Pane (JSplitPane)
 * - This section explains the JSplitPane component in Swing, which provides a container that divides two components
 *   with a draggable divider. It allows the user to adjust the relative size of the components interactively.
 *
 * Overview
 * - JSplitPane is part of the javax.swing package.
 * - It extends JComponent and can hold exactly two components: one on the left/top and one on the right/bottom.
 * - The divider can be moved by the user or programmatically to resize the components.
 * - Supports both horizontal and vertical splits.
 *
 * Key Characteristics
 * - Allows dynamic resizing of contained components.
 * - Can set a continuous layout for smooth resizing or deferred layout for better performance.
 * - Supports one-touch expandable dividers, which allow quick collapsing and expanding of components.
 * - Divider size and border can be customized for appearance and usability.
 *
 * Types
 * - JSplitPane.HORIZONTAL_SPLIT: Divides the container vertically, placing the components on the left and right.
 * - JSplitPane.VERTICAL_SPLIT: Divides the container horizontally, placing the components on the top and bottom.
 *
 * Component Setters
 * - setLeftComponent()   : Sets the component on the left side.
 * - setRightComponent()  : Sets the component on the right side.
 * - setTopComponent()    : Sets the component on the top side.
 * - setBottomComponent() : Sets the component on bottom side.
 *
 * Divider
 * - The divider is the draggable bar that separates the two components.
 * - Main Methods:
 *   - getDividerLocation(): Returns the current position of the divider in pixels.
 *   - setDividerLocation(int location): Sets the divider position programmatically.
 *   - setDividerSize(int size): Sets the thickness of the divider.
 *   - setOneTouchExpandable(boolean expandable): Enables small buttons on the divider for quick collapse/expand.
 *
 * Usage
 * - Use JSplitPane to create resizable areas in a UI, such as editors, file explorers, or tool panels.
 * - Combine with JScrollPane, JPanel, or other components to make complex, adjustable layouts.
 * - Configure the divider location and resize weight to match the desired default layout.
 * - Consider enabling one-touch expandable for user convenience in applications with collapsible panels.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Split Pane");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Panels
     * - Two JPanel instances are created to serve as the content components for a JSplitPane.
     * - Each panel contains a simple JLabel to visually identify it as the left or right component.
     * - These panels demonstrate how the JSplitPane organizes and resizes its child components interactively.
     */
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    leftPanel.add(new JLabel("Left Panel"));
    rightPanel.add(new JLabel("Right Panel"));

    /*
     * Split Pane
     * - JSplitPane is created to demonstrate a horizontal split between two components.
     * - The left and right components are set directly in the constructor, but they can also be set using setters.
     * - The type of split is defined using constants:
     *   - JSplitPane.HORIZONTAL_SPLIT: Left and right components.
     *   - JSplitPane.VERTICAL_SPLIT: Top and bottom components.
     * - The divider is made one-touch expandable, allowing quick collapse and expansion of either component.
     */
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
    splitPane.setOneTouchExpandable(true);
    frame.add(splitPane);

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