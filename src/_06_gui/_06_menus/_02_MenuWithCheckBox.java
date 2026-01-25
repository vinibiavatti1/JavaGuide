/*
 * Menu With Check Box (JCheckBoxMenuItem)
 * - This section explains the JCheckBoxMenuItem component in Swing, which represents a menu item with a persistent
 *   on/off (checked) state.
 *
 * Overview
 * - JCheckBoxMenuItem is part of the javax.swing package.
 * - It extends JMenuItem and implements a selectable state.
 * - Commonly used inside JMenu or JPopupMenu to toggle features or views.
 *
 * Key Characteristics
 * - Maintains an independent selected/unselected state.
 * - Visually displays a check mark when selected.
 * - Supports keyboard mnemonics and accelerators.
 * - Integrates with ButtonModel for state management.
 * - Fully compatible with the current Look and Feel.
 *
 * Usage
 * - Use JCheckBoxMenuItem for enabling or disabling optional features.
 * - Ideal for showing or hiding panels, toolbars, or UI sections.
 * - Handle state changes via ActionListener or ItemListener.
 * - Prefer over JMenuItem when a persistent toggle state is required.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Menu With Check Box");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Check Box Menu Items
     * - JCheckBoxMenuItem represents a menu item with a selectable on/off state.
     * - Each item maintains its own selection state independently.
     * - Commonly used for toggling features, views, or optional panels.
     * - The constructor can accept an initial boolean value to define the default selected state.
     */
    JCheckBoxMenuItem menuItem1 = new JCheckBoxMenuItem("Menu", true); // Pre Selected
    JCheckBoxMenuItem menuItem2 = new JCheckBoxMenuItem("Editor");
    JCheckBoxMenuItem menuItem3 = new JCheckBoxMenuItem("Console");

    /*
     * Set Icons
     * - Assigns graphical icons to JCheckBoxMenuItem instances to improve visual recognition and usability.
     * - Icons are displayed to the left of the menu item text, following the current Look and Feel.
     */
    menuItem1.setIcon(new ImageIcon(this.getClass().getResource("gui/application.png")));
    menuItem2.setIcon(new ImageIcon(this.getClass().getResource("gui/application.png")));
    menuItem3.setIcon(new ImageIcon(this.getClass().getResource("gui/application.png")));

    /*
     * Set Accelerators (Shortcuts)
     * - Defines keyboard shortcuts that trigger the menu item action regardless of menu focus.
     * - Accelerators are typically displayed next to the menu item text in the menu UI.
     * - Uses KeyStroke to describe key combinations in a platform-independent way.
     */
    menuItem1.setAccelerator(KeyStroke.getKeyStroke("control 1"));
    menuItem2.setAccelerator(KeyStroke.getKeyStroke("control 2"));
    menuItem3.setAccelerator(KeyStroke.getKeyStroke("control 3"));

    /*
     * Menu
     * - Creates a JMenu that represents a top-level menu category.
     * - Menu items are added in sequence to define their visual order.
     * - Separators are used to logically group related actions.
     */
    JMenu fileMenu = new JMenu("Show");
    fileMenu.add(menuItem1);
    fileMenu.add(menuItem2);
    fileMenu.add(menuItem3);

    /*
     * Menu Bar
     * - Creates a JMenuBar to serve as the main menu container for the window.
     * - Integrated with the JFrame to appear in the standard menu area.
     */
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(fileMenu);
    frame.setJMenuBar(menuBar);

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