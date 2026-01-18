/*
 * JOptionPane
 * - This section explains the JOptionPane class in Java Swing, which provides a convenient way to create standard
 *   dialogs for messages, confirmations, and input prompts.
 *
 * Overview
 * - JOptionPane is part of the javax.swing package and allows the creation of modal or non-modal dialogs without
 *   explicitly creating a JFrame or JDialog.
 * - It can display messages, request user input, or present yes/no/cancel type confirmation dialogs.
 * - A JOptionPane dialog is typically modal, blocking input to its parent window until dismissed.
 * - For applications using JDesktopPane and JInternalFrame, showInternalXxx methods create dialogs contained within the
 *   internal desktop instead of external system dialogs.
 *
 * Key Characteristics
 * - Does not require a JFrame to be displayed; it can be shown with null as the parent component.
 * - Overloads allow specifying parent component, title, message type, option type, and icon.
 * - Internal dialogs (showInternal...) appear within a JDesktopPane and are ideal for MDI applications, keeping the
 *   dialog confined to the desktop window.
 *
 * Methods
 * - showMessageDialog: Displays a simple message with optional title, message type, and icon.
 * - showConfirmDialog: Presents options such as Yes/No, Yes/No/Cancel, or OK/Cancel for user confirmation.
 * - showInputDialog: Prompts the user to enter text or select from predefined options.
 * - showOptionDialog: The most flexible method, allows specifying custom options, button labels, icons, and default
 *   selection.
 *
 * Message Types
 * - JOptionPane.INFORMATION_MESSAGE: Displays an information icon.
 * - JOptionPane.WARNING_MESSAGE: Displays a warning icon.
 * - JOptionPane.ERROR_MESSAGE: Displays an error icon.
 * - JOptionPane.QUESTION_MESSAGE: Displays a question icon.
 * - JOptionPane.PLAIN_MESSAGE: No icon displayed.
 *
 * Option Types
 * - JOptionPane.DEFAULT_OPTION: Only the provided options are shown, no standard buttons.
 * - JOptionPane.YES_NO_OPTION: Provides Yes and No buttons.
 * - JOptionPane.YES_NO_CANCEL_OPTION: Provides Yes, No, and Cancel buttons.
 * - JOptionPane.OK_CANCEL_OPTION: Provides OK and Cancel buttons.
 *
 * Usage
 * - Use JOptionPane for quickly creating standard dialogs without manual setup of frames or dialogs.
 * - Ideal for simple applications, message prompts, or quick input collection.
 * - Use showOptionDialog when custom button labels, multiple choices, or advanced configuration are needed.
 * - For MDI applications, prefer showInternalXxx to ensure dialogs remain inside the application’s internal desktop.
 * - Output: A standard, user-friendly dialog window displayed according to the specified type, title, message, and
 *   parent component.
 */
import javax.swing.*;

