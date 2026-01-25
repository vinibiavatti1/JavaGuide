/*
 * Nested Menus
 * - This section explains the concept of nested menus in Swing, which are JMenu instances placed inside another JMenu
 *   to create hierarchical or multi-level menus.
 *
 * Overview
 * - Nested menus allow organizing related commands under subcategories within a main menu.
 * - Each nested JMenu can contain JMenuItem instances, separators, and even additional nested menus.
 * - Provides a clean and structured way to handle complex menus with many actions.
 * - Fully integrates with keyboard mnemonics, accelerators, and the Look and Feel system.
 *
 * Key Characteristics
 * - Supports multi-level hierarchy, allowing submenus within submenus.
 * - Nested menus are visually indicated with an arrow or similar cue in most Look and Feels.
 * - Submenus inherit behavior from JMenu, including action handling and visual styling.
 * - Improves usability and reduces clutter by grouping related menu items logically.
 * - Can be dynamically updated at runtime if needed, e.g., adding/removing items based on context.
 *
 * Usage
 * - Use nested menus to categorize commands that belong together but would overwhelm a single menu.
 * - Ideal for "New" actions (New > Project, New > File), "Preferences" (Preferences > Theme, Preferences > Shortcuts),
 *   or "Reports".
 * - Ensure that the hierarchy is intuitive to prevent confusing the user.
 * - Combine with separators and icons to improve clarity and navigation.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Nested Menus");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Menu Items
     * - JMenuItem represents a basic, clickable option inside a JMenu or JPopupMenu.
     * - Each menu item typically triggers a specific action when selected by the user.
     */
    JMenuItem menuItem1 = new JMenuItem("PNG");
    JMenuItem menuItem2 = new JMenuItem("JPEG");
    JMenuItem menuItem3 = new JMenuItem("DOC");
    JMenuItem menuItem4 = new JMenuItem("PDF");

    /*
     * Set Icons
     * - Assigns graphical icons to JMenuItem instances to improve visual recognition and usability.
     * - Icons are displayed to the left of the menu item text, following the current Look and Feel.
     */
    menuItem1.setIcon(new ImageIcon(this.getClass().getResource("gui/page_white_go.png")));
    menuItem2.setIcon(new ImageIcon(this.getClass().getResource("gui/page_white_go.png")));
    menuItem3.setIcon(new ImageIcon(this.getClass().getResource("gui/page_white_go.png")));
    menuItem4.setIcon(new ImageIcon(this.getClass().getResource("gui/page_white_go.png")));

    /*
     * Set Accelerators (Shortcuts)
     * - Defines keyboard shortcuts that trigger the menu item action regardless of menu focus.
     * - Accelerators are typically displayed next to the menu item text in the menu UI.
     * - Uses KeyStroke to describe key combinations in a platform-independent way.
     */
    menuItem1.setAccelerator(KeyStroke.getKeyStroke("control 1"));
    menuItem2.setAccelerator(KeyStroke.getKeyStroke("control 2"));
    menuItem3.setAccelerator(KeyStroke.getKeyStroke("control 3"));
    menuItem4.setAccelerator(KeyStroke.getKeyStroke("control 4"));

    /*
     * Set Actions
     * - Attaches ActionListener implementations to menu items to define their behavior when selected.
     * - Each listener is triggered by user interaction, such as a mouse click or keyboard accelerator.
     * - Lambda expressions provide a concise way to define action handling logic.
     */
    menuItem1.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "PNG"));
    menuItem2.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "JPEG"));
    menuItem3.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "DOC"));
    menuItem4.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "PDF"));

    /*
     * Menus
     * - Creates a JMenu that represents a top-level menu category.
     * - Menu items are added in sequence to define their visual order.
     * - Separators are used to logically group related actions.
     */
    JMenu menu1 = new JMenu("File");
    JMenu menu2 = new JMenu("Export");
    JMenu menu3 = new JMenu("Image Format");
    JMenu menu4 = new JMenu("Text Format");
    menu1.add(menu2);
    menu2.add(menu3);
    menu2.add(menu4);
    menu3.add(menuItem1);
    menu3.add(menuItem2);
    menu4.add(menuItem3);
    menu4.add(menuItem4);


    /*
     * Menu Bar
     * - Creates a JMenuBar to serve as the main menu container for the window.
     * - Integrated with the JFrame to appear in the standard menu area.
     */
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu1);
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