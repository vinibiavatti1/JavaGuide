/*
 * Menu With Radio Button (JRadioButtonMenuItem)
 * - This section explains the JRadioButtonMenuItem component in Swing, which represents a menu item with a mutually
 *   exclusive selection state within a ButtonGroup.
 *
 * Overview
 * - JRadioButtonMenuItem is part of the javax.swing package.
 * - It extends JMenuItem and adds a selectable on/off state managed by a ButtonGroup.
 * - Only one item in a group can be selected at a time, ensuring exclusive choices.
 *
 * Key Characteristics
 * - Supports an initial selected state via constructor.
 * - Can display text, icons, or both, similar to standard JMenuItem.
 * - Integrates with keyboard mnemonics and accelerators.
 * - Fully compatible with Look and Feel for visual consistency.
 *
 * Usage
 * - Use JRadioButtonMenuItem to present options where only one selection is allowed.
 * - Group related radio menu items using ButtonGroup to enforce exclusive selection.
 * - Ideal for settings like themes, languages, or modes.
 * - Add items to a JMenu or JPopupMenu to display them in the UI.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Menu With Radio Button");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Radio Button Menu Items
     * - JRadioButtonMenuItem represents a menu item that allows mutually exclusive selection within a group.
     * - Only one item in a ButtonGroup can be selected at a time, enforcing exclusive choices.
     * - The constructor can accept a boolean value to set the initial selected state.
     */
    JRadioButtonMenuItem menuItem1 = new JRadioButtonMenuItem("English", true); // Pre Selected
    JRadioButtonMenuItem menuItem2 = new JRadioButtonMenuItem("Portuguese");
    JRadioButtonMenuItem menuItem3 = new JRadioButtonMenuItem("Spanish");

    /*
     * Group
     * - Creates a ButtonGroup to manage a set of JRadioButtonMenuItem instances.
     * - Ensures that only one menu item in the group can be selected at a time.
     * - The group itself is not a visual component; it only controls selection logic.
     */
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(menuItem1);
    buttonGroup.add(menuItem2);
    buttonGroup.add(menuItem3);

    /*
     * Set Icons
     * - Assigns graphical icons to JCheckBoxMenuItem instances to improve visual recognition and usability.
     * - Icons are displayed to the left of the menu item text, following the current Look and Feel.
     */
    menuItem1.setIcon(new ImageIcon(this.getClass().getResource("gui/world.png")));
    menuItem2.setIcon(new ImageIcon(this.getClass().getResource("gui/world.png")));
    menuItem3.setIcon(new ImageIcon(this.getClass().getResource("gui/world.png")));

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
    JMenu fileMenu = new JMenu("Language");
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