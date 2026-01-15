/*
 * Method Override
 * - This section explains method overriding in Java and how subclasses can provide their own implementation of
 *   inherited methods.
 *
 * Overview
 * - Method overriding occurs when a subclass defines a method with the same signature (name and parameters) as a method
 *   in its superclass.
 * - The overriding method replaces the behavior of the superclass method when called on an instance of the subclass.
 * - Enables runtime polymorphism, allowing the program to choose the appropriate method implementation based on the
 *   object's actual type.
 *
 * Key Characteristics
 * - The overridden method is resolved at runtime according to the actual type of the object.
 * - The superclass method must not be private; it can be public, protected, or package-private.
 * - Using the "@Override" annotation is recommended to ensure the method correctly overrides a superclass method.
 * - Overriding allows subclasses to specialize, extend, or modify inherited behavior.
 * - Supports polymorphic design patterns and flexible, extensible code.
 *
 * Usage
 * - Use overriding to customize behavior in subclasses without modifying the superclass.
 * - Implement different behaviors for the same method across related classes.
 * - Enable polymorphic designs where code works with abstract types or superclass references.
 * - Improve code extensibility, maintainability, and reusability.
 */

/*
 * Superclass Declaration
 * - Demonstrates a superclass "Animal" with a method "speak" that can be inherited or overridden by subclasses.
 */
public class Animal {
    public void speak() {
        IO.println("woof!");
    }
}

/*
 * Method Override
 * - Demonstrates two subclasses of Animal:
 *   1. Dog: inherits the speak() method without changes.
 *   2. Cat: overrides the speak() method to provide its own behavior.
 * - Use of @Override ensures that the method signature matches a method in the superclass.
 */
public class Dog extends Animal {
}
public class Cat extends Animal {
    @Override
    public void speak() { // Override say() method from Animal with new logic
        IO.println("meow!");
    }
}

/*
 * Usage Example
 * - Shows the difference between inherited and overridden methods.
 */
void main() {
    Animal dog = new Dog();
    Animal cat = new Cat();

    dog.speak(); // Output: woof! (inherited from Animal)
    cat.speak(); // Output: meow! (overridden in Cat)
}