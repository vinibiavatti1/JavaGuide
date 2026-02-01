/*
 * Check Box (JCheckBox)
 * - This section explains the JCheckBox component in Swing, which represents a selectable option used to enable or
 *   disable features or settings independently.
 *
 * Overview
 * - JCheckBox is part of the javax.swing package.
 * - It extends AbstractButton and represents a binary selection control.
 * - Each checkbox operates independently and does not require grouping.
 *
 * Key Characteristics
 * - Supports two states by default: selected and deselected.
 * - Maintains its own selection state via an internal ButtonModel.
 * - Can display text, an icon, or both.
 * - Integrates with the current Look and Feel for consistent appearance.
 * - Fully supports keyboard navigation, focus, and accessibility.
 *
 * Usage
 * - Use JCheckBox when multiple options can be selected independently.
 * - Commonly used in settings screens, preference dialogs, and configuration panels.
 * - Ideal for boolean-style options such as enable/disable or show/hide.
 * - Avoid using checkboxes for mutually exclusive choices; use radio buttons instead.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Check Box");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Check Box
     * - Demonstrates a basic JCheckBox configured with a text label.
     * - Represents an independent on/off option that the user can toggle.
     * - The tooltip text is set using the setToolTipText() method.
     */
    JCheckBox checkBox1 = new JCheckBox("Check");
    checkBox1.setToolTipText("This is a tooltip!");
    frame.add(checkBox1);

    /*
     * Selected Check Box
     * - Demonstrates a basic JCheckBox pre-selected.
     * - The selection state can be queried or modified using isSelected() and setSelected().
     */
    JCheckBox checkBox2 = new JCheckBox("Selected");
    checkBox2.setSelected(true);
    frame.add(checkBox2);

    /*
     * Disabled Check Box
     * - Demonstrates a JCheckBox in a disabled state.
     * - Disabled checkboxes are visible but cannot be interacted with.
     * - Commonly used to indicate options that are not available due to application state.
     * - The enabled state is controlled via the setEnabled() method.
     */
    JCheckBox checkBox3 = new JCheckBox("Disabled");
    checkBox3.setEnabled(false);
    frame.add(checkBox3);

    /*
     * Check Box On Right
     * - Demonstrates customization of text positioning relative to the checkbox icon.
     * - By default, the text appears to the right of the checkbox.
     * - The horizontal text position can be adjusted using setHorizontalTextPosition().
     */
    JCheckBox checkBox4 = new JCheckBox("Right");
    checkBox4.setHorizontalTextPosition(JCheckBox.LEFT);
    frame.add(checkBox4);

    /*
     * Check Box On Top
     * - Demonstrates vertical alignment between the checkbox icon and its text.
     * - The text is displayed below the checkbox icon.
     * - Vertical and horizontal alignment are controlled using setVerticalTextPosition() and
     *   setHorizontalTextPosition().
     */
    JCheckBox checkBox5 = new JCheckBox("Top");
    checkBox5.setVerticalTextPosition(JCheckBox.BOTTOM);
    checkBox5.setHorizontalTextPosition(JButton.CENTER);
    frame.add(checkBox5);

    /*
     * Check Box On Bottom
     * - Demonstrates vertical alignment between the checkbox icon and its text.
     * - The text is displayed below the checkbox icon.
     * - Vertical and horizontal alignment are controlled using setVerticalTextPosition() and
     *   setHorizontalTextPosition().
     */
    JCheckBox checkBox6 = new JCheckBox("Bottom");
    checkBox6.setVerticalTextPosition(JCheckBox.TOP);
    checkBox6.setHorizontalTextPosition(JButton.CENTER);
    frame.add(checkBox6);

    /*
     * Check Box Listener
     * - Demonstrates adding an ActionListener to a JCheckBox.
     * - The listener is triggered whenever the selection state changes.
     * - The current state (selected or not) is retrieved using isSelected().
     * - Commonly used to react to user interactions such as enabling or disabling features.
     * - Output: true / false
     */
    checkBox1.addActionListener(evt -> IO.println(checkBox1.isSelected()));

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