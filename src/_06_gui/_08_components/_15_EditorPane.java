/*
 * Editor Pane (JEditorPane)
 * - This section explains the JEditorPane component in Swing, which is a versatile text component capable of displaying
 *   and editing content in multiple formats.
 *
 * Overview
 * - JEditorPane is part of the javax.swing package.
 * - It extends JTextComponent and provides support for different content types.
 * - Commonly used to display plain text, HTML, or RTF content.
 * - Often wrapped in a JScrollPane to handle content larger than the visible area.
 *
 * Key Characteristics
 * - Supports multiple MIME content types such as text/plain, text/html, and text/rtf.
 * - Uses an EditorKit internally to parse and render content.
 * - Can be editable or read-only depending on use case.
 * - Capable of loading content from strings, streams, files, or URLs.
 * - Integrates with the current Look and Feel for consistent rendering.
 *
 * Usage
 * - Use JEditorPane when rich or formatted text needs to be displayed.
 * - Suitable for help pages, documentation views, previews, or simple browsers.
 * - Prefer JTextArea when only plain text input is required.
 */
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

void example() throws IOException {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Editor Pane");
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(2, 2, 5, 5));

    /*
     * Text/Plain Editor Pane (Default)
     * - Demonstrates a JEditorPane using the default text/plain content type.
     * - Displays raw text without interpreting formatting tags.
     * - Line breaks and spacing are preserved exactly as provided.
     * - Suitable for viewing or editing unformatted text.
     */
    String textContent = """
            Sample plain text content.
            
            This editor displays raw text only.
            Formatting tags are not interpreted.
            
            <b>Bold text</b>
            <i>Italic text</i>
            
            Line breaks and spacing are preserved as-is.
            """;
    JEditorPane editorPane1 = new JEditorPane();
    editorPane1.setText(textContent);
    JScrollPane scrollPane1 = new JScrollPane(
            editorPane1,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    editorPane1.setToolTipText("This is a tooltip!");
    frame.add(scrollPane1);

    /*
     * Text/HTML Editor Pane
     * - Demonstrates a JEditorPane configured to render HTML content.
     * - HTML tags are parsed and rendered visually.
     * - Supports basic HTML elements and limited CSS styling.
     * - Commonly used for help pages or formatted content display.
     */
    String htmlContent = """
            <html>
                <body>
                    <h2>Sample HTML Content</h2>
                    <p>This is a paragraph with <b>bold</b>, <i>italic</i>, and <u>underlined</u> text.</p>
                    <p style="color: #0066cc;">This paragraph uses simple inline CSS styling.</p>
                    <ul>
                        <li>First item</li>
                        <li>Second item</li>
                        <li>Third item</li>
                    </ul>
                    <a href="https://example.com">Sample link</a>
                </body>
            </html>
            """;
    JEditorPane editorPane2 = new JEditorPane();
    editorPane2.setContentType("text/html");
    editorPane2.setText(htmlContent);
    JScrollPane scrollPane2 = new JScrollPane(
            editorPane2,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane2);

    /*
     * Text/RTF Editor Pane
     * - Demonstrates a JEditorPane configured to render RTF content.
     * - Supports rich text features such as fonts, styles, and colors.
     * - Rendering is handled internally by an RTF EditorKit.
     * - Useful for displaying formatted documents without HTML.
     */
    String rtfContent = """
            {\\rtf1\\ansi
            {\\fonttbl\\f0\\fswiss Helvetica;}
            {\\colortbl ;\\red0\\green0\\blue255;}
            \\fs24
            Sample RTF Content\\line
            \\line
            This text demonstrates \\b bold\\b0 , \\i italic\\i0 , and \\ul underlined\\ul0  styles.\\line
            \\line
            Here is a colored word: \\cf1 blue\\cf0\\line
            }
            """;
    JEditorPane editorPane3 = new JEditorPane();
    editorPane3.setContentType("text/rtf");
    editorPane3.setText(rtfContent);
    JScrollPane scrollPane3 = new JScrollPane(
            editorPane3,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane3);

    /*
     * Editor Pane With URL
     * - Demonstrates loading external HTML content directly from a URL.
     * - The content is fetched and rendered automatically.
     * - The editor is set to non-editable to behave as a read-only viewer.
     * - Commonly used to embed simple web-based documentation or previews.
     */
    JEditorPane editorPane4 = new JEditorPane("https://www.google.com");
    editorPane4.setContentType("text/html");
    editorPane4.setEditable(false);
    JScrollPane scrollPane4 = new JScrollPane(
            editorPane4,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane4);

    /*
     * Editor Pane Document Listener
     * - Demonstrates how to listen for text changes in a JEditorPane using its Document model.
     * - The Document represents the underlying content of the editor, independent of its view.
     * - A DocumentListener is triggered whenever text is inserted, removed, or attributes change.
     * - This approach captures all edits, including typing, deletion, paste operations, and programmatic text updates.
     * - The current content can be retrieved using getText() on the JEditorPane.
     * - The "changeUpdate" is typically used for attribute/style changes (HTML or RTF documents).
     */
    editorPane1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            IO.println(editorPane1.getText()); // Output: current editor content
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            IO.println(editorPane1.getText()); // Output: current editor content
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            IO.println(editorPane1.getText()); // Output: current editor content
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    });
}
