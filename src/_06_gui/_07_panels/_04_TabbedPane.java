/*
 * JTabbedPane
 * - This section explains the JTabbedPane component in Swing, which provides a tabbed container allowing multiple
 *   components to share the same display area, organized by selectable tabs.
 *
 * Overview
 * - JTabbedPane is part of the javax.swing package.
 * - It extends JComponent and manages a set of tabs, each associated with a component.
 * - Only one tab is visible at a time, while others remain accessible via their tab headers.
 * - Commonly used to organize related content into logical sections within the same window.
 *
 * Key Characteristics
 * - Supports dynamic addition, removal, and reordering of tabs.
 * - Each tab can contain any Component, such as JPanel, JScrollPane, JSplitPane, or custom components.
 * - Tabs can display text, icons, tooltips, or a combination of these.
 * - Integrates with the current Look and Feel for consistent appearance and behavior.
 * - Supports keyboard navigation for accessibility.
 * - To add a tab, use the "addTab()" method.
 *
 * Tab Positions
 * - JTabbedPane.TOP: Tabs are displayed at the top of the content area (default).
 * - JTabbedPane.BOTTOM: Tabs are displayed at the bottom of the content area.
 * - JTabbedPane.LEFT: Tabs are displayed vertically on the left side.
 * - JTabbedPane.RIGHT: Tabs are displayed vertically on the right side.
 *
 * Usage
 * - Use JTabbedPane to group related views or workflows in a single container.
 * - Ideal for settings dialogs, editors, dashboards, or multi-view interfaces.
 * - Prefer clear and concise tab labels to improve usability.
 * - Combine with icons and tooltips to enhance clarity without overcrowding the UI.
 * - Tabs can be added or removed dynamically based on application state or user permissions.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Tabbed Pane");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Panels
     * - The following JPanel instances are created to serve as the content of individual tabs.
     * - Each panel represents a separate tab in a JTabbedPane.
     * - Simple components are added to clearly identify and demonstrate each tab.
     */
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    panel1.add(new JLabel("Panel 1"));
    panel2.add(new JLabel("Panel 2"));
    panel3.add(new JLabel("Panel 3"));

    /*
     * Tabbed Pane
     * - Creates a JTabbedPane to display multiple components using selectable tabs.
     * - The constructor allows defining:
     *   - The tab name
     *   - The tab icon
     *   - The tab component
     *   - The tab hint
     * - Tabs are positioned at the top using the JTabbedPane.TOP constant.
     * - Each tab is added with a title, an icon, and an associated component.
     * - Internally, JTabbedPane uses a SingleSelectionModel to manage the selected tab.
     * - Accessing the model allows programmatic control over tab selection.
     * - In this example, setSelectedIndex(1) selects the second tab by default.
     */
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.addTab("Tab 1", new ImageIcon(this.getClass().getResource("/gui/application.png")), panel1, "Hint");
    tabbedPane.addTab("Tab 2", new ImageIcon(this.getClass().getResource("/gui/application.png")), panel2, "Hint");
    tabbedPane.addTab("Tab 3", new ImageIcon(this.getClass().getResource("/gui/application.png")), panel3, "Hint");
    tabbedPane.getModel().setSelectedIndex(1);
    frame.add(tabbedPane);

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