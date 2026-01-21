/*
 * Default Methods
 * - This section explains default methods in Java interfaces and how they allow interfaces to provide a concrete
 *   implementation.
 *
 * Overview
 * - Default methods are methods with a body defined in an interface using the "default" keyword.
 * - They allow adding new methods to interfaces without breaking existing implementations.
 * - Classes implementing the interface can either use the default implementation or override it.
 *
 * Key Characteristics
 * - Declared with the "default" keyword inside an interface.
 * - Can provide common behavior for multiple implementing classes.
 * - Can be overridden in the implementing class to provide specific behavior.
 * - Help evolve interfaces without forcing changes in all implementing classes.
 *
 * Usage
 * - Use default methods to provide shared behavior in interfaces.
 * - Avoid code duplication across multiple implementing classes.
 * - Useful for backward-compatible interface evolution.
 * - Can be combined with abstract methods for flexible API design.
 */

/*
 * Interface Declaration With Default Methods
 * - The example below demonstrates a declaration of an interface with a default method.
 */
public interface Speaker {
    default void sayHello() {
        IO.println("Hello!");
    }
}

/*
 * Interface Implementation With Override
 * - Classes that implement the interface inherit the default method automatically.
 * - Classes can override default methods to provide their own behavior.
 */
public class Dog implements Speaker {
}
public class Cat implements Speaker {
    @Override
    public void sayHello() {
        IO.println("Cat says Hello!");
    }
}

/*
 * Usage Example
 * - Demonstrates the use of default methods in interfaces.
 */
void main() {
    Speaker dog = new Dog();
    Speaker cat = new Cat();

    dog.sayHello(); // Output: Hello! (default method)
    cat.sayHello(); // Output: Cat says Hello! (overridden default)
}