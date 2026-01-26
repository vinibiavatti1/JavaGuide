/*
 * JToolBar
 * - This section explains the JToolBar component in Swing, which provides a container for organizing commonly used
 *   actions and interactive components in a horizontal or vertical layout.
 *
 * Overview
 * - JToolBar is part of the javax.swing package.
 * - It extends JComponent and can hold buttons, combo boxes, sliders, text fields, and other interactive components.
 * - Toolbars are typically placed at the top or sides of a window, but they can float independently if floatable.
 * - The title of the toolbar can be set via the constructor and is displayed when the toolbar is detached from the
 *   frame.
 *
 * Key Characteristics
 * - Orientation: Toolbars can be HORIZONTAL or VERTICAL, controlling the layout of contained components.
 * - Floatable: By default, toolbars can be dragged out of their original position to float as independent windows.
 * - Separators: Visual dividers can be added between components to group related actions.
 * - Supports dynamic addition or removal of components at runtime.
 * - Integrates with the Look and Feel system to provide consistent appearance across platforms.
 *
 * Usage
 * - Use JToolBar to provide quick access to frequently used commands or settings in an application.
 * - Common components include:
 *   - JButton: Standard buttons for actions like New, Open, Save, Exit.
 *   - JComboBox: Dropdowns for selections like themes or modes.
 *   - JToggleButton or JCheckBox: For toggling options.
 * - Position the toolbar in a container using layout constraints, typically BorderLayout.PAGE_START for top placement.
 * - Enable floatable to allow users to rearrange the toolbar freely or disable it to lock the toolbar in place.
 * - Combine with icons and tooltips to improve usability and visual clarity.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Tool Bar");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Tool Bar Buttons
     * - JButton instances are created to demonstrate a simple toolbar.
     * - These buttons can be added to a JToolBar to provide quick access to frequently used commands.
     */
    JButton button1 = new JButton("New");
    JButton button2 = new JButton("Open");
    JButton button3 = new JButton("Save");
    JButton button4 = new JButton("Exit");

    /*
     * Tool Bar Inputs
     * - The following JComboBox demonstrates that other Swing components besides buttons can be added to a JToolBar.
     * - Toolbars can include buttons, combo boxes, text fields, sliders, and other interactive components.
     * - Adding different types of components allows the toolbar to provide more flexible and powerful controls.
     */
    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("Light");
    comboBox.addItem("Dark");

    /*
     * Set Icons
     * - Assigns graphical icons to JButton instances to improve visual recognition and usability.
     */
    button1.setIcon(new ImageIcon(this.getClass().getResource("gui/page_white.png")));
    button2.setIcon(new ImageIcon(this.getClass().getResource("gui/folder_page_white.png")));
    button3.setIcon(new ImageIcon(this.getClass().getResource("gui/disk.png")));

    /*
     * Set Actions
     * - Attaches ActionListener implementations to toolbar items to define their behavior when selected.
     * - Each listener is triggered by user interaction, such as a mouse click or keyboard accelerator.
     * - Lambda expressions provide a concise way to define action handling logic.
     */
    button1.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "New"));
    button2.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Open"));
    button3.addActionListener(evt -> JOptionPane.showMessageDialog(frame, "Save"));
    button4.addActionListener(evt -> System.exit(0));

    /*
     * Tool Bar
     * - JToolBar is created to provide a horizontal toolbar containing buttons and other interactive components.
     * - The constructor allows specifying a title for the floating toolbar, which appears when the toolbar is detached
     *   from the frame.
     * - Orientation can be set to HORIZONTAL or VERTICAL to control the layout of the toolbar items.
     * - The floatable property (enabled by default) allows the user to drag the toolbar out of its original position.
     * - Adding the toolbar to the frame using BorderLayout.PAGE_START positions it at the top of the window.
     * - Separators visually group related controls for better usability.
     */
    JToolBar toolBar = new JToolBar("Tool Bar", JToolBar.HORIZONTAL);
    toolBar.add(button1);
    toolBar.add(button2);
    toolBar.add(button3);
    toolBar.addSeparator();
    toolBar.add(button4);
    toolBar.addSeparator();
    toolBar.add(comboBox);
    frame.add(toolBar, BorderLayout.PAGE_START);

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