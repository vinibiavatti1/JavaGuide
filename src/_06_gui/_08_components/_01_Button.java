/*
 * Button (JButton)
 * - This section explains the JButton component in Swing, which represents a push button used to trigger actions in
 *   response to user interaction.
 *
 * Overview
 * - JButton is part of the javax.swing package.
 * - It extends AbstractButton and provides a clickable command component.
 * - It can display text, an icon, or both.
 *
 * Key Characteristics
 * - Represents a stateless action trigger (does not maintain selection state).
 * - Integrates seamlessly with the current Look and Feel.
 * - Supports keyboard interaction, mnemonics, and accessibility features.
 * - Can be reused across contexts when paired with an Action.
 *
 * Action Events
 * - JButton fires an ActionEvent when the user clicks the button, presses Enter while focused, or activates it via
 *   keyboard or programmatically.
 * - Click handling is typically done by registering an ActionListener with the "addActionListener()" method.
 * - Lambda expressions are commonly used for concise event handling.
 * - Example: addActionListener(evt -> ...);
 *
 * Usage
 * - Use JButton to perform discrete actions such as submit, save, open, or confirm.
 * - Commonly placed inside panels, dialogs, toolbars, and forms.
 * - Labels should be concise and action-oriented to clearly indicate behavior.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Button");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Button
     * - Demonstrates a basic JButton configured with a text label.
     * - An ActionListener is registered to handle click events with "addActionListener()" method.
     * - When activated, the button triggers a simple feedback dialog.
     * - The tooltip text is set using the "setToolTipText()" method.
     */
    JButton button1 = new JButton("Click");
    button1.setToolTipText("This is a tooltip!");
    button1.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Clicked!"));
    frame.add(button1);

    /*
     * Disabled Button
     * - Demonstrates a JButton in a disabled state.
     * - Disabled buttons are visible but cannot receive focus or user interaction.
     * - Commonly used to indicate unavailable actions based on application state.
     * - The method "setEnabled()" can be used to enable/disable buttons.
     */
    JButton button2 = new JButton("Disabled");
    button2.setEnabled(false);
    frame.add(button2);

    /*
     * Button With Icon
     * - Demonstrates a JButton displaying only an icon, without text.
     * - Icon-based buttons are often used in toolbars or compact UIs.
     * - The "setIcon" method can be used to set an icon to a JButton.
     */
    JButton button3 = new JButton();
    button3.setIcon(new ImageIcon(this.getClass().getResource("/gui/add.png")));
    button3.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Clicked!"));
    frame.add(button3);

    /*
     * Button With Icon On Left
     * - Demonstrates a JButton combining text and an icon.
     * - By default, the icon is placed to the left of the text.
     */
    JButton button4 = new JButton("Click");
    button4.setIcon(new ImageIcon(this.getClass().getResource("/gui/add.png")));
    button4.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Clicked!"));
    frame.add(button4);

    /*
     * Button With Icon On Right
     * - Demonstrates custom positioning of text relative to the icon.
     * - The relative positioning of text and icon can be customized using: setHorizontalTextPosition() and
     *   setVerticalTextPosition().
     */
    JButton button5 = new JButton("Click");
    button5.setIcon(new ImageIcon(this.getClass().getResource("/gui/add.png")));
    button5.setHorizontalTextPosition(JButton.LEFT);
    button5.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Clicked!"));
    frame.add(button5);

    /*
     * Button With Icon On Top
     * - Demonstrates vertical alignment between icon and text.
     * - The icon is displayed above the text using vertical and horizontal text position setters.
     */
    JButton button6 = new JButton("Click");
    button6.setIcon(new ImageIcon(this.getClass().getResource("/gui/add.png")));
    button6.setVerticalTextPosition(JButton.BOTTOM);
    button6.setHorizontalTextPosition(JButton.CENTER);
    button6.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Clicked!"));
    frame.add(button6);

    /*
     * Button With Icon On Bottom
     * - Demonstrates the inverse vertical layout, with text above the icon.
     * - Achieved by adjusting the vertical and horizontal text positions.
     */
    JButton button7 = new JButton("Click");
    button7.setIcon(new ImageIcon(this.getClass().getResource("/gui/add.png")));
    button7.setVerticalTextPosition(JButton.TOP);
    button7.setHorizontalTextPosition(JButton.CENTER);
    button7.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Clicked!"));
    frame.add(button7);

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