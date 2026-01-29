/*
 * Text Field (JTextField)
 * - This section explains the JTextField component in Swing, which represents a single-line text input field used to
 *   collect short textual data from the user.
 *
 * Overview
 * - JTextField is part of the javax.swing package.
 * - It extends JTextComponent and provides editable single-line text input.
 * - It is commonly used in forms, dialogs, and toolbars.
 *
 * Key Characteristics
 * - Accepts and displays a single line of text.
 * - Supports text editing, selection, copy/paste, and caret navigation.
 * - Uses a Document model internally to store and manage text content.
 * - Integrates with the current Look and Feel for consistent rendering.
 * - Fully supports keyboard input, focus handling, and accessibility.
 *
 * Dimension Control
 * - setColumns(int): defines the preferred width of the text area in terms of character columns.
 *
 * Usage
 * - Use JTextField to collect short user input such as names, values, or search terms.
 * - For multi-line input, prefer JTextArea instead.
 * - Commonly combined with labels (JLabel) to describe the expected input.
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
    JFrame frame = new JFrame("Text Field");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Text Field
     * - Demonstrates a basic JTextField with no initial text.
     * - The number of visible columns is defined using setColumns().
     * - Columns do not limit input length; they only affect the preferred width.
     * - A tooltip is added to provide contextual help to the user.
     */
    JTextField textField1 = new JTextField();
    textField1.setColumns(20);
    textField1.setToolTipText("This is a tooltip!");
    frame.add(textField1);

    /*
     * Text Field With Content
     * - Demonstrates a JTextField initialized with content.
     * - Text can be set programmatically using setText().
     * - Alternatively, constructors can be used to define initial text and column size.
     */
    JTextField textField2 = new JTextField();
    textField2.setColumns(20);
    textField2.setText("Hello World!");
    frame.add(textField2);

    /*
     * Disabled Text Field
     * - Demonstrates a JTextField in a disabled state.
     * - Disabled text fields are visible but cannot receive focus or user input.
     * - Commonly used to display read-only or unavailable data.
     * - The enabled state is controlled using the setEnabled() method.
     */
    JTextField textField3 = new JTextField();
    textField3.setColumns(20);
    textField3.setEnabled(false);
    textField3.setText("Hello World!");
    frame.add(textField3);

    /*
     * Document Listener
     * - Demonstrates how to listen for text changes in a JTextField using its Document model.
     * - The Document represents the underlying text content of the component.
     * - A DocumentListener is triggered whenever the text is inserted or removed.
     * - The current text can be safely retrieved using getText() on the JTextField.
     * - This approach captures all changes, including typing, deletion, and paste operations.
     */
    textField1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            IO.println(textField1.getText()); // Output: <text field content>
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            IO.println(textField1.getText()); // Output: <text field content>
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not supported for JTextField
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
