/*
 * Text Area (JTextArea)
 * - This section explains the JTextArea component in Swing, which represents a multi-line text input area used to
 *   collect larger textual data from the user.
 *
 * Overview
 * - JTextArea is part of the javax.swing package.
 * - It extends JTextComponent and provides editable multi-line text input.
 * - Typically wrapped in a JScrollPane to allow vertical and horizontal scrolling when content exceeds
 *   the visible area.
 *
 * Key Characteristics
 * - Accepts and displays multiple lines of text.
 * - Supports text editing, selection, copy/paste, and caret navigation.
 * - Uses a Document model internally to store and manage text content.
 * - Fully integrates with the current Look and Feel for consistent rendering.
 * - scroll bars can be added via JScrollPane for better user experience.
 *
 * Dimension Control
 * - setColumns(int): defines the preferred width of the text area in terms of character columns.
 * - setRows(int): defines the preferred height of the text area in terms of visible text lines.
 *
 * Usage
 * - Use JTextArea for multi-line text input, comments, logs, or any content that may exceed a single line.
 * - Combine with JScrollPane to ensure all content remains accessible.
 * - Can be initialized with text content or made read-only/disabled using setText() and setEnabled().
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
    JFrame frame = new JFrame("Text Area");
    frame.setSize(400, 320);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Text Area
     * - Demonstrates a basic JTextArea wrapped in a JScrollPane.
     * - setColumns() defines preferred width; setRows() defines preferred height.
     * - ScrollPane ensures content exceeding visible area can be navigated by the user.
     * - A tooltip is added to provide contextual help.
     */
    JTextArea textArea1 = new JTextArea();
    JScrollPane scrollPane1 = new JScrollPane(
            textArea1,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );
    textArea1.setColumns(18);
    textArea1.setRows(4);
    textArea1.setToolTipText("This is a tooltip!");
    frame.add(scrollPane1);

    /*
     * Text Area With Content
     * - Demonstrates a JTextArea initialized with multi-line content.
     * - Columns and rows define preferred dimensions; JScrollPane enables scrolling.
     */
    JTextArea textArea2 = new JTextArea();
    JScrollPane scrollPane2 = new JScrollPane(
            textArea2,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );
    textArea2.setColumns(18);
    textArea2.setRows(4);
    textArea2.setText("Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit.");
    frame.add(scrollPane2);

    /*
     * Disabled Text Area
     * - Demonstrates a JTextArea in a disabled state.
     * - Disabled text areas are visible but cannot receive focus or user input.
     * - Columns and rows define preferred dimensions; JScrollPane allows scrolling even when disabled.
     */
    JTextArea textArea3 = new JTextArea();
    JScrollPane scrollPane3 = new JScrollPane(
            textArea3,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS
    );
    textArea3.setColumns(18);
    textArea3.setRows(4);
    textArea3.setEnabled(false);
    textArea3.setText("Lorem ipsum dolor sit amet,\nconsectetur adipiscing elit.");
    frame.add(scrollPane3);

    /*
     * Document Listener
     * - Demonstrates how to listen for text changes in a JTextArea using its Document model.
     * - The Document represents the underlying text content of the component.
     * - A DocumentListener is triggered whenever the text is inserted or removed.
     * - The current text can be safely retrieved using getText() on the JTextArea.
     * - This approach captures all changes, including typing, deletion, and paste operations.
     */
    textArea1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            IO.println(textArea1.getText()); // Output: <text area content>
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            IO.println(textArea1.getText()); // Output: <text area content>
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not supported for JTextArea
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
