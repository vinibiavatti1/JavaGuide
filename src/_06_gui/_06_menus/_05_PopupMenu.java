/*
 * Popup Menu (JPopupMenu)
 * - This section explains the JPopupMenu component in Swing, which represents a context-sensitive or floating menu
 *   that can appear anywhere in the UI, typically in response to a right-click or specific user action.
 *
 * Overview
 * - JPopupMenu is part of the javax.swing package.
 * - It extends JComponent and can contain JMenuItem, JCheckBoxMenuItem, JRadioButtonMenuItem, JMenu (nested menus), and
 *   JSeparator.
 * - Unlike JMenuBar menus, JPopupMenu is not tied to the top of a window and can appear over other components.
 *
 * Key Characteristics
 * - Can be shown programmatically at specific screen coordinates using show(Component invoker, int x, int y).
 * - Supports all menu item types, including nested menus and separators.
 * - Fully integrates with keyboard mnemonics and accelerators where applicable.
 * - Lightweight and double-buffered for smooth rendering.
 * - Useful for context menus, tool-specific options, and temporary action menus.
 *
 * Usage
 * - Use JPopupMenu for context-sensitive actions triggered by mouse events or other user interactions.
 * - Ideal for right-click menus on tables, text components, trees, or custom UI elements.
 * - Populate with JMenuItem, JCheckBoxMenuItem, JRadioButtonMenuItem, and separators to organize actions.
 * - Can be dynamically updated to reflect the current state of the application.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Popup Menu");
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
     * Popup Menu
     * - Unlike JMenuBar menus, it is not tied to the top of a window and can be triggered by mouse events or
     *   programmatically.
     * - Can contain JMenuItem, JCheckBoxMenuItem, JRadioButtonMenuItem, nested JMenu, and JSeparator instances.
     * - Useful for providing contextual actions such as right-click menus on components.
     */
    JPopupMenu popupMenu = new JPopupMenu("File");
    popupMenu.add(menuItem1);
    popupMenu.add(menuItem2);
    popupMenu.add(menuItem3);
    popupMenu.addSeparator();
    popupMenu.add(menuItem4);

    /*
     * Menu Button
     * - Demonstrates attaching a JPopupMenu to a JButton to create a clickable menu button.
     * - When the button is pressed, the popup menu is displayed at the specified coordinates relative to the button.
     */
    JButton button = new JButton("Menu");
    button.addActionListener(evt -> popupMenu.show(button, 0, 0));
    JPanel panel = new JPanel();
    panel.add(button);
    frame.add(panel);

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