/*
 * JColorChooser
 * - This section explains the JColorChooser class in Java Swing, which provides a standard interface for selecting
 *   colors from a palette, sliders, or predefined swatches.
 *
 * Overview
 * - JColorChooser is part of the javax.swing package and allows users to select colors for use in applications, such as
 *   setting background colors, drawing, or theming components.
 * - It can be displayed as a modal dialog using the static showDialog methods, or embedded directly as a component
 *   inside a container like JPanel.
 * - Users can choose colors via RGB sliders, HSB/HSV controls, or a palette of predefined swatches.
 * - When displayed as a dialog, it is modal by default, blocking input to other windows until the user approves or
 *   cancels the selection.
 * - The chooser itself does not apply the selected color; the application is responsible for using the returned Color
 *   object appropriately.
 *
 * Key Characteristics
 * - Supports both modal dialog usage (JColorChooser.showDialog) and component embedding (new JColorChooser()).
 * - Allows specifying an initial color that is highlighted when the chooser opens.
 * - The dialog can optionally allow transparency (alpha channel) selection in some overloaded methods.
 * - Custom panels can be added or removed via AbstractColorChooserPanel to limit or extend color selection options.
 * - Returns a java.awt.Color object representing the selected color, or null if the user cancels.
 *
 * Usage
 * - Use JColorChooser.showDialog when a quick, modal color selection is needed, such as prompting the user to pick a
 *   theme color, change text or background color, or select a drawing color.
 * - Embed JColorChooser as a component in panels when continuous or persistent color selection is required, such as in
 *   graphic editors, design tools, or any application where the user may need to adjust colors repeatedly while
 *   interacting with the UI.
 */
import javax.swing.*;
import javax.swing.colorchooser.DefaultColorSelectionModel;
import java.awt.*;

void example() {
    /*
     * Color Dialog
     * - Displays a modal color selection dialog using JColorChooser, allowing the user to pick a color.
     * - The first parameter (null) means the dialog has no parent component and will be centered on the screen.
     * - The second parameter is the title of the dialog.
     * - The third parameter is the initially selected color; passing null defaults to white (255, 255, 255).
     * - The method returns a java.awt.Color object representing the chosen color, or null if the user cancels.
     * - Example Output: java.awt.Color[r=255,g=255,b=255]
     */
    Color color = JColorChooser.showDialog(null, "Select a color", null);
    IO.println(color);

    /*
     * Color Dialog With Default Color
     * - Displays a modal color selection dialog using JColorChooser with an initial color already selected.
     * - The third parameter specifies the initially selected color; in this example, Color.RED.
     * - Example Output: java.awt.Color[r=255,g=0,b=0]
     */
    color = JColorChooser.showDialog(null, "Select a color", Color.RED);
    IO.println(color);

    /*
     * Color Dialog With Transparency (Alpha) Disabled
     * - Displays a modal color selection dialog using JColorChooser, with the option to disable alpha (transparency)
     *   selection.
     * - The fourth parameter (colorTransparencySelectionEnabled) enables/disables the ability for the user to select
     *   transparency, ensuring the returned color is fully opaque.
     * - Example Output: java.awt.Color[r=255,g=255,b=255]
     */
    color = JColorChooser.showDialog(null, "Select a color", Color.RED, false);
    IO.println(color);

    /*
     * Embedded Color Dialog
     * - Demonstrates embedding a JColorChooser directly into a JFrame as a persistent component.
     * - The color chooser is always visible and allows continuous selection without opening a modal dialog.
     * - Suitable for applications like graphic editors, design tools, or panels where the user needs to adjust colors
     *   repeatedly.
     * - The JFrame is used as the container, with size, location, and default close operation set.
     * - To retrieve the selected color, call getColor() on the JColorChooser instance at any time.
     */
    JFrame frame = new JFrame("Embedded Color Dialog");
    frame.setSize(500, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().add(new JColorChooser());
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