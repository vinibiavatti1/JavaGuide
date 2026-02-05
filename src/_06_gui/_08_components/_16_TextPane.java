/*
 * Text Pane (JTextPane)
 * - This section explains the JTextPane component in Swing, which is a rich text editor designed for styled and
 *   formatted text manipulation.
 *
 * Overview
 * - JTextPane is part of the javax.swing package.
 * - It extends JTextComponent and is built on top of a StyledDocument.
 * - Unlike JTextArea, it supports multiple styles within the same document.
 * - Commonly wrapped in a JScrollPane to handle large or scrollable content.
 *
 * Key Characteristics
 * - Supports styled text using Style and AttributeSet.
 * - Allows different fonts, sizes, colors, and text attributes in a single document.
 * - Uses a StyledDocument as its underlying data model.
 * - Supports listening to both text and style changes via a DocumentListener.
 * - Integrates with the current Look and Feel for consistent rendering.
 *
 * Usage
 * - Use JTextPane when rich text editing or display is required.
 * - Suitable for editors, formatted notes, previews, or syntax-highlighted content.
 * - Prefer JTextArea or JTextField when only plain text input is needed.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;

void example() throws BadLocationException {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Text Pane");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Declare Text Pane
     * - JTextPane provides a rich text editor capable of displaying styled content.
     * - A JScrollPane is used to allow scrolling when content exceeds the visible area.
     */
    JTextPane textPane1 = new JTextPane();
    JScrollPane scrollPane1 = new JScrollPane(
            textPane1,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    textPane1.setToolTipText("This is a tooltip!");
    frame.add(scrollPane1);

    /*
     * Declare Styles
     * - Styles define visual attributes that can be applied to text ranges.
     * - A default style is used as the base for custom styles.
     * - Styles are registered in the StyledDocument and reused by name.
     * - StyleConstants is a utility class that provides static helper methods to configure common text attributes such
     *   as font size, weight, color, alignment, and decorations.
     */
    StyledDocument styledDocument = textPane1.getStyledDocument();
    Style defaultStyle = StyleContext
            .getDefaultStyleContext()
            .getStyle(StyleContext.DEFAULT_STYLE);

    Style titleStyle = styledDocument.addStyle("title", defaultStyle);
    StyleConstants.setFontSize(titleStyle, 18);
    StyleConstants.setBold(titleStyle, true);

    Style highlightStyle = styledDocument.addStyle("highlight", defaultStyle);
    StyleConstants.setForeground(highlightStyle, Color.BLUE);

    /*
     * Set Content
     * - Text is inserted programmatically into the StyledDocument.
     * - Each insertion can specify a different style.
     * - This allows mixing formatted and unformatted text in the same editor.
     */
    styledDocument.insertString(styledDocument.getLength(), "Title\n\n", titleStyle);
    styledDocument.insertString(styledDocument.getLength(), "Normal Text\n", defaultStyle);
    styledDocument.insertString(styledDocument.getLength(), "Highlighted Text\n", highlightStyle);
    textPane1.setStyledDocument(styledDocument);

    /*
     * Text Pane Document Listener
     * - Demonstrates how to listen for content and style changes in a JTextPane.
     * - insertUpdate and removeUpdate are triggered for text changes.
     * - changedUpdate is triggered for attribute or style changes in a StyledDocument.
     * - This makes JTextPane suitable for advanced editors that react to formatting updates.
     */
    textPane1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            IO.println(textPane1.getText()); // Output: current editor content
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            IO.println(textPane1.getText()); // Output: current editor content
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            IO.println(textPane1.getText()); // Triggered on style/attribute changes
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
        try {
            example();
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    });
}
