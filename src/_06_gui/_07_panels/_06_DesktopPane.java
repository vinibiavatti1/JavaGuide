/*
 * Desktop Pane (JDesktopPane)
 * - This section demonstrates the use of JDesktopPane as a container for JInternalFrames in Swing.
 * - A desktop pane allows creating multiple "internal windows" within a single main JFrame.
 * - Internal dialogs can also be shown inside a desktop pane using JOptionPane's internal variants.
 *
 * Overview
 * - JDesktopPane is part of the javax.swing package.
 * - It provides a layered pane for managing JInternalFrames.
 * - Internal frames can be moved, resized, minimized, maximized, and closed independently.
 * - The desktop pane supports stacking order (Z-order) via toFront() and toBack().
 *
 * Key Characteristics
 * - Enables MDI (Multiple Document Interface) style interfaces.
 * - Supports internal frames and internal dialogs.
 * - Integrates with Swing’s layout and event systems.
 * - Allows customization of background, borders, and look-and-feel.
 *
 * Usage
 * - Use JDesktopPane when multiple internal windows or internal dialogs are needed in a single main window.
 * - Combine with JInternalFrame to create movable, resizable, and closable sub-windows.
 * - Internal dialogs (JOptionPane.showInternalXXX) can be shown inside the desktop pane.
 * - Use toFront() and toBack() to control which internal frame appears on top.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to host the JDesktopPane and its internal frames.
     */
    JFrame frame = new JFrame("Desktop Pane Example");
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Desktop Pane
     * - Demonstrates a JDesktopPane container for internal frames.
     * - Background color and border are customized for visual clarity.
     * - Acts as the "desktop" where internal windows can be added and arranged.
     */
    JDesktopPane desktopPane = new JDesktopPane();
    desktopPane.setBorder(BorderFactory.createLoweredBevelBorder());
    desktopPane.setBackground(new Color(16, 58, 132, 255));
    frame.add(desktopPane);

    /*
     * Internal Frame
     * - Demonstrates a basic JInternalFrame added to the desktop pane.
     * - Internal frames are movable and resizable if configured.
     * - Initially, no actions (close, maximize, minimize) are enabled.
     * - Position and size are defined using setBounds(x, y, width, height).
     */
    JInternalFrame internalFrame = new JInternalFrame("Frame 1");
    internalFrame.setBounds(10, 10, 300, 200);
    internalFrame.setVisible(true);
    desktopPane.add(internalFrame);

    /*
     * Internal Frame With Actions
     * - Demonstrates a JInternalFrame with standard actions enabled using the constructor.
     * - Constructor used: JInternalFrame(String title, boolean resizable, boolean closable, boolean maximizable,
     *   boolean iconifiable)
     */
    JInternalFrame internalFrameWithActions = new JInternalFrame("Frame 2", true, true, true, true);
    internalFrameWithActions.setBounds(50, 50, 300, 200);
    internalFrameWithActions.setVisible(true);
    desktopPane.add(internalFrameWithActions);

    /*
     * Internal Frame Placement
     * - Demonstrates controlling the stacking order (Z-order) of internal frames.
     * - toBack(): sends the frame behind all other internal frames.
     * - toFront(): brings the frame above all other internal frames.
     * - This allows controlling which internal frame appears on top visually.
     */
    internalFrame.toBack();
    internalFrameWithActions.toFront();

    /*
     * Internal Dialogs
     * - Demonstrates showing internal dialogs within the desktop pane using JOptionPane.
     * - Internal dialogs are modal to the desktop pane but do not block the main JFrame.
     * - Useful for notifications, prompts, or confirmations within an MDI interface.
     */
    JOptionPane.showInternalMessageDialog(frame.getContentPane(), "Internal Dialog!");

    /*
     * Set Visible
     * - Makes the JFrame visible so that the desktop pane and internal frames can be interacted with.
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
