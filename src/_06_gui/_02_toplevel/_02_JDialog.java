/*
 * JDialog
 * - This section explains the JDialog class in Java Swing, which represents a top-level window used for dialog boxes,
 *   pop-ups, and secondary windows that are associated with a parent frame or another window.
 *
 * Overview
 * - JDialog is part of the javax.swing package and extends java.awt.Dialog.
 * - Typically used to display messages, collect input, or manage settings without requiring a full JFrame.
 * - Can be modal or non-modal:
 *   - Modal: Block input to other windows until dismissed.
 *   - Non-modal: Allow interaction with other windows while open.
 * - Supports custom decorations, title, and optional menu bars.
 * - Can be owned by a JFrame, another JDialog, or a Window.
 *
 * Key Characteristics
 * - Top-level container: cannot be added to another container.
 * - Modality types:
 *   - MODELESS: does not block other windows.
 *   - DOCUMENT_MODAL: blocks input to its parent window.
 *   - APPLICATION_MODAL: blocks input to all windows in the application.
 *   - TOOLKIT_MODAL: blocks input to all windows in the toolkit (rarely used).
 * - Can be sized, positioned, and decorated similar to JFrame.
 * - Supports adding standard Swing components and layout managers.
 * - Typically used with JOptionPane for standard dialogs (e.g., message, input, confirm).
 * - Closing behavior can be controlled via setDefaultCloseOperation similar to JFrame.
 *
 * Usage
 * - Use JDialog for temporary or auxiliary windows that interact with the main application.
 * - Ideal for alerts, forms, wizards, configuration panels, and user prompts.
 * - Configure modality, size, position, and content before making the dialog visible.
 * - Always create and display JDialogs on the Event Dispatch Thread (EDT) to ensure thread safety.
 * - Combine with listeners and actions to handle user responses effectively.
 * - Output: A pop-up or secondary window displayed according to its modality and owner settings.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Frame Declaration
     * - Creates a simple JFrame to serve as the main window for the application.
     * - This frame will be used to demonstrate the functionality of the JDialog in the following example.
     * - Sets the title, size, position, default close operation, and makes the frame visible.
     */
    JFrame frame = new JFrame("My Frame!");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);

    /*
     * Dialog Declaration
     * - Creates a JDialog associated with a parent JFrame, ensuring proper ownership and positioning.
     * - The constructor accepts a parent frame and a title string, which sets the dialog's owner and title bar text.
     * - The "setModal(true)" makes the dialog modal, blocking input to the parent frame until the dialog is closed.
     * - The ModalityType can be set to control how the dialog blocks other windows. The default is APPLICATION_MODAL,
     *   which blocks all windows in the application while the dialog is open.
     * - The "setLocationRelativeTo(frame)" centers the dialog relative to its parent frame. Passing null would center
     *   the dialog on the screen instead.
     */
    JDialog dialog = new JDialog(frame, "My Dialog!");
    dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // Set modality type (default APPLICATION_MODAL)
    dialog.setModal(true);                                         // Set dialog as modal (blocks parent input)
    dialog.setSize(300, 200);
    dialog.setLocationRelativeTo(frame);
    dialog.setResizable(false);
    dialog.setVisible(true);
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