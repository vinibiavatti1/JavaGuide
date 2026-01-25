/*
 * JOptionPane
 * - This section explains the JOptionPane class in Java Swing, which provides a convenient way to create standard
 *   dialogs for messages, confirmations, and input prompts.
 *
 * Overview
 * - JOptionPane is part of the javax.swing package and allows the creation of modal or non-modal dialogs without
 *   explicitly creating a JFrame or JDialog.
 * - It can display messages, request user input, or present Yes/No/Cancel type confirmation dialogs.
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

void example() {
    //==================================================================================================================
    // Message Dialogs
    //==================================================================================================================

    /*
     * Information Dialog
     * - Displays a simple informational message dialog using JOptionPane.
     * - The first parameter (null) means the dialog has no parent and will be centered on the screen.
     * - By default, an information icon is shown, and the dialog is modal, blocking input to other windows until
     *   dismissed.
     * - Can be customized with a title, different message types (warning, error, question, plain), and a custom icon.
     */
    JOptionPane.showMessageDialog(null, "Hello World!");

    /*
     * Warning Dialog
     * - Shows a warning message dialog to alert the user.
     * - Uses JOptionPane.WARNING_MESSAGE to display a warning icon.
     * - Providing a title is recommended to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World!", "Warning", JOptionPane.WARNING_MESSAGE);

    /*
     * Error Dialog
     * - Shows an error message dialog to indicate a problem or failure.
     * - Uses JOptionPane.ERROR_MESSAGE to display an error icon.
     * - Providing a title is recommended to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World!", "Error", JOptionPane.ERROR_MESSAGE);

    /*
     * Question Dialog
     * - Shows a question dialog, typically used to prompt the user or indicate a query.
     * - Uses JOptionPane.QUESTION_MESSAGE to display a question mark icon.
     * - Providing a title is recommended to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World!", "Question", JOptionPane.QUESTION_MESSAGE);

    /*
     * Plain Dialog
     * - Shows a plain dialog without any icon.
     * - Uses JOptionPane.PLAIN_MESSAGE for a simple, neutral message.
     * - Providing a title is recommended to give context to the dialog.
     */
    JOptionPane.showMessageDialog(null, "Hello World!", "Plain", JOptionPane.PLAIN_MESSAGE);

    //==================================================================================================================
    // Confirm Dialogs
    //==================================================================================================================

    /*
     * Confirm Dialog With Yes-No-Cancel Options
     * - Shows a confirmation dialog with Yes, No, and Cancel options.
     * - Useful for prompting the user to confirm an action.
     * - Displays a standard question icon by default.
     */
    JOptionPane.showConfirmDialog(null, "Do you agree?");

    /*
     * Confirm Dialog With Yes-No Options
     * - Shows a confirmation dialog with Yes and No options only.
     * - Uses YES_NO_OPTION to limit choices.
     * - Providing a title is recommended to give context to the dialog.
     */
    JOptionPane.showConfirmDialog(null, "Do you agree?", "Agreement", JOptionPane.YES_NO_OPTION);

    /*
     * Confirm Dialog With Ok-Cancel Options
     * - Shows a confirmation dialog with OK and Cancel options only.
     * - Uses OK_CANCEL_OPTION to limit choices.
     * - Providing a title is recommended to give context to the dialog.
     */
    JOptionPane.showConfirmDialog(null, "Do you agree?", "Agreement", JOptionPane.OK_CANCEL_OPTION);

    //==================================================================================================================
    // Input Dialogs
    //==================================================================================================================

    /*
     * Input Dialog
     * - Prompts the user for text input.
     * - Modal by default, blocking other windows until dismissed.
     * - Returns a String; null if canceled.
     * - Title is optional; default dialog title is used if omitted.
     */
    String name = JOptionPane.showInputDialog(null, "Enter your name:");
    System.out.println("Your name: " + name);

    /*
     * Input Dialog With Selection Values
     * - Lets the user choose from predefined values.
     * - Returns the selected value as an Object; null if canceled.
     * - Can specify a default selected value.
     */
    Object[] selectionValues = new String[] {"Sr.", "Sra.", "Unspecified"};
    Object option = JOptionPane.showInputDialog(
            null,                               // parentComponent
            "How would you like to be called?", // message
            "Question",                         // title
            JOptionPane.INFORMATION_MESSAGE,    // messageType
            null,                               // icon
            selectionValues,                    // selectionValues
            "Sr."                               // initialSelectionValue
    );
    System.out.println("You entered: " + option);

    //==================================================================================================================
    // Custom Dialog
    //==================================================================================================================

    /*
     * Custom Dialog
     * - Highly customizable dialog using showOptionDialog.
     * - Allows custom buttons, icons, default selection, and title.
     * - Returns the index of the selected option, or -1 if closed without selection.
     * - Note: When a custom options array is provided, it overrides the buttons defined by optionType. However, the
     *   optionType should still be set (typically to DEFAULT_OPTION) to maintain standard accessibility and keyboard
     *   behavior.
     */
    String[] options = new String[] {"I Agree", "I Disagree"};
    option = JOptionPane.showOptionDialog(
            null,                            // parentComponent
            "Do you agree?",                 // message
            "Agreement",                     // title
            JOptionPane.DEFAULT_OPTION,      // optionType
            JOptionPane.INFORMATION_MESSAGE, // messageType
            null,                            // icon
            options,                         // options
            "I Agree"                        // initialValue
    );
    System.out.println(option);

    //==================================================================================================================
    // Custom Object
    //==================================================================================================================

    /*
     * Custom Object
     * - Any Object can be passed as the message.
     * - Components like JPanel, JLabel, JTextArea, etc., are rendered directly inside the dialog.
     * - Example: JLabel with an icon displayed centered horizontally.
     */
    JLabel label = new JLabel();
    label.setIcon(new ImageIcon(this.getClass().getResource("gui/java.png")));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    JOptionPane.showMessageDialog(null, label, "Image", JOptionPane.PLAIN_MESSAGE);

    // Stop Program and Event Dispatch Thread (EDT)
    System.exit(0);
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