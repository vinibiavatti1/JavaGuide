/*
 * Spinner (JSpinner)
 * - This section explains the JSpinner component in Swing, which represents a single-line value selector that allows
 *   the user to cycle through a sequence of values.
 *
 * Overview
 * - JSpinner is part of the javax.swing package.
 * - It extends JComponent and combines a value model, editor, and optional arrows for incrementing/decrementing values.
 * - JSpinner is a compound component: the editable field is a child JTextField inside the spinner's editor.
 * - Commonly used for numbers, dates, or selecting from a list of options.
 *
 * Key Characteristics
 * - The editor's JTextField can be customized, for example to set the number of visible columns.
 * - Fully supports keyboard navigation, focus, and accessibility.
 * - Supports ChangeListeners to detect value changes, similar to a DocumentListener for JTextField.
 *
 * Dimension Control
 * - JSpinner is a composite Swing component that combines a text field with up/down arrow buttons.
 * - To control its preferred width in terms of characters, you must access the editor's text field.
 * - Example: ((JSpinner.NumberEditor) spinner.getEditor()).getTextField().setColumns(...);
 *
 * Models
 * - JSpinner supports multiple models:
 *   - SpinnerNumberModel: default model for numeric ranges (default for new JSpinner()).
 *   - SpinnerListModel: for cycling through arbitrary lists of objects.
 *   - SpinnerDateModel: for selecting date and time values.
 *
 * Usage
 * - Use JSpinner for numeric input, date selection, or enumerated choices where arrow controls improve UX.
 * - Attach ChangeListeners to respond whenever the value is modified by the user or programmatically.
 * - Customize the editor to adjust appearance, column width, or formatting.
 * - Can be combined with tooltips for contextual help.
 */
import javax.swing.*;
import java.awt.*;

void example() throws ParseException {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Spinner");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLayout(new FlowLayout());

    /*
     * Spinner With Number Model (Default)
     * - Demonstrates a JSpinner using the default SpinnerNumberModel.
     * - This model allows selecting a number within a defined range with a specified step size: (value, minimum,
     *   maximum, stepsize).
     * - JSpinner is a compound component; the editor must be accessed to customize the underlying JTextField.
     * - Here, setColumns() is used on the NumberEditor to control the visible width of the field.
     * - A tooltip is added to provide contextual help.
     */
    SpinnerNumberModel numberModel = new SpinnerNumberModel(5, 0, 10, 1);
    JSpinner spinner1 = new JSpinner(numberModel);
    ((JSpinner.NumberEditor) spinner1.getEditor()).getTextField().setColumns(18);
    spinner1.setToolTipText("This is a tooltip!");
    frame.add(spinner1);

    /*
     * Spinner With List Model
     * - Demonstrates a JSpinner using a SpinnerListModel.
     * - This model allows cycling through a fixed list of values.
     * - The editor must be accessed to adjust the visible column width for proper display.
     */
    SpinnerListModel listModel = new SpinnerListModel(java.util.List.of("Default", "Light", "Dark"));
    JSpinner spinner2 = new JSpinner(listModel);
    ((JSpinner.ListEditor) spinner2.getEditor()).getTextField().setColumns(18);
    frame.add(spinner2);

    /*
     * Spinner With Date Model
     * - Demonstrates a JSpinner using a SpinnerDateModel.
     * - This model allows selecting dates within a defined range with a specified calendar field.
     * - The editor must be accessed to adjust the visible column width.
     * - Dates are formatted using a SimpleDateFormat for display.
     * - Note: SpinnerDateModel works with java.util.Date (legacy). To use java.time.LocalDate or other modern date/time
     *   types, manual conversion between Date and LocalDate is required.
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SpinnerDateModel dateModel = new SpinnerDateModel(
            dateFormat.parse("2025-01-01"),
            dateFormat.parse("2020-07-15"),
            dateFormat.parse("2030-12-31"),
            Calendar.DAY_OF_MONTH
    );
    JSpinner spinner3 = new JSpinner(dateModel);
    ((JSpinner.DateEditor) spinner3.getEditor()).getTextField().setColumns(18);
    frame.add(spinner3);

    /*
     * Spinner With Content
     * - Demonstrates a JSpinner initialized with a specific value.
     * - The value is set programmatically using setValue().
     * - The editor is accessed to set the visible column width.
     */
    JSpinner spinner4 = new JSpinner();
    ((JSpinner.NumberEditor) spinner4.getEditor()).getTextField().setColumns(18);
    spinner4.setValue(100);
    frame.add(spinner4);

    /*
     * Disabled Spinner
     * - Demonstrates a JSpinner in a disabled state.
     * - Disabled spinners are visible but cannot be edited or incremented/decremented.
     * - The enabled state is controlled using setEnabled().
     * - The editor is still accessed to set the column width for consistent layout.
     */
    JSpinner spinner5 = new JSpinner();
    ((JSpinner.NumberEditor) spinner5.getEditor()).getTextField().setColumns(18);
    spinner5.setEnabled(false);
    frame.add(spinner5);

    /*
     * Change Listener
     * - Demonstrates how to listen for value changes in a JSpinner.
     * - A ChangeListener is triggered whenever the spinner value is modified by the user or programmatically.
     * - This is equivalent to using a DocumentListener for JTextField.
     * - The current value can be retrieved using getValue().
     * - Output: <content of first spinner>
     */
    spinner1.getModel().addChangeListener(evt -> IO.println(spinner1.getValue()));

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
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    });
}
