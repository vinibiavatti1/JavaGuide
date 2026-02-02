/*
 * List (JList)
 * - This section explains the JList component in Swing, which represents a list-based component used to display and
 *   select one or more items from a collection.
 *
 * Overview
 * - JList is part of the javax.swing package.
 * - It extends JComponent and displays items in a scrollable list format.
 * - Typically wrapped in a JScrollPane to handle large data sets.
 *
 * Key Characteristics
 * - Supports single and multiple selection modes.
 * - Can be displayed vertically or wrapped horizontally.
 * - Uses a ListModel internally to manage its data.
 * - Fully integrates with the current Look and Feel for consistent rendering.
 * - Supports keyboard navigation, focus, and accessibility.
 *
 * Usage
 * - Use JList when displaying multiple selectable items.
 * - Ideal for option lists, data browsers, and selection panels.
 * - Prefer JList over JComboBox when multiple visible options are required.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("List");
    frame.setSize(700, 200);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Vertical List (Default)
     * - Demonstrates a standard vertical JList.
     * - Items are displayed in a single column.
     * - Wrapped in a JScrollPane to allow scrolling when content exceeds visible area.
     * - A tooltip is added to provide contextual help.
     */
    String[] items = new String[] { "Java", "C#", "C++", "C", "Python", "Javascript", "Typescript", "PHP", "Ruby" };
    JList<String> list1 = new JList<>(items);
    JScrollPane scrollPane1 = new JScrollPane(
            list1,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    list1.setToolTipText("This is a tooltip!");
    frame.add(scrollPane1);

    /*
     * Vertical Wrap List
     * - Demonstrates a JList with vertical wrapping enabled.
     * - Items flow into multiple columns when vertical space is exceeded.
     * - Useful for displaying compact lists with limited height.
     */
    JList<String> list2 = new JList<>(items);
    JScrollPane scrollPane2 = new JScrollPane(
            list2,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    list2.setLayoutOrientation(JList.VERTICAL_WRAP);
    frame.add(scrollPane2);

    /*
     * Horizontal Wrap List
     * - Demonstrates a JList with horizontal wrapping enabled.
     * - Items are laid out left-to-right and wrap to the next row.
     * - Useful for grid-like visual presentation of items.
     */
    JList<String> list3 = new JList<>(items);
    JScrollPane scrollPane3 = new JScrollPane(
            list3,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    list3.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    frame.add(scrollPane3);

    /*
     * List With Single Selection
     * - Demonstrates a JList restricted to selecting only one item at a time.
     * - This is the default selection mode for JList.
     * - Controlled using setSelectionMode(SINGLE_SELECTION).
     */
    JList<String> list4 = new JList<>(items);
    JScrollPane scrollPane4 = new JScrollPane(
            list4,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    frame.add(scrollPane4);

    /*
     * List With Single Interval Selection
     * - Demonstrates a JList allowing selection of a contiguous range of items.
     * - The user can select a continuous block using Shift + click.
     */
    JList<String> list5 = new JList<>(items);
    JScrollPane scrollPane5 = new JScrollPane(
            list5,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    list5.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    frame.add(scrollPane5);

    /*
     * Disabled List
     * - Demonstrates a JList in a disabled state.
     * - Disabled lists are visible but do not allow user interaction.
     * - Commonly used to indicate unavailable options.
     */
    JList<String> list6 = new JList<>(items);
    JScrollPane scrollPane6 = new JScrollPane(
            list6,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    list6.setEnabled(false);
    frame.add(scrollPane6);

    /*
     * List Listener
     * - Demonstrates adding a ListSelectionListener to a JList.
     * - The listener is triggered whenever the selection changes.
     * - The currently selected item can be retrieved using getSelectedValue().
     * - Output: <item>
     */
    list1.addListSelectionListener(evt -> IO.println(list1.getSelectedValue()));

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
