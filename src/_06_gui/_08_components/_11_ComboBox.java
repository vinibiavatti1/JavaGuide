/*
 * Combo Box (JComboBox)
 * - This section explains the JComboBox component in Swing, which represents a drop-down list used to select a single
 *   item from a predefined set of options.
 *
 * Overview
 * - JComboBox is part of the javax.swing package.
 * - It extends JComponent and implements ItemSelectable.
 * - Allows selection of one item at a time from a list.
 *
 * Key Characteristics
 * - Supports non-editable and editable modes.
 * - Maintains the currently selected item internally.
 * - Can display text, custom renderers, or complex objects.
 * - Integrates with the current Look and Feel for consistent appearance.
 * - Fully supports keyboard navigation and accessibility.
 *
 * Usage
 * - Use JComboBox when only one option should be selected from a list.
 * - Commonly used in settings screens, preference dialogs, and form inputs.
 * - Prefer combo boxes over lists when screen space is limited.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Combo Box");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Combo Box Data
     * - Defines the data model used by the JComboBox.
     * - In this example, a simple String array is used as the data source.
     * - Internally, the array is wrapped by a ComboBoxModel implementation.
     * - Suitable for static or fixed sets of options.
     */
    String[] items = new String[] { "Default", "Light", "Dark" };

    /*
     * Combo Box
     * - Demonstrates a basic JComboBox populated with predefined items.
     * - Displays a drop-down list that allows the user to select a single option.
     * - Uses a ComboBoxModel internally to manage its elements.
     * - The tooltip text is set using the setToolTipText() method.
     */
    JComboBox<String> comboBox1 = new JComboBox<>(items);
    comboBox1.setToolTipText("This is a tooltip!");
    frame.add(comboBox1);

    /*
     * Combo Box With Preselected Value
     * - Demonstrates a JComboBox with an item selected by default.
     * - The selection can be defined using setSelectedItem().
     */
    JComboBox<String> comboBox2 = new JComboBox<>(items);
    comboBox2.setSelectedItem("Light");
    frame.add(comboBox2);

    /*
     * Editable Combo Box
     * - Demonstrates an editable JComboBox.
     * - Allows the user to type a custom value in addition to selecting predefined items.
     * - Commonly used for inputs with suggestions or auto-complete behavior.
     */
    JComboBox<String> comboBox3 = new JComboBox<>(items);
    comboBox3.setEditable(true);
    frame.add(comboBox3);

    /*
     * Disabled Combo Box
     * - Demonstrates a JComboBox in a disabled state.
     * - Disabled combo boxes are visible but cannot be interacted with.
     * - Commonly used to indicate unavailable options based on application state.
     */
    JComboBox<String> comboBox4 = new JComboBox<>(items);
    comboBox4.setEnabled(false);
    frame.add(comboBox4);

    /*
     * Combo Box Listener
     * - Demonstrates adding an ActionListener to a JComboBox.
     * - The listener is triggered when the selected item changes.
     * - The currently selected item is retrieved using getSelectedItem().
     * - Output: <item>
     */
    comboBox1.addActionListener(evt -> IO.println(comboBox1.getSelectedItem()));

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
