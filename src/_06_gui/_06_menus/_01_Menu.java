/*
 * Menu (JMenu)
 * - This section explains the JMenu component in Swing, which represents a drop-down menu typically placed inside a
 *   JMenuBar and used to organize and trigger application actions.
 *
 * Overview
 * - JMenu is part of the javax.swing package.
 * - It extends JMenuItem and acts as a container for other menu elements.
 * - It is usually displayed within a JMenuBar at the top of a window.
 *
 * Key Characteristics
 * - Represents a hierarchical menu that can contain menu items, separators, and submenus.
 * - Supports keyboard mnemonics and accelerators for accessibility and productivity.
 * - Can contain different types of JMenuItem implementations.
 * - Integrates with the Look and Feel to provide native-like menu behavior.
 *
 * MenuBar Types
 * - JMenuBar: Standard menu bar placed at the top of a JFrame or JDialog.
 * - JPopupMenu: Context or popup menu that can be shown anywhere (often used as right-click menus).
 *
 * Menu Types
 * - JMenu: A menu that can contain other menus or menu items (supports submenus).
 * - JPopupMenu: A floating menu used outside the menu bar context.
 *
 * MenuItem Types
 * - JMenuItem: Basic clickable menu item that triggers an action.
 * - JCheckBoxMenuItem: Menu item with a checkbox state (on/off).
 * - JRadioButtonMenuItem: Menu item that belongs to a group where only one can be selected.
 * - JMenu: Used as a submenu inside another menu.
 * - JSeparator: Visual separator used to group related menu items.
 *
 * Usage
 * - Use JMenu to group related commands under a common category.
 * - Place JMenu instances inside a JMenuBar for top-level navigation.
 * - Use JCheckBoxMenuItem and JRadioButtonMenuItem for toggle or exclusive options.
 * - Apply separators to improve menu readability and logical grouping.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Menu");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Menu Items
     * - JMenuItem represents a basic, clickable option inside a JMenu or JPopupMenu.
     * - Each menu item typically triggers a specific action when selected by the user.
     */
    JMenuItem menuItem1 = new JMenuItem("New");
    JMenuItem menuItem2 = new JMenuItem("Open");
    JMenuItem menuItem3 = new JMenuItem("Save");
    JMenuItem menuItem4 = new JMenuItem("Exit");

    /*
     * Set Icons
     * - Assigns graphical icons to JMenuItem instances to improve visual recognition and usability.
     * - Icons are displayed to the left of the menu item text, following the current Look and Feel.
     */
    menuItem1.setIcon(new ImageIcon(this.getClass().getResource("gui/page_white.png")));
    menuItem2.setIcon(new ImageIcon(this.getClass().getResource("gui/folder_page_white.png")));
    menuItem3.setIcon(new ImageIcon(this.getClass().getResource("gui/disk.png")));

    /*
     * Set Accelerators (Shortcuts)
     * - Defines keyboard shortcuts that trigger the menu item action regardless of menu focus.
     * - Accelerators are typically displayed next to the menu item text in the menu UI.
     * - Uses KeyStroke to describe key combinations in a platform-independent way.
     */
    menuItem1.setAccelerator(KeyStroke.getKeyStroke("control N"));
    menuItem2.setAccelerator(KeyStroke.getKeyStroke("control O"));
    menuItem3.setAccelerator(KeyStroke.getKeyStroke("control S"));

    /*
     * Set Actions
     * - Attaches ActionListener implementations to menu items to define their behavior when selected.
     * - Each listener is triggered by user interaction, such as a mouse click or keyboard accelerator.
     * - Lambda expressions provide a concise way to define action handling logic.
     */
    menuItem1.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "New"));
    menuItem2.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Open"));
    menuItem3.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Save"));
    menuItem4.addActionListener(evt -> System.exit(0));

    /*
     * Menu
     * - Creates a JMenu that represents a top-level menu category.
     * - Menu items are added in sequence to define their visual order.
     * - Separators are used to logically group related actions.
     */
    JMenu menu = new JMenu("File");
    menu.add(menuItem1);
    menu.add(menuItem2);
    menu.add(menuItem3);
    menu.addSeparator();
    menu.add(menuItem4);

    /*
     * Menu Bar
     * - Creates a JMenuBar to serve as the main menu container for the window.
     * - Integrated with the JFrame to appear in the standard menu area.
     */
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
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