/*
 * Formatted Text Field (JFormattedTextField)
 * - This section explains the JFormattedTextField component in Swing, which represents a single-line text input field
 *   with built-in support for formatting user input.
 *
 * Overview
 * - JFormattedTextField is part of the javax.swing package.
 * - It extends JTextField and provides formatting capabilities via java.text.Format or MaskFormatter.
 * - Commonly used for numeric, currency, date, and other constrained inputs.
 *
 * Key Characteristics
 * - Supports input formatting and validation.
 * - Uses a Document model internally to store and manage text content.
 * - Can be configured with built-in formats (NumberFormat, DateFormat) or custom masks (MaskFormatter).
 * - Integrates with the current Look and Feel for consistent rendering.
 * - Fully supports keyboard input, focus handling, and accessibility.
 *
 * Common Formats
 * - Number: NumberFormat.getNumberInstance(), NumberFormat.getIntegerInstance()
 * - Currency: NumberFormat.getCurrencyInstance()
 * - Percent: NumberFormat.getPercentInstance()
 * - Date: DateFormat.getDateInstance(), DateFormat.getDateTimeInstance(), SimpleDateFormat
 *
 * MaskFormatter Symbols
 * - #: Digit (0-9)
 * - U: Uppercase letter (A-Z)
 * - L: Lowercase letter (a-z)
 * - A: Letter or digit (A-Z, a-z, 0-9)
 * - ?: Letter (A-Z, a-z)
 * - *: Any character
 * - H: Hex digit (0-9, A-F)
 * - ': Escape character
 *
 * Usage
 * - Use JFormattedTextField when input must conform to a specific format, such as numbers, dates, currency, or custom
 *   patterns.
 * - Useful in forms, dialogs, and configuration panels.
 * - For unconstrained input, JTextField is preferred.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

void example() throws ParseException {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Formatted Text Field");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Formatted Text Field
     * - Demonstrates a basic JFormattedTextField with no specific format applied.
     * - The number of visible columns is defined using setColumns().
     * - Columns do not limit input length; they only affect the preferred width.
     * - A tooltip is added to provide contextual help to the user.
     */
    JFormattedTextField formattedTextField = new JFormattedTextField();
    formattedTextField.setColumns(20);
    formattedTextField.setToolTipText("This is a tooltip!");
    frame.add(formattedTextField);

    /*
     * Formatted Text Field With Number Format
     * - Demonstrates a JFormattedTextField configured with a NumberFormat.
     * - Accepts numeric input, formats according to locale, and prevents invalid characters.
     * - Example uses NumberFormat.getNumberInstance(Locale.US) for standard US-style numbers.
     */
    NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    JFormattedTextField formattedTextFieldWithNumberFormat = new JFormattedTextField(numberFormat);
    formattedTextFieldWithNumberFormat.setColumns(20);
    frame.add(formattedTextFieldWithNumberFormat);

    /*
     * Formatted Text Field With Custom Mask
     * - Demonstrates a JFormattedTextField configured with a MaskFormatter.
     * - MaskFormatter enforces input patterns (e.g., phone numbers, postal codes).
     * - Example mask "(###) ###-####" accepts digits only and automatically formats input.
     */
    MaskFormatter customFormat = new MaskFormatter("(###) ###-####");
    JFormattedTextField formattedTextFieldWithCustomFormat = new JFormattedTextField(customFormat);
    formattedTextFieldWithCustomFormat.setColumns(20);
    frame.add(formattedTextFieldWithCustomFormat);

    /*
     * Formatted Text Field With Currency
     * - Demonstrates a JFormattedTextField configured to display currency values.
     * - Uses NumberFormat.getCurrencyInstance(Locale.US) for standard US currency formatting.
     * - Automatically formats numbers with the "$" symbol, comma as a thousand separator, and two decimal places.
     * - Users can type numbers, and the field formats them automatically when focus is lost.
     */
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
    JFormattedTextField formattedTextFieldWithContent = new JFormattedTextField(currencyFormat);
    formattedTextFieldWithContent.setColumns(20);
    formattedTextFieldWithContent.setValue(1000000);
    frame.add(formattedTextFieldWithContent);

    /*
     * Disabled Formatted Text Field
     * - Demonstrates a JFormattedTextField in a disabled state.
     * - Disabled fields are visible but cannot receive focus or user input.
     * - Commonly used to display read-only or unavailable data.
     * - The enabled state is controlled using the setEnabled() method.
     */
    JFormattedTextField disabledFormattedTextField = new JFormattedTextField(customFormat);
    disabledFormattedTextField.setColumns(20);
    disabledFormattedTextField.setEnabled(false);
    frame.add(disabledFormattedTextField);

    /*
     * Document Listener
     * - Demonstrates how to listen for text changes in a JFormattedTextField using its Document model.
     * - The Document represents the underlying text content of the component.
     * - A DocumentListener is triggered whenever the text is inserted or removed.
     * - The current text can be safely retrieved using getText().
     * - The underlying value (parsed and formatted object) can be retrieved using getValue().
     * - This approach captures all changes, including typing, deletion, and paste operations.
     */
    formattedTextField.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            IO.println(formattedTextField.getText());  // Output: <text field content with format>
            IO.println(formattedTextField.getValue()); // Output: <text field value>
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            IO.println(formattedTextField.getText());  // Output: <text field content with format>
            IO.println(formattedTextField.getValue()); // Output: <text field value>
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not supported for JFormattedTextField
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
 * - Launches the Swing application safely by scheduling the GUI initialization
 *   on the Event Dispatch Thread (EDT).
 */
void main() {
    SwingUtilities.invokeLater(() -> {
        try {
            example();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    });
}
