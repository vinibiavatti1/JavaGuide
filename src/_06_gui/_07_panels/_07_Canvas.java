/*
 * Canvas (JPanel)
 * - This section demonstrates using a JPanel as a drawing canvas in Swing.
 *
 * Overview
 * - A canvas is a surface where custom graphics, shapes, and text can be rendered.
 * - JPanel can serve as a canvas because it provides a lightweight, repaintable area, supports custom painting through
 *   paint() or paintComponent(), and integrates with Swing's event and layout system.
 * - The canvas allows drawing shapes, lines, text, and images programmatically.
 * - It can respond to mouse and keyboard events for interactive graphics.
 *
 * Key Characteristics
 * - Supports custom rendering and repainting.
 * - Can be used for simple illustrations, games, simulations, or visualizations.
 * - Can contain child components if needed, allowing layering or overlaying controls.
 *
 * Paint Methods
 * - paint():
 *   - The top-level painting method in JComponent.
 *   - Coordinates painting of the component itself, borders, and child components.
 *   - Usually not overridden for custom drawing; paintComponent() is preferred.
 * - paintComponent():
 *   - The primary method for custom drawing in Swing.
 *   - Responsible only for painting the component's content (the "interior").
 *   - Called automatically by the Swing repaint system.
 *   - Always call super.paintComponent(g) to ensure proper background clearing and default behavior.
 *
 * Component Refresh Methods
 * - revalidate():
 *   - Informs the layout manager that the component's size, layout, or hierarchy changed.
 *   - Layout will be recalculated during the next Swing layout pass.
 *   - Often called after adding/removing components or resizing, typically followed by repaint().
 * - repaint():
 *   - Schedules a call to the painting system to refresh the component's display.
 *   - Triggers Swing to eventually call paint() / paintComponent() asynchronously.
 *   - Use when component visuals have changed.
 *
 * Usage
 * - Use a JPanel as a canvas for rendering custom graphics in Swing applications.
 * - Override paint() or paintComponent() to draw shapes, images, or text.
 * - For complex or animated graphics, consider double buffering to avoid flickering.
 * - Combine with mouse/keyboard events for interactive applications.
 */
import javax.swing.*;
import java.awt.*;

/*
 * Canvas
 * - Demonstrates a JPanel used as a canvas for custom painting.
 * - The paintComponent() method is overridden to draw shapes, lines, and text.
 * - The Graphics object provides methods for 2D rendering, colors, and fonts.
 */
public class Canvas extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clears the background and performs default rendering

        // Draw a filled rectangle
        g.setColor(Color.BLUE);
        g.fillRect(50, 30, 100, 50);

        // Draw a filled circle
        g.setColor(Color.RED);
        g.fillOval(200, 30, 50, 50);

        // Draw a line
        g.setColor(Color.BLACK);
        g.drawLine(50, 100, 300, 100);

        // Draw a string
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("Canvas Drawing Example", 50, 150);

        // Draw a rectangle outline
        g.setColor(Color.GREEN);
        g.drawRect(50, 170, 100, 50);

        // Draw a filled oval with outline
        g.setColor(Color.ORANGE);
        g.fillOval(200, 170, 50, 50);
        g.setColor(Color.BLACK);
        g.drawOval(200, 170, 50, 50);
    }
}

void example() {
    /*
     * Declaring Frame
     * - A new JFrame will be created to demonstrate the canvas.
     */
    JFrame frame = new JFrame("Canvas");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    /*
     * Canvas
     * - A new instance of the Canvas class above will be created and inserted to the frame.
     */
    Canvas canvas = new Canvas();
    frame.add(canvas);

    /*
     * Refresh Methods Example
     * - Demonstrates refreshing the component's layout and visual appearance.
     * - revalidate() tells the layout manager to recalculate layout.
     * - repaint() requests the component to redraw its content.
     * - Both are often used together after changing component structure or appearance.
     */
    canvas.revalidate();
    canvas.repaint();

    /*
     * Set Visible
     * - Displays the JFrame on the screen to demonstrate the custom painting.
     */
    frame.setVisible(true);
}

/*
 * EDT Initialization
 * - Launches the Swing application safely by scheduling the GUI initialization
 *   on the Event Dispatch Thread (EDT).
 */
void main() {
    SwingUtilities.invokeLater(() -> {
        example();
    });
}
