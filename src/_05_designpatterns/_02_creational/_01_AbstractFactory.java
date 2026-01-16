/*
 * Abstract Factory Design Pattern
 * - This section explains the "Abstract Factory" design pattern, which provides an interface for creating families of
 *   related or dependent objects without specifying their concrete classes.
 *
 * Overview
 * - The Abstract Factory pattern is a creational design pattern.
 * - It allows a client to create objects from a family of related types without coupling to their concrete
 *   implementations.
 * - Each factory produces objects that are compatible with each other.
 * - Commonly used when a system must be independent of how its products are created, composed, or represented.
 *
 * Key Elements
 * - AbstractFactory: declares the interface for creating abstract product objects.
 * - ConcreteFactory: implements the AbstractFactory interface to produce concrete products of a specific family.
 * - AbstractProduct: declares an interface for a type of product object.
 * - ConcreteProduct: defines a product object to be created by the corresponding Concrete Factory.
 * - Client: uses only the interfaces declared by AbstractFactory and AbstractProduct, remaining independent of concrete
 *   classes.
 *
 * Key Characteristics
 * - Encapsulates object creation logic for multiple related products.
 * - Ensures compatibility among products of the same family.
 * - Promotes consistency in product families and reduces coupling to concrete implementations.
 * - Supports easy switching between product families by changing the factory object.
 *
 * Usage
 * - Use Abstract Factory when a system should be independent of how products are created or represented.
 * - Apply when multiple families of related objects are needed and must be used together consistently.
 * - Ideal for cross-platform applications, GUI toolkits, or any scenario where object families must remain compatible.
 * - Avoid using it when there is only one product family or when adding new product types frequently, as it may
 *   increase complexity.
 */

/*
 * AbstractFactory
 * - Declares the interface for creating abstract product objects.
 */
public interface ComponentFactory {
    Button buildButton();
}

/*
 * ConcreteFactory
 * - Implements the AbstractFactory interface to produce concrete products of a specific family.
 */
public class FlatComponentFactory implements ComponentFactory {
    @Override
    public Button buildButton() {
        return new FlatButton();
    }
}
public class RoundedComponentFactory implements ComponentFactory {
    @Override
    public Button buildButton() {
        return new RoundedButton();
    }
}

/*
 * AbstractProduct
 * - Declares an interface for a type of product object.
 */
public interface Button {
    String render();
}

/*
 * ConcreteProduct
 * - Defines a product object to be created by the corresponding Concrete Factory.
 */
public class FlatButton implements Button {
    @Override
    public String render() {
        return "[CONFIRM]";
    }
}
public class RoundedButton implements Button {
    @Override
    public String render() {
        return "(CONFIRM)";
    }
}

/*
 * Client
 * - Uses only the interfaces declared by Abstract Factory and Abstract Product, remaining independent of concrete
 *   classes.
 */
public class Frame {
    private ComponentFactory componentFactory;

    public Frame(ComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    public void showMessageDialog() {
        Button button = componentFactory.buildButton();
        IO.println("Click on the button to confirm: " + button.render());
    }
}

/*
 * Example
 * - The example below shows the usage of the Abstract Factory design pattern.
 */
void main() {
    Frame flatFrame = new Frame(new FlatComponentFactory());
    Frame roundedFrame = new Frame(new RoundedComponentFactory());

    flatFrame.showMessageDialog();    // Output: Click on the button to confirm: [CONFIRM]
    roundedFrame.showMessageDialog(); // Output: Click on the button to confirm: (CONFIRM)
}