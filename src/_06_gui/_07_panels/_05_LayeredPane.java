/*
 * Layered Pane (JLayeredPane)
 * - This section explains the JLayeredPane component in Swing, which is a specialized container that allows components
 *   to overlap each other in different layers.
 *
 * Overview
 * - JLayeredPane is part of the javax.swing package.
 * - It extends JComponent and provides a flexible mechanism to control the Z-order of components.
 * - Unlike standard containers (like JPanel), components in a JLayeredPane can appear above or below each other based
 *   on their assigned layer.
 * - By default, JLayeredPane uses a null layout, so components must be manually positioned and sized.
 * - Useful for creating complex UI effects, popups, floating elements, or drag-and-drop interfaces.
 *
 * Key Characteristics
 * - Supports multiple layers, where each layer has an integer value to determine its stacking order.
 * - Higher layer numbers are displayed above lower layers.
 * - Components in the same layer follow the standard Z-order within that layer.
 * - Allows precise control over component positioning and visibility.
 * - To add a component, use the "add(component, layer)" method passing an Integer Wrapper value to determinate the
 *   layer: (i.e. "add(component, new Integer(1)")).
 *
 * Pre Defined Layers
 * - Layers can be predefined constants or custom integer values:
 *   - DEFAULT_LAYER (0)
 *   - PALETTE_LAYER (100)
 *   - MODAL_LAYER (200)
 *   - POPUP_LAYER (300)
 *   - DRAG_LAYER (400)
 *
 * Usage
 * - Use JLayeredPane when components need to overlap, such as floating toolbars, popup messages, or custom visual
 *   effects.
 * - Add components to a specific layer using add(Component comp, Integer layer) or setLayer(Component comp, int layer).
 * - Adjust component bounds and preferred sizes manually, as JLayeredPane does not manage layout by default.
 * - Combine with JScrollPane or other containers when scrollable or constrained areas are needed.
 * - Can be used to implement dragging, animation, or visual stacking effects in custom UIs.
 */
import javax.swing.*;

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the component.
     */
    JFrame frame = new JFrame("Layered Pane");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Panels
     * - The following JPanel instances are created to show the JLayeredPane behavior.
     */
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    panel1.setBounds(0, 0, 100, 100);
    panel2.setBounds(20, 20, 100, 100);
    panel3.setBounds(40, 40, 100, 100);
    panel1.setBorder(BorderFactory.createTitledBorder("Panel 1"));
    panel2.setBorder(BorderFactory.createTitledBorder("Panel 2"));
    panel3.setBorder(BorderFactory.createTitledBorder("Panel 3"));

    /*
     * Layered Pane
     * - Creates a JLayeredPane to demonstrate overlapping components in different layers.
     * - The layout is set to null to allow absolute positioning of components.
     * - Each panel is added with an explicit layer value, determining its stacking order.
     * - Higher layer values appear above lower layers, allowing components to overlap visually.
     * - Predefined layer constants from JLayeredPane could also be used.
     */
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.add(panel1, new Integer(1));
    layeredPane.add(panel2, new Integer(2));
    layeredPane.add(panel3, new Integer(3));
    frame.add(layeredPane);

    /*
     * Set Visible
     * - Makes the frame visible on the screen to demonstrate the layout in action.
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