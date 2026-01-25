/*
 * Frame
 * - This section explains the JFrame class in Java Swing, which represents a top-level window with a title, border, and
 *   optional menu bar, serving as the main window for desktop applications.
 *
 * Overview
 * - JFrame is part of the javax.swing package and extends java.awt.Frame.
 * - It provides a standard window with decorations such as title bar, close/minimize/maximize buttons.
 * - Can contain Swing components, organized using layout managers.
 * - Supports setting default close operations to control behavior when the user closes the window.
 * - Acts as the primary container for most Swing applications, hosting panels, menus, and other UI elements.
 *
 * Key Characteristics
 * - Top-level container: cannot be added to other containers.
 * - Decorated window with optional resizing and menu support.
 * - Supports layout managers to arrange child components (e.g., BorderLayout, FlowLayout, GridLayout).
 * - Can be combined with modal dialogs, menus, and toolbars for full-featured applications.
 *
 * Usage
 * - Use JFrame as the main window for desktop applications.
 * - Create and initialize the JFrame on the Event Dispatch Thread (EDT) to ensure thread safety.
 * - Add content panels, menus, and other components to build the user interface.
 * - Configure size, visibility, and close behavior according to application requirements.
 */
import javax.swing.*;

void example() {
    /*
     * JFrame
     * - Creates a new instance of a top-level Swing window using the JFrame class.
     * - Provides a decorated window with a title bar, border, and optional menu support.
     * - Acts as the primary container for Swing applications, capable of holding panels, buttons, menus, and other
     *   components.
     * - Should be created and manipulated on the Event Dispatch Thread (EDT) to ensure thread safety.
     * - The frame is initially invisible; call frame.setVisible(true) to display it.
     * - Default close operation should be configured to control application behavior when the user closes the window.
     */
    JFrame frame = new JFrame();

    /*
     * Set Title
     * - Sets the text displayed in the title bar of the JFrame.
     * - Note: JFrame also has constructors that accept a title string (e.g., new JFrame("My Frame!")),
     *   which sets the title at creation time.
     */
    frame.setTitle("My Frame!");

    /*
     * Set Icon
     * - Sets the icon image displayed in the title bar and taskbar for the JFrame.
     * - The image is typically loaded as an ImageIcon from the classpath.
     * - Updates to the icon are applied immediately and reflected in the window decoration and OS taskbar.
     */
    ImageIcon icon = new ImageIcon(this.getClass().getResource("gui/application.png"));
    frame.setIconImage(icon.getImage());

    /*
     * Set Size
     * - Sets the initial width and height of the JFrame in pixels.
     * - Should be called after creating the frame and before making it visible.
     * - Alternatively, you can use frame.pack() to size the frame automatically based on its content.
     */
    frame.pack();            // Resize frame automatically based on its content
    frame.setSize(400, 300); // Set absolute size

    /*
     * Set Position
     * - Configures the location of the JFrame on the screen.
     * - frame.setLocation(x, y) sets an absolute position in pixels relative to the top-left corner of the screen.
     * - frame.setLocationRelativeTo(null) centers the JFrame on the screen regardless of screen resolution.
     * - Should be called after setting the size and before making the frame visible.
     */
    frame.setLocation(0, 0);           // Absolute position
    frame.setLocationRelativeTo(null); // Middle of the screen

    /*
     * Set Resizable
     * - Controls whether the user can resize the JFrame window.
     * - frame.setResizable(false) prevents the window from being resized, keeping its dimensions fixed.
     * - frame.setResizable(true) allows the user to adjust the window size freely.
     * - Should be set during frame initialization, before making the frame visible.
     */
    frame.setResizable(false);

    /*
     * Set Close Operation
     * - Defines the behavior of the JFrame when the user attempts to close the window.
     * - Constants available in WindowConstants:
     *   - EXIT_ON_CLOSE: terminates the application.
     *   - DISPOSE_ON_CLOSE: releases resources used by the frame but keeps the application running.
     *   - HIDE_ON_CLOSE: hides the frame without terminating the application.
     *   - DO_NOTHING_ON_CLOSE: ignores the close action; application must handle it manually.
     * - Should be set during frame initialization, before making the frame visible.
     */
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Set Visible
     * - Makes the JFrame appear on the screen.
     * - Should be called after all initialization, including size, position, content, and other configurations.
     * - Once visible, the frame will respond to user interactions and display its components.
     * - Output: The JFrame is displayed to the user with all configured properties.
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