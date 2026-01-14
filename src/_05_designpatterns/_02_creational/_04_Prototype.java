/*
 * Prototype Design Pattern
 * - This section explains the "Prototype" design pattern, which allows creating new objects by copying existing ones,
 *   avoiding the cost of creating objects from scratch.
 *
 * Overview
 * - The Prototype pattern is a creational design pattern.
 * - It enables object creation by cloning a prototype instance rather than instantiating a class directly.
 * - Useful when the cost of creating a new object is expensive or complex.
 * - Promotes flexibility by allowing new object types to be added dynamically at runtime.
 *
 * Key Elements
 * - Prototype: declares an interface for cloning itself.
 * - ConcretePrototype: implements the cloning operation to produce a copy of itself.
 * - Client: creates a new object by asking a prototype to clone itself instead of instantiating a new object directly.
 *
 * Key Characteristics
 * - Supports object cloning, either shallow or deep, depending on the implementation.
 * - Reduces subclassing by creating objects dynamically.
 * - Enables copying of objects without coupling to their concrete classes.
 * - Useful in systems where new instances are similar to existing ones or where object creation is costly.
 *
 * Usage
 * - Use Prototype when object creation is expensive or complex.
 * - Apply when you want to create new objects dynamically at runtime without knowing their exact types.
 * - Ideal for scenarios like graphical objects, game characters, or configuration templates.
 * - Ensure that cloning correctly handles mutable fields to avoid unexpected side effects.
 */

/*
 * Prototype
 * - Declares an interface for cloning itself.
 */
public abstract class AbstractButton {
    private String label;
    private String markup;

    public AbstractButton(String label, String markup) {
        this.label = label;
        this.markup = markup;
    }

    public abstract AbstractButton clone();

    public String render() {
        return String.format(markup, label);
    }

    public String getLabel() {
        return label;
    }

    public AbstractButton setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getMarkup() {
        return markup;
    }
}

/*
 * ConcretePrototype
 * - Implements the cloning operation to produce a copy of itself.
 */
public class Button extends AbstractButton {

    public Button(String label, String markup) {
        super(label, markup);
    }

    public Button(Button other) {
        super(other.getLabel(), other.getMarkup());
    }

    @Override
    public AbstractButton clone() {
        return new Button(this);
    }
}

/*
 * Client
 * - Creates a new object by asking a prototype to clone itself instead of instantiating a new object directly.
 */
public class Frame {
    public void showConfirmDialog() {
        // Used prototype pattern to build the buttons
        AbstractButton yesBtn = new Button("YES", "[%s]");
        AbstractButton noBtn = yesBtn.clone().setLabel("NO");
        AbstractButton cancelBtn = yesBtn.clone().setLabel("CANCEL");
        IO.println(String.format("Are you sure? %s %s %s", yesBtn.render(), noBtn.render(), cancelBtn.render()));
    }
}

/*
 * Example
 * - The example below shows the usage of the Prototype design pattern.
 */
void main() {
    Frame frame = new Frame();
    frame.showConfirmDialog();
}