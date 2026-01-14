/*
 * Interfaces
 * - This section explains interfaces in Java and how they define a contract for classes without providing full
 *   implementation.
 *
 * Overview
 * - An interface is a reference type that can contain:
 *   - Abstract methods (must be implemented by implementing classes)
 *   - Default methods (with concrete implementation)
 *   - Static methods (called on the interface itself, without an instance)
 * - Declared using the "interface" keyword.
 * - Classes implement interfaces to agree to provide implementations for the abstract methods.
 * - Interfaces support multiple inheritance of type, unlike classes which only support single inheritance.
 *
 * Key Characteristics
 * - All abstract methods in an interface are implicitly "public".
 * - Default methods can provide a concrete implementation for convenience and backward compatibility.
 * - Static methods belong to the interface itself and can be invoked without creating an instance.
 * - Fields in an interface are implicitly "public", "static", and "final".
 * - A class can implement multiple interfaces to achieve multiple inheritance of behavior.
 *
 * Usage
 * - Use interfaces to define a common contract for unrelated classes.
 * - Enable polymorphism, decoupling, and flexible design.
 * - Ideal for callbacks, strategy patterns, API definitions, or any scenario requiring multiple types to share
 *   behavior.
 * - Helps separate the “what” (interface) from the “how” (implementation) in object-oriented design.
 *
 * Example:
 * - The example demonstrates an interface "Speaker" with an abstract method "say".
 * - Classes "Dog" and "Cat" implement the interface and provide their own behavior.
 */
public interface Speaker {
    void say(); // Abstract method (public as default)
}

public class Dog implements Speaker {
    @Override
    public void say() {
        IO.println("woof!");
    }
}

public class Cat implements Speaker {
    @Override
    public void say() {
        IO.println("meow!");
    }
}

void main() {
    Speaker s1 = new Dog();
    Speaker s2 = new Cat();
    s1.say(); // woof!
    s2.say(); // meow!
}