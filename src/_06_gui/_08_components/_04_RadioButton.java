/*
 * Radio Button (JRadioButton)
 * - This section explains the JRadioButton component in Swing, which represents a selectable option used when only one
 *   choice should be selected within a defined group.
 *
 * Overview
 * - JRadioButton is part of the javax.swing package.
 * - It extends AbstractButton and represents a mutually exclusive selection control.
 * - Radio buttons are typically used together with ButtonGroup to enforce exclusivity.
 *
 * Key Characteristics
 * - Supports two states: selected and deselected.
 * - By itself, a JRadioButton behaves like an independent toggle.
 * - Mutual exclusivity is achieved by placing multiple radio buttons in a ButtonGroup.
 * - Can display text, an icon, or both.
 * - Integrates with the current Look and Feel and supports keyboard navigation.
 *
 * Usage
 * - Use JRadioButton when the user must choose exactly one option from a small set.
 * - Commonly used in preference dialogs, configuration screens, and option panels.
 * - Always group related radio buttons using ButtonGroup.
 * - Avoid using radio buttons for independent or multiple selections; use checkboxes instead.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Radio Button");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Radio Button
     * - Demonstrates a basic JRadioButton configured with a text label.
     * - By default, the radio button starts in an unselected state.
     * - Selection state can be queried or modified using isSelected() and setSelected().
     */
    JRadioButton radioButton = new JRadioButton("Option 1");
    frame.add(radioButton);

    /*
     * Disabled Radio Button
     * - Demonstrates a JRadioButton in a disabled state.
     * - Disabled radio buttons are visible but cannot be selected by the user.
     * - Commonly used to indicate unavailable options.
     * - The enabled state is controlled via the setEnabled() method.
     */
    JRadioButton disabledRadioButton = new JRadioButton("Disabled");
    disabledRadioButton.setEnabled(false);
    frame.add(disabledRadioButton);

    /*
     * Radio Button With Text On Right (Selected)
     * - Demonstrates customization of text positioning relative to the radio button icon.
     * - The text is placed to the left of the icon using setHorizontalTextPosition().
     * - The radio button is pre-selected using the setSelected() method.
     */
    JRadioButton radioButtonOnRight = new JRadioButton("Check");
    radioButtonOnRight.setHorizontalTextPosition(JCheckBox.LEFT);
    radioButtonOnRight.setSelected(true);
    frame.add(radioButtonOnRight);

    /*
     * Radio Button With Text On Top
     * - Demonstrates vertical alignment between the radio button icon and its text.
     * - The text is displayed below the icon.
     * - Vertical and horizontal alignment are controlled using setVerticalTextPosition() and
     *   setHorizontalTextPosition().
     */
    JRadioButton radioButtonOnTop = new JRadioButton("Check");
    radioButtonOnTop.setVerticalTextPosition(JCheckBox.BOTTOM);
    radioButtonOnTop.setHorizontalTextPosition(JButton.CENTER);
    frame.add(radioButtonOnTop);

    /*
     * Radio Button With Tooltip
     * - Demonstrates a JRadioButton configured with a tooltip message.
     * - Tooltips provide contextual help when the user hovers over the component.
     * - The tooltip text is set using the setToolTipText() method.
     */
    JRadioButton radioButtonTooltip = new JRadioButton("Tooltip");
    radioButtonTooltip.setToolTipText("This is a tooltip!");
    frame.add(radioButtonTooltip);

    /*
     * Button Group
     * - Groups multiple JRadioButton instances to enforce mutual exclusivity.
     * - Only one radio button in the group can be selected at a time.
     * - ButtonGroup itself is not a visual component.
     */
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(radioButton);
    buttonGroup.add(disabledRadioButton);
    buttonGroup.add(radioButtonOnRight);
    buttonGroup.add(radioButtonOnTop);
    buttonGroup.add(radioButtonTooltip);

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