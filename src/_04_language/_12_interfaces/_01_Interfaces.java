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
 */

/*
 * Interface
 * - The example below demonstrates the "Speaker" interface, which defines a contract through the abstract method
 *   "speak".
 * - All interface methods are implicitly public, and therefore do not require an explicit access modifier.
 */
public interface Speaker {
    void speak();
}

/*
 * Implementations
 * - The classes below implement the "Speaker" interface and provide their own concrete behavior for the methods defined
 *   by the interface.
 */
public class Dog implements Speaker {
    @Override
    public void speak() {
        IO.println("woof!");
    }
}
public class Cat implements Speaker {
    @Override
    public void speak() {
        IO.println("meow!");
    }
}

/*
 * Abstract Classes
 * - Abstract classes may declare that they implement one or more interfaces.
 * - Implementing the interface methods is optional at this level and can be deferred to concrete (non-abstract)
 *   subclasses.
 */
public abstract class Animal implements Speaker {}

/*
 * Subclass Implementation
 * - A concrete subclass of Animal must provide an implementation for any interface methods declared by its abstract
 *   superclass.
 */
public class Fish extends Animal {
    @Override
    public void speak() {
        IO.println("glub!");
    }
}

/*
 * Example
 * - The example below demonstrates how an interface can be used as a variable type to achieve abstraction.
 * - It also shows that each implementing class provides its own specific behavior for the interface methods.
 */
void main() {
    Speaker dog = new Dog();
    Speaker cat = new Cat();
    Speaker fish = new Fish();

    dog.speak();  // Output: woof!
    cat.speak();  // Output: meow!
    fish.speak(); // Output: glub!
}