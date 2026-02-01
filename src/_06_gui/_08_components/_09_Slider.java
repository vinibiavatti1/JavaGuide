/*
 * Slider (JSlider)
 * - This section explains the JSlider component in Swing, which represents a graphical control used to select a numeric
 *   value within a bounded range by sliding a knob along a track.
 *
 * Overview
 * - JSlider is part of the javax.swing package.
 * - It extends JComponent and provides a visual way to choose values from a minimum to a maximum.
 * - It can be displayed horizontally or vertically, depending on the desired layout and interaction style.
 * - Commonly used for ranges such as volume, brightness, zoom level, or progress configuration.
 *
 * Key Characteristics
 * - Supports horizontal and vertical orientations.
 * - Maintains its current value internally and allows querying via getValue().
 * - Can display tick marks and labels to improve usability.
 * - Supports major and minor tick spacing for fine-grained control.
 * - Integrates with the current Look and Feel for consistent appearance.
 *
 * Usage
 * - Use JSlider when users need intuitive control over a numeric range.
 * - Ideal for continuous or discrete values within a defined interval.
 * - Prefer sliders to text fields when visual feedback is important.
 */
import javax.swing.*;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Slider");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Slider
     * - Demonstrates a basic JSlider with minimum, maximum, and initial values.
     * - The constructor parameters define the value range and default position.
     * - The tooltip text is set using the setToolTipText() method.
     */
    JSlider slider1 = new JSlider(0, 10, 5);
    slider1.setToolTipText("This is a tooltip!");
    frame.add(slider1);

    /*
     * Slider With Labels
     * - Demonstrates a JSlider with tick marks and automatically generated labels.
     * - Major ticks define labeled intervals, while minor ticks provide finer granularity.
     * - Labels and ticks are enabled using setPaintLabels() and setPaintTicks().
     */
    JSlider slider2 = new JSlider(0, 10, 5);
    slider2.setMajorTickSpacing(5);
    slider2.setMinorTickSpacing(1);
    slider2.setPaintTicks(true);
    slider2.setPaintLabels(true);
    frame.add(slider2);

    /*
     * Slider With Custom Labels
     * - Demonstrates a JSlider with a custom label table.
     * - Custom labels allow replacing numeric values with descriptive text.
     * - The label table is defined using a Dictionary and applied via setLabelTable().
     */
    Dictionary<Integer, JLabel> labels = new Hashtable<>();
    labels.put(new Integer(0), new JLabel("Low"));
    labels.put(new Integer(5), new JLabel("Medium"));
    labels.put(new Integer(10), new JLabel("High"));
    JSlider slider3 = new JSlider(0, 10, 5);
    slider3.setMajorTickSpacing(5);
    slider3.setMinorTickSpacing(1);
    slider3.setPaintTicks(true);
    slider3.setPaintLabels(true);
    slider3.setLabelTable(labels);
    frame.add(slider3);

    /*
     * Disabled Slider
     * - Demonstrates a JSlider in a disabled state.
     * - Disabled sliders are visible but cannot be interacted with.
     * - Commonly used to indicate unavailable settings based on application state.
     * - The enabled state is controlled via the setEnabled() method.
     */
    JSlider slider4 = new JSlider(0, 10, 5);
    slider4.setMajorTickSpacing(5);
    slider4.setMinorTickSpacing(1);
    slider4.setPaintTicks(true);
    slider4.setPaintLabels(true);
    slider4.setEnabled(false);
    frame.add(slider4);

    /*
     * Slider Listener
     * - Demonstrates adding a ChangeListener to a JSlider.
     * - The listener is triggered whenever the slider value changes.
     * - The current numeric value is retrieved using getValue().
     * - Commonly used to react to continuous or discrete value adjustments.
     * - Output: <integer>
     */
    slider1.addChangeListener(evt -> IO.println(slider1.getValue()));

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
