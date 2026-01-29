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
     */
    JRadioButton radioButton1 = new JRadioButton("Radio");
    frame.add(radioButton1);

    /*
     * Selected Radio Button
     * - Demonstrates a basic JRadioButton pre-selected.
     * - The selection state can be queried or modified using isSelected() and setSelected().
     */
    JRadioButton radioButton2 = new JRadioButton("Selected");
    radioButton2.setSelected(true);
    frame.add(radioButton2);

    /*
     * Disabled Radio Button
     * - Demonstrates a JRadioButton in a disabled state.
     * - Disabled radio buttons are visible but cannot be selected by the user.
     * - Commonly used to indicate unavailable options.
     * - The enabled state is controlled via the setEnabled() method.
     */
    JRadioButton radioButton3 = new JRadioButton("Disabled");
    radioButton3.setEnabled(false);
    frame.add(radioButton3);

    /*
     * Radio Button On Right
     * - Demonstrates customization of text positioning relative to the radio button icon.
     * - Vertical and horizontal alignment are controlled using setVerticalTextPosition() and
     *   setHorizontalTextPosition().
     */
    JRadioButton radioButton4 = new JRadioButton("Right");
    radioButton4.setHorizontalTextPosition(JCheckBox.LEFT);
    frame.add(radioButton4);

    /*
     * Radio Button On Top
     * - Demonstrates vertical alignment between the radio button icon and its text.
     * - The text is displayed below the icon.
     */
    JRadioButton radioButton5 = new JRadioButton("Top");
    radioButton5.setVerticalTextPosition(JCheckBox.BOTTOM);
    radioButton5.setHorizontalTextPosition(JButton.CENTER);
    frame.add(radioButton5);

    /*
     * Radio Button On Bottom
     * - Demonstrates vertical alignment between the radio button icon and its text.
     * - The text is displayed on top the icon.
     */
    JRadioButton radioButton6 = new JRadioButton("Bottom");
    radioButton6.setVerticalTextPosition(JCheckBox.TOP);
    radioButton6.setHorizontalTextPosition(JButton.CENTER);
    frame.add(radioButton6);

    /*
     * Button Group
     * - Groups multiple JRadioButton instances to enforce mutual exclusivity.
     * - Only one radio button in the group can be selected at a time.
     * - ButtonGroup itself is not a visual component.
     */
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(radioButton1);
    buttonGroup.add(radioButton2);
    buttonGroup.add(radioButton3);
    buttonGroup.add(radioButton4);
    buttonGroup.add(radioButton5);
    buttonGroup.add(radioButton6);

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