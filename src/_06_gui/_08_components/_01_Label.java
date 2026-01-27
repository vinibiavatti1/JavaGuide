/*
 * Label (JLabel)
 * - This section explains the JLabel component in Swing, which is used to display short text strings, icons, or both,
 *   without allowing direct user interaction.
 *
 * Overview
 * - JLabel is part of the javax.swing package.
 * - It extends JComponent and is intended for presenting read-only information.
 * - Commonly used to label other components such as text fields, combo boxes, and panels.
 *
 * Key Characteristics
 * - Can display text, icons, or a combination of both.
 * - Supports horizontal and vertical alignment of content.
 * - Allows text formatting through font, color, and border customization.
 * - Integrates with the current Look and Feel for consistent visual appearance.
 * - JLabel does not receive keyboard focus and does not generate action events.
 * - It is lightweight and optimized for displaying static information.
 * - Can be associated with another component using setLabelFor to improve accessibility.
 *
 * HTML Support
 * - JLabel Supports HTML rendering for simple formatted text (e.g., bold, italics, line breaks).
 * - Enable HTML rendering by using "<html></html>" tags.
 *
 * Usage
 * - Use JLabel to describe the purpose of input fields or groups of components.
 * - Ideal for titles, captions, status messages, or informational text.
 * - Combine with layout managers to align labels consistently across forms.
 * - Prefer JLabel over custom painting when displaying simple text or icons.
 *
 * Customization
 * - setText(String): Updates the displayed text.
 * - setIcon(Icon): Sets an icon to be displayed.
 * - setHorizontalAlignment(int) / setVerticalAlignment(int): Controls content alignment.
 * - setFont(Font) and setForeground(Color): Customize text appearance.
 * - setBorder(Border): Adds spacing or visual emphasis around the label.
 *
 * Accessibility
 * - Use setLabelFor(Component) to associate a label with an input component.
 * - Helps screen readers and improves keyboard navigation context.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Label");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Label With Text
     * - Demonstrates a basic JLabel displaying plain text.
     * - Used for simple, read-only messages or captions in the UI.
     */
    JLabel labelWithText = new JLabel("My Text");
    frame.add(labelWithText);

    /*
     * Label With HTML
     * - Demonstrates that JLabel supports simple HTML rendering.
     * - Allows basic formatting such as italics, bold text, and line breaks.
     * - Useful for multi-line labels or emphasizing parts of the text without custom painting.
     */
    JLabel labelWithHtml = new JLabel("<html><i>My<br>Text</i></html>");
    frame.add(labelWithHtml);

    /*
     * Label With Image
     * - Demonstrates using JLabel to display an image icon.
     * - Icons are commonly loaded from the classpath using getResource.
     * - Useful for logos, status indicators, or decorative UI elements.
     * - The "setIcon" method can be used to set an icon to a JLabel.
     */
    JLabel labelWithImage = new JLabel();
    labelWithImage.setIcon(new ImageIcon(this.getClass().getResource("/gui/java.png")));
    frame.add(labelWithImage);

    /*
     * Label With Image And Text
     * - Demonstrates a JLabel combining text and an icon in a single component.
     * - The text is displayed alongside the image, following the default horizontal layout.
     * - The relative positioning of text and icon can be customized using: setHorizontalTextPosition() and
     *   setVerticalTextPosition().
     * - Commonly used for application titles, menu headers, or labeled icons.
     */
    JLabel labelWithImageAndText = new JLabel("Text with Image");
    labelWithImageAndText.setIcon(new ImageIcon(this.getClass().getResource("/gui/application.png")));
    labelWithImageAndText.setVerticalTextPosition(JLabel.BOTTOM);
    labelWithImageAndText.setHorizontalTextPosition(JLabel.CENTER);
    frame.add(labelWithImageAndText);

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