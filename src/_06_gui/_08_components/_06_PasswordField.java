/*
 * Password Field (JPasswordField)
 * - This section explains the JPasswordField component in Swing, which represents a single-line text input field
 *   specifically designed for handling sensitive information such as passwords.
 *
 * Overview
 * - JPasswordField is part of the javax.swing package.
 * - It extends JTextField and inherits most of its behavior.
 * - The primary difference is that entered characters are masked for privacy.
 *
 * Key Characteristics
 * - Accepts a single line of text with masked character display.
 * - Uses an internal Document model to store the password content.
 * - Supports standard text editing operations such as insertion and deletion.
 * - Integrates with the current Look and Feel for consistent masking behavior.
 * - Designed to reduce accidental exposure of sensitive input.
 *
 * Dimension Control
 * - setColumns(int): defines the preferred width of the text area in terms of character columns.
 *
 * Usage
 * - Use JPasswordField for passwords, PINs, or other confidential input.
 * - Prefer getPassword() over getText() to retrieve content securely.
 * - Clear password data from memory as soon as it is no longer needed.
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
    JFrame frame = new JFrame("Password Field");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Password Field
     * - Demonstrates a basic JPasswordField with no initial content.
     * - The number of visible columns is defined using setColumns().
     * - Characters typed by the user are masked to protect sensitive data.
     * - A tooltip is added to provide contextual guidance to the user.
     */
    JPasswordField passwordField1 = new JPasswordField();
    passwordField1.setColumns(20);
    passwordField1.setToolTipText("This is a tooltip!");
    frame.add(passwordField1);

    /*
     * Password Field With Content
     * - Demonstrates a JPasswordField initialized with predefined content.
     * - Text can be set programmatically using setText().
     * - This is typically used for demos or testing, not for real password handling.
     */
    JPasswordField passwordField2 = new JPasswordField();
    passwordField2.setColumns(20);
    passwordField2.setText("Secret Password");
    frame.add(passwordField2);

    /*
     * Disabled Password Field
     * - Demonstrates a JPasswordField in a disabled state.
     * - Disabled fields are visible but do not accept focus or user input.
     * - Commonly used to display unavailable or read-only credential fields.
     */
    JPasswordField passwordField3 = new JPasswordField();
    passwordField3.setColumns(20);
    passwordField3.setText("Secret Password");
    passwordField3.setEnabled(false);
    frame.add(passwordField3);

    /*
     * Document Listener
     * - Demonstrates how to observe changes to the password field using its Document model.
     * - Insert and remove events are triggered whenever the content changes.
     * - This captures all modifications, including typing, deletion, and paste operations.
     * - Accessing the text directly is possible but not recommended for sensitive data.
     */
    passwordField1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            IO.println(passwordField1.getText()); // Output: <password field content>
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            IO.println(passwordField1.getText()); // Output: <password field content>
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not supported for JPasswordField
        }
    });

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