void main() {
    //==================================================================================================================
    // Message Dialogs
    //==================================================================================================================

    /*
     * Message Dialog (Information)
     * - Displays a simple informational message dialog using JOptionPane.
     * - The first parameter (null) means the dialog has no parent and will be centered on the screen.
     * - By default, an information icon is shown, and the dialog is modal, blocking input to other windows until
     *   dismissed.
     * - Can be customized with a title, different message types (warning, error, question, plain), and a custom icon.
     */
    JOptionPane.showMessageDialog(null, "Hello World");

    /*
     * Message Dialog (Warning)
     * - Shows a warning message dialog using JOptionPane to alert the user.
     * - The message type argument determines the icon displayed; here we use JOptionPane.WARNING_MESSAGE to indicate a
     *   warning.
     * - In this overload, providing a title is mandatory to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World", "Warning", JOptionPane.WARNING_MESSAGE);

    /*
     * Message Dialog (Error)
     * - Shows an error message dialog using JOptionPane to indicate a problem or failure.
     * - The message type argument determines the icon displayed; here we use JOptionPane.ERROR_MESSAGE to show an error
     *   icon.
     * - In this overload, providing a title is mandatory to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World", "Error", JOptionPane.ERROR_MESSAGE);

    /*
     * Message Dialog (Question)
     * - Shows a question message dialog using JOptionPane, typically used to prompt the user or indicate a query.
     * - The message type argument determines the icon displayed; here we use JOptionPane.QUESTION_MESSAGE to show a
     *   question mark icon.
     * - In this overload, providing a title is mandatory to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World", "Question", JOptionPane.QUESTION_MESSAGE);

    /*
     * Message Dialog (Plain)
     * - Shows a plain message dialog using JOptionPane, without any icon.
     * - The message type argument is set to JOptionPane.PLAIN_MESSAGE to display a simple, neutral message.
     * - In this overload, providing a title is mandatory to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World", "Plain", JOptionPane.PLAIN_MESSAGE);

    //==================================================================================================================
    // Confirm Dialogs
    //==================================================================================================================

    /*
     * Confirm Dialog (Yes-No-Cancel)
     * - Shows a confirmation dialog using JOptionPane with Yes, No, and Cancel options.
     * - Useful for prompting the user to confirm an action before proceeding.
     * - This overload uses default title and message type, displaying a standard question icon.
     */
    JOptionPane.showConfirmDialog(null, "Are you sure?");

    /*
     * Confirm Dialog (Yes-No)
     * - Shows a confirmation dialog using JOptionPane with Yes and No options.
     * - The dialog type is set to YES_NO_OPTION, which limits the choices to Yes or No.
     * - In this overload, providing a title is mandatory to give context to the dialog.
     */
    JOptionPane.showConfirmDialog(null, "Are you sure?", "Sure?", JOptionPane.YES_NO_OPTION);

    /*
     * Confirm Dialog (Ok-Cancel)
     * - Shows a confirmation dialog using JOptionPane with OK and Cancel options.
     * - The dialog type is set to OK_CANCEL_OPTION, which limits the choices to OK or Cancel.
     * - In this overload, providing a title is mandatory to give context to the dialog.
     */
    JOptionPane.showConfirmDialog(null, "Are you sure?", "Sure?", JOptionPane.OK_CANCEL_OPTION);

    //==================================================================================================================
    // Input Dialogs
    //==================================================================================================================

    /*
     * Input Dialog
     * - Shows a simple input dialog using JOptionPane to prompt the user for text input.
     * - The dialog displays the message and is modal by default, blocking other windows until dismissed.
     * - The entered value is returned as a String; if the user cancels, the result will be null.
     * - This overload does not require a title, using a default dialog title instead.
     */
    String name = JOptionPane.showInputDialog(null, "Enter:");
    IO.println("You entered: " + name); // Will be null if the user cancels or closes the dialog

    /*
     * Input Dialog (With Predefined Options)
     * - Shows an input dialog using JOptionPane that allows the user to choose from predefined options.
     * - The dialog displays the message "Enter:" with a title "Frame" and an error icon (JOptionPane.ERROR_MESSAGE).
     * - The user can select one of the provided options ("A", "B", "C") or cancel the dialog.
     * - The selected value is returned as an Object; if the user cancels, the result will be null.
     * - The last parameter specifies the default selected value, which is "A" in this example.
     */
    Object[] options = new String[] {"A", "B", "C"};
    Object option = JOptionPane.showInputDialog(null, "Enter:", "Frame", JOptionPane.ERROR_MESSAGE, null, options, "A");
    IO.println("You entered: " + option);

    //==================================================================================================================
    // Generic Dialog
    //==================================================================================================================

    /*
     * Generic Dialog
     * - Shows a highly customizable dialog using JOptionPane.showOptionDialog.
     * - Allows specifying custom options (buttons), message type, icon, default selection, and title.
     * - In this example, the dialog displays the message with the title "Frame" and a warning icon.
     * - The user can select one of the provided options ("A", "B", "C") or close the dialog.
     * - The return value is an integer representing the index of the selected option in the options array, or -1 if the
     *   user closes the dialog without selecting anything.
     */
    options = new String[] {"A", "B", "C"};
    option = JOptionPane.showOptionDialog(null, "Select:", "Frame", 0, JOptionPane.WARNING_MESSAGE, null, options, "A");
    IO.println(option);

    //==================================================================================================================
    // Custom Dialog
    //==================================================================================================================

    /*
     * Custom Dialog
     * - Shows a custom dialog using JOptionPane where the content can be any Swing component, not just text.
     * - In this example, a JLabel with an icon is used to display an image centered horizontally in the dialog.
     * - JOptionPane dialogs can accept various components as content, such as JLabel, JTextArea, JSpinner, JPanel, or
     *   other Swing elements.
     * - The dialog title is set to "Image" and the message type is PLAIN_MESSAGE, so no standard icon is shown.
     * - This allows creating rich, customized dialogs for images, forms, or other interactive content.
     */
    JLabel label = new JLabel();
    label.setIcon(new ImageIcon(this.getClass().getResource("java.png")));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JOptionPane.showMessageDialog(null, label, "Image", JOptionPane.PLAIN_MESSAGE);
}