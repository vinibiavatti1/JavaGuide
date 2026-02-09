/*
 * Table (JTable)
 * - This section explains the JTable component in Swing, which is used to display and edit tabular data organized in
 *   rows and columns.
 *
 * Overview
 * - JTable is part of the javax.swing package.
 * - It follows the MVC (Model–View–Controller) design pattern.
 * - JTable itself acts as the View and Controller.
 * - All data, structure, and editing rules are defined in a TableModel.
 *
 * Table Model
 * - The TableModel is the core of JTable and represents the data layer.
 * - The model is responsible for:
 *   - Defining how many rows and columns exist.
 *   - Storing the value of each cell.
 *   - Defining the data type of each column.
 *   - Controlling whether cells are editable.
 * - Common TableModel implementations:
 *   - DefaultTableModel:
 *     - Easy to use and flexible.
 *     - Stores data internally as a Vector of Vectors.
 *     - Suitable for small tables, prototypes, and demos.
 *   - AbstractTableModel:
 *     - Recommended for production code.
 *     - Allows full control over data structure and typing.
 *     - Avoids unnecessary overhead and enforces strong design.
 *
 * Defining Columns and Data
 * - Columns are typically defined by a String array representing the column headers.
 * - Rows are defined as a two-dimensional Object array, where:
 *   - Each inner array represents a single row.
 *   - Each element in the row array corresponds to a column value.
 * - The order of elements in each row must match the column order.
 * - When using a custom TableModel, columns and rows are usually backed by custom data structures.
 *
 * Common Model Methods
 * - addRow(Object[]): adds a new row to the table.
 * - removeRow(int row): removes a row by its index.
 * - getValueAt(int row, int column): retrieves the value of a specific cell.
 * - setValueAt(Object value, int row, int column): updates a specific cell.
 * - getRowCount(): returns the number of rows.
 * - getColumnCount(): returns the number of columns.
 *
 * Column Class Rendering
 * - JTable uses the return value of getColumnClass(int) to choose renderers and editors.
 *   - Boolean: Rendered with a checkbox.
 *   - Number: Rendered by a right-aligned label.
 *   - Double, Float: Same as Number, but the object-to-text translation is performed by a NumberFormat instance.
 *   - Date: Rendered by a label, with the object-to-text translation performed by a DateFormat instance.
 *   - ImageIcon, Icon: Rendered by a centered label.
 *   - Object: Rendered by a label that displays the object's string value.
 *
 * Usage
 * - Use JTable for structured, editable data.
 * - Always prefer a custom TableModel for production code.
 * - Correct column classes are essential for proper rendering and editing behavior.
 */
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Table");
    frame.setSize(600, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new GridLayout(1, 2, 5, 5));

    /*
     * Table Columns
     * - Defines the column headers displayed by the table.
     * - The order of this array defines the column index.
     */
    String[] columns = new String[] { "Name", "Age", "Height", "Active" };

    /*
     * Table Rows
     * - Initial dataset used to populate the table.
     * - Each inner array represents a row.
     * - Values must match the column order and expected data types.
     */
    Object[][] rows = new Object[][] {
            { "John Duo",   35, 1.85, true  },
            { "Anna Smith", 28, 1.68, true  },
            { "Mark Lee",   42, 1.75, false },
            { "Sophia Kim", 31, 1.62, true  },
            { "Carlos Ruiz",39, 1.80, false }
    };

    /*
     * Simple Table (Default Model)
     * - JTable instantiated directly with rows and columns.
     * - Internally uses a DefaultTableModel with Object.class for all columns.
     * - This limits automatic renderer/editor selection.
     */
    JTable table1 = new JTable(rows, columns);
    JScrollPane scrollPane1 = new JScrollPane(
            table1,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    table1.setToolTipText("This is a tooltip!");
    frame.add(scrollPane1);

    /*
     * Custom Table Model
     * - Extends DefaultTableModel to explicitly define column data types.
     * - getColumnClass(...) is critical for correct rendering and editing.
     * - Boolean.class enables automatic checkbox rendering.
     */
    DefaultTableModel tableModel = new DefaultTableModel(rows, columns) {
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> String.class;
                case 1 -> Integer.class;
                case 2 -> Double.class;
                case 3 -> Boolean.class;
                default -> Object.class;
            };
        }
    };

    /*
     * Table With Custom Model
     * - Uses a model with strong typing per column.
     * - Enables proper editors (e.g., JCheckBox for Boolean values).
     */
    JTable table2 = new JTable(tableModel);
    JScrollPane scrollPane2 = new JScrollPane(
            table2,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
    );
    frame.add(scrollPane2);

    /*
     * Table Model Listener
     * - Listens for any structural or data changes in the table model.
     * - Triggered on cell edits, row insertions, removals, or updates.
     * - Data should always be accessed through the model, not directly from JTable.
     */
    table1.getModel().addTableModelListener(new TableModelListener() {
        @Override
        public void tableChanged(TableModelEvent e) {
            IO.println(table1.getModel().getValueAt(0, 0)); // Output: value at row 0, column 0
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
