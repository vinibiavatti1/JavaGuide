/*
 * Factory Method Design Pattern
 * - This section explains the "Factory Method" design pattern, which defines an interface for creating an object, but
 *   lets subclasses decide which class to instantiate.
 *
 * Overview
 * - The Factory Method pattern is a creational design pattern.
 * - It allows a class to defer instantiation to subclasses.
 * - The pattern promotes loose coupling by eliminating the need to bind application-specific classes into the code.
 * - Commonly used when a class cannot anticipate the class of objects it must create or wants its subclasses to specify
 *   them.
 *
 * Key Elements
 * - Product: declares the interface of objects the factory method creates.
 * - ConcreteProduct: implements the Product interface.
 * - Creator: declares the factory method, which returns an object of type Product. May also define a default
 *   implementation.
 * - ConcreteCreator: overrides the factory method to return an instance of a ConcreteProduct.
 *
 * Key Characteristics
 * - Encapsulates object creation within a method, rather than using a constructor directly.
 * - Supports extension: new ConcreteProducts can be added without changing existing code.
 * - Promotes flexibility and loose coupling between client code and concrete classes.
 * - Allows subclasses to decide which specific class to instantiate.
 *
 * Usage
 * - Use Factory Method when a class wants its subclasses to specify the objects it creates.
 * - Apply when a class cannot anticipate the type of objects it must create.
 * - Ideal for frameworks and libraries where the exact types of objects are determined by client code.
 * - Avoid using Factory Method when object creation is straightforward and does not need flexibility or extensibility.
 */

/*
 * Product
 * - Declares the interface of objects the factory method creates.
 */
public interface Button {
    String render();
}

/*
 * ConcreteProduct
 * - Implements the Product interface.
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
 * Creator
 * - Declares the factory method, which returns an object of type Product. May also define a default implementation.
 */
public abstract class Frame {
    public abstract Button buildButton(); // <- Factory Method

    public void showMessageDialog() {
        Button button = this.buildButton();
        IO.println("Click on the button to confirm: " + button.render());
    }
}

/*
 * ConcreteCreator
 * - Overrides the factory method to return an instance of a ConcreteProduct.
 */
public class FlatFrame extends Frame {
    @Override
    public Button buildButton() {
        return new FlatButton();
    }
}
public class RoundedFrame extends Frame {
    @Override
    public Button buildButton() {
        return new RoundedButton();
    }
}

/*
 * Example
 * - The example below shows the usage of the Factory Method design pattern.
 */
void main() {
    FlatFrame flatFrame = new FlatFrame();
    RoundedFrame roundedFrame = new RoundedFrame();

    flatFrame.showMessageDialog();    // Click on the button to confirm: [CONFIRM]
    roundedFrame.showMessageDialog(); // Click on the button to confirm: (CONFIRM)
}