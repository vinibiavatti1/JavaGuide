/*
 * JWindow
 * - This section explains the JWindow class in Java Swing, which represents a top-level window without any window
 *   decorations such as a title bar, border, or buttons.
 *
 * Overview
 * - JWindow is part of the javax.swing package and extends java.awt.Window.
 * - Unlike JFrame or JDialog, JWindow does not have a title bar, menu bar, or close/minimize/maximize controls.
 * - Typically used for splash screens, tooltips, pop-ups, or overlays where standard window decorations are
 *   unnecessary.
 * - Can be associated with an owner Window or Frame to control positioning, but it can also operate independently.
 * - Supports adding standard Swing components and layout managers to build custom content.
 *
 * Key Characteristics
 * - Top-level container: cannot be added to other containers.
 * - Completely undecorated, providing full control over the visual appearance.
 * - Can be sized, positioned, and made visible like any other top-level window.
 * - Supports transparency and custom painting for advanced UI effects.
 * - Does not appear in the OS taskbar by default (behavior may vary by platform).
 * - Does not support modality; it cannot block input to other windows.
 *
 * Usage
 * - Use JWindow for temporary or decorative windows that do not require standard window decorations.
 * - Ideal for splash screens, loading screens, custom tooltips, floating panels, or notifications.
 * - Always create, configure, and show JWindow instances on the Event Dispatch Thread (EDT) to ensure thread safety.
 * - Combine with timers, animations, or custom painting to create visually appealing effects.
 * - Output: An undecorated top-level window displayed on the screen with custom content and appearance.
 */
import javax.swing.*;

void example() {
    /*
     * Window Declaration
     * - Creates a JWindow, a top-level undecorated window without title bar, borders, or close buttons.
     * - Unlike JFrame or JDialog, JWindow has no built-in way to close itself, so a custom button or action must be
     *   used to dispose or hide it.
     * - Sets the size, centers it on the screen, and allows custom component positioning with a null layout.
     * - Typically used for splash screens, overlays, or floating panels.
     */
    JWindow window = new JWindow();
    window.setSize(400, 300);
    window.setLocationRelativeTo(null);
    window.setLayout(null);

    /*
     * Close Button
     * - Adds a custom button to the JWindow to allow closing the application.
     * - Since JWindow has no built-in close controls, a button or other action must be used to exit or hide the window.
     * - Here, the button is positioned manually using absolute coordinates (null layout) and set to visible.
     * - The ActionListener calls System.exit(0) to terminate the application when clicked, mimicking
     *   JFrame.EXIT_ON_CLOSE behavior.
     * - Output: Clicking the "Close" button closes the application and the window disappears.
     */
    JButton closeButton = new JButton("Close");
    closeButton.setSize(80, 30);
    closeButton.setLocation(160, 135);
    closeButton.setVisible(true);
    closeButton.addActionListener(evt -> System.exit(0));
    window.add(closeButton);
    window.setVisible(true);
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