/*
 * Builder Design Pattern
 * - This section explains the "Builder" design pattern, which separates the construction of a complex object from its
 *   representation, allowing the same construction process to create different representations.
 *
 * Overview
 * - The Builder pattern is a creational design pattern.
 * - It is used to construct complex objects step by step.
 * - It allows objects to be created in a controlled, flexible way without directly calling a complex constructor.
 * - Commonly used in scenarios where an object has many optional parameters or complex initialization logic.
 *
 * Key Elements
 * - Builder: defines the interface for creating parts of a product.
 * - ConcreteBuilder: implements the Builder interface to construct and assemble parts of the product.
 * - Director: controls the construction process using a Builder object.
 * - Product: represents the complex object being built.
 *
 * Key Characteristics
 * - Encapsulates construction logic from the main business logic.
 * - Supports fluent interfaces and chaining to improve readability.
 * - Helps avoid telescoping constructors (many constructor overloads for optional parameters).
 * - Allows the same construction process to create different variations of an object.
 *
 * Usage
 * - Use Builder when an object requires multiple steps to construct or has many optional fields.
 * - Use Director to standardize construction sequences, or let clients build directly for more flexibility.
 * - Apply method chaining in ConcreteBuilder for a fluent interface.
 * - Ideal for creating immutable objects or objects with complex internal structures.
 */

/*
 * Builder
 * - Defines the interface for creating parts of a product.
 */
public interface ButtonBuilder {
    ButtonBuilder withLabel(String label);
    ButtonBuilder withMarkup(String markup);
    Button build();
}

/*
 * ConcreteBuilder
 * - Implements the Builder interface to construct and assemble parts of the product.
 */
public class ConcreteButtonBuilder implements ButtonBuilder {
    private String label;
    private String markup;

    public ButtonBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public ButtonBuilder withMarkup(String markup) {
        this.markup = markup;
        return this;
    }

    public Button build() {
        return new Button(label, markup);
    }
}

/*
 * Director
 * - Controls the construction process using a Builder object.
 */
public class ButtonDirector {
    private ButtonBuilder buttonBuilder;

    public ButtonDirector(ButtonBuilder buttonBuilder) {
        this.buttonBuilder = buttonBuilder;
    }

    public Button buildFlatButton(String label) {
        return this.buttonBuilder
                .withLabel(label)
                .withMarkup("[%s]")
                .build();
    }

    public Button buildRoundedButton(String label) {
        return this.buttonBuilder
                .withLabel(label)
                .withMarkup("(%s)")
                .build();
    }
}

/*
 * Product
 * - Represents the complex object being built.
 */
public class Button {
    private String label;
    private String markup;

    public Button(String label, String markup) {
        this.label = label;
        this.markup = markup;
    }

    public void show() {
        IO.println(String.format(markup, label));
    }
}

/*
 * Example
 * - The example below shows the usage of the Builder design pattern.
 */
void main() {
    ButtonBuilder buttonBuilder = new ConcreteButtonBuilder();
    ButtonDirector buttonDirector = new ButtonDirector(buttonBuilder);

    Button flatButton = buttonDirector.buildFlatButton("CLICK");
    Button roundedButton = buttonDirector.buildRoundedButton("CLICK");

    flatButton.show();    // Output: [CLICK]
    roundedButton.show(); // Output: (CLICK)
}