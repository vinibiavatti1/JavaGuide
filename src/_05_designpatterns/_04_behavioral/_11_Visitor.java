/*
 * Visitor Design Pattern
 * - This section explains the "Visitor" design pattern, which lets you define new operations on a set of objects
 *   without changing the classes of the elements on which it operates.
 *
 * Overview
 * - The Visitor pattern is a behavioral design pattern.
 * - It separates algorithms from the object structure they operate on.
 * - New operations can be added without modifying existing element classes.
 * - It is especially useful when object structures are stable, but operations change frequently.
 *
 * Key Elements
 * - Visitor: defines a visit method for each concrete element type.
 * - ConcreteVisitor: implements the operations to be performed on elements.
 * - Element: defines an accept(Visitor) method.
 * - ConcreteElement: implements accept and calls the appropriate visit method.
 * - ObjectStructure: holds a collection of elements and allows visitors to traverse them.
 *
 * Key Characteristics
 * - Supports adding new behavior without modifying existing classes.
 * - Uses double dispatch to select the correct operation at runtime.
 * - Centralizes related operations into visitor classes.
 * - Makes adding new element types harder, as all visitors must be updated.
 *
 * Usage
 * - Use Visitor when you need to perform many unrelated operations on a stable object structure.
 * - Commonly used in compilers, AST processing, document object models, and reporting systems.
 * - Ideal when operations change frequently but element classes remain mostly unchanged.
 * - Avoid when the object structure changes often.
 */

/*
 * Visitor
 * - Defines a visit method for each concrete element type.
 */
public interface ShapeVisitor {
    void visitLine(Line line);
    void visitRect(Rect rect);
    void visitCircle(Circle circle);
}

/*
 * ConcreteVisitor
 * - Implements the operations to be performed on elements.
 */
public class SvgShapeExportVisitor implements ShapeVisitor {
    @Override
    public void visitLine(Line line) {
        IO.println(String.format("<line length='%d'/>", line.length));
    }

    @Override
    public void visitRect(Rect rect) {
        IO.println(String.format("<rect size='%d'/>", rect.size));
    }

    @Override
    public void visitCircle(Circle circle) {
        IO.println(String.format("<circle radius='%d'/>", circle.radius));
    }
}

/*
 * Element
 * - Defines an accept(Visitor) method.
 */
public interface Shape {
    void accept(ShapeVisitor visitor);
}

/*
 * ConcreteElement
 * - Implements accept and calls the appropriate visit method.
 */
public class Line implements Shape {
    private int length;

    public Line(int length) {
        this.length = length;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitLine(this);
    }
}
public class Rect implements Shape {
    private int size;

    public Rect(int size) {
        this.size = size;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRect(this);
    }
}
public class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}

/*
 * ObjectStructure
 * - Holds a collection of elements and allows visitors to traverse them.
 */
public class Canvas {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void exportToSvg() {
        SvgShapeExportVisitor visitor = new SvgShapeExportVisitor();
        shapes.forEach(x -> x.accept(visitor));
    }
}

/*
 * Strategy
 * - The example below shows the usage of the Visitor design pattern.
 */
void main() {
    Canvas canvas = new Canvas();

    canvas.add(new Line(3));
    canvas.add(new Rect(5));
    canvas.add(new Circle(7));

    canvas.exportToSvg();
    /*
     * Output:
     * <line length='3'/>
     * <rect size='5'/>
     * <circle radius='7'/>
     */
}