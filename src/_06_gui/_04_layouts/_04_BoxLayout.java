/*
 * Box Layout
 * - This section explains the "BoxLayout" layout manager in Java, which arranges components either vertically or
 *   horizontally in a single direction.
 *
 * Overview
 * - The "BoxLayout" class is part of the javax.swing package.
 * - It works with Swing containers such as JPanel and content panes.
 * - Components are laid out in a straight line, respecting their preferred, minimum, and maximum sizes.
 *
 * Key Characteristics
 * - Supports two layout directions: horizontal and vertical.
 * - Components are placed in the order they are added to the container.
 * - Honors component alignment (X and Y alignment) for fine-grained positioning.
 * - Allows flexible spacing using rigid areas, glue, and struts.
 *
 * Axis Options
 * - BoxLayout.X_AXIS    : Arranges components horizontally from left to right.
 * - BoxLayout.Y_AXIS    : Arranges components vertically from top to bottom.
 * - BoxLayout.LINE_AXIS : Horizontal layout respecting component orientation.
 * - BoxLayout.PAGE_AXIS : Vertical layout respecting component orientation.
 *
 * Box Utilities
 * - The Box class provides utility methods to create invisible components that help control spacing, alignment, and
 *   layout behavior in containers using BoxLayout. These utilities are especially useful when precise control over gaps
 *   and flexible spacing is needed.
 * - Common Box utility methods:
 *   - Box.createHorizontalStrut(int width) : Adds a fixed horizontal space of the specified width.
 *   - Box.createHorizontalGlue()           : Adds flexible horizontal space that expands to fill available room.
 *   - Box.createHorizontalBox()            : Creates a container with a horizontal BoxLayout.
 *   - Box.createVerticalStrut(int height)  : Adds a fixed vertical space of the specified height.
 *   - Box.createVerticalGlue()             : Adds flexible vertical space that expands to fill available room.
 *   - Box.createVerticalBox()              : Creates a container with a vertical BoxLayout.
 *   - Box.createGlue()                     : Adds flexible space that expands along the current axis.
 *   - Box.createRigidArea(Dimension size)  : Adds a fixed-size space in both width and height.
 *
 * Difference from FlowLayout
 * - Unlike FlowLayout, BoxLayout does not wrap components to the next line or column.
 * - BoxLayout enforces a single-axis layout, providing more predictable and precise positioning.
 * - FlowLayout is simpler and automatically reflows components based on available space, while BoxLayout offers finer
 *   control over alignment, spacing, and component sizing.
 *
 * Usage
 * - Use BoxLayout when you need precise control over component alignment and spacing.
 * - Ideal for forms, toolbars, and stacked UI elements.
 * - Commonly combined with Box utilities (Box.createGlue, createStrut, createRigidArea) to control spacing and layout
 *   behavior.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the layout manager.
     * - The frame's title, size, screen position, and default close operation are configured.
     */
    JFrame frame = new JFrame("Box Layout");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Layout
     * - Sets the layout manager of the container to BoxLayout.
     * - BoxLayout arranges components in a single row or column, based on the selected axis.
     * - Components are laid out in the order they are added to the container.
     * - The axis defines the layout direction and must be specified when creating the BoxLayout.
     * - Component alignment and spacing are controlled via alignment properties and Box utilities (e.g., struts, glue,
     *   and rigid areas).
     * - Layout behavior can be configured using the following axis constants:
     *   - BoxLayout.X_AXIS    : Arranges components horizontally from left to right.
     *   - BoxLayout.Y_AXIS    : Arranges components vertically from top to bottom.
     *   - BoxLayout.LINE_AXIS : Horizontal layout respecting component orientation.
     *   - BoxLayout.PAGE_AXIS : Vertical layout respecting component orientation.
     * - Using getContentPane() makes it explicit that the layout is being applied to the frame's content pane, which is
     *   the actual container for all added components.
     */
    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

    /*
     * Adding Elements
     * - Adds components to the container using the current BoxLayout.
     * - Components are placed sequentially along the selected axis.
     * - Unlike FlowLayout, components do not wrap to a new line or column.
     * - Spacing and alignment can be fine-tuned using Box utilities and alignment properties.
     */
    frame.add(new JButton("Button 1"));
    frame.add(new JButton("Button 2"));
    frame.add(new JButton("Button 3"));

    /*
     * Box Utilities
     * - Adds components to the container using the current BoxLayout.
     * - Components are placed sequentially along the selected axis.
     * - Spacing and alignment can be fine-tuned using Box utilities:
     *   - Box.createHorizontalStrut(int width) : Adds a fixed horizontal space of the specified width.
     *   - Box.createHorizontalBox()            : Creates a container with a horizontal BoxLayout.
     *   - Box.createHorizontalGlue()           : Adds flexible horizontal space that expands to fill available room.
     *   - Box.createVerticalBox()              : Creates a container with a vertical BoxLayout.
     *   - Box.createVerticalStrut(int height)  : Adds a fixed vertical space of the specified height.
     *   - Box.createVerticalGlue()             : Adds flexible vertical space that expands to fill available room.
     *   - Box.createGlue()                     : Adds flexible space that expands along the current axis.
     *   - Box.createRigidArea(Dimension size)  : Adds a fixed-size space in both width and height.
     */
    frame.add(Box.createVerticalStrut(30));
    frame.add(new JButton("Button 4"));
    frame.add(Box.createVerticalGlue());
    frame.add(new JButton("Button 5"));
    frame.add(Box.createRigidArea(new Dimension(0, 15)));
    frame.add(new JButton("Button 6"));

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