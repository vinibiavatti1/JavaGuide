/*
 * Composite Design Pattern
 * - This section explains the "Composite" design pattern, which allows treating individual objects and compositions of
 *   objects uniformly through a common interface.
 *
 * Overview
 * - The Composite pattern is a structural design pattern.
 * - It composes objects into tree structures to represent part-whole hierarchies.
 * - It lets clients treat single objects and groups of objects in the same way.
 * - Commonly used to model hierarchical structures such as file systems, UI components, or organization trees.
 *
 * Key Elements
 * - Component: declares the common interface for both leaf and composite objects.
 * - Leaf: represents individual objects in the composition with no children.
 * - Composite: represents a group of components and implements child-related operations.
 * - Client: interacts with objects through the Component interface.
 *
 * Key Characteristics
 * - Simplifies client code by allowing uniform treatment of individual and composite objects.
 * - Supports recursive composition and tree-like structures.
 * - Makes it easy to add new component types.
 * - Encourages consistency in object hierarchies.
 *
 * Usage
 * - Use Composite when you need to represent part-whole hierarchies.
 * - Apply when clients should not care whether they are dealing with a single object or a collection.
 * - Ideal for tree structures like file systems, menus, UI widgets, or graphics scenes.
 * - Avoid overusing when the hierarchy is simple, as it may introduce unnecessary complexity.
 */

/*
 * Component
 * - Declares the common interface for both leaf and composite objects.
 */
public interface Graphic {
    void draw();
}

/*
 * Leaf
 * - Represents individual objects in the composition with no children.
 */
public class Cross implements Graphic {
    @Override
    public void draw() {
        IO.print(" X ");
    }
}
public class Circle implements Graphic {
    @Override
    public void draw() {
        IO.print(" O ");
    }
}

/*
 * Composite
 * - Represents a group of components and implements child-related operations.
 */
public class GraphicsGroup implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public GraphicsGroup(Graphic... graphics) {
        this.graphics.addAll(Arrays.asList(graphics));
    }

    @Override
    public void draw() {
        IO.print("(");
        graphics.forEach(Graphic::draw);
        IO.print(")");
    }
}

/*
 * Client
 * - Interacts with objects through the Component interface.
 */
public class Canvas {
    public void render(Graphic... graphics) {
        Arrays.stream(graphics).forEach(Graphic::draw);
    }
}

/*
 * Example
 * - The example below shows the usage of the Composite design pattern.
 */
void main() {
    Canvas canvas = new Canvas();
    canvas.render(
        new GraphicsGroup(
            new Cross(),
            new Circle(),
            new GraphicsGroup(
                new Cross(),
                new Circle(),
                new GraphicsGroup(
                    new Cross(),
                    new Circle()
                )
            )
        )
    );
    // Output: ( X  O ( X  O ( X  O )))
}