/*
Default Methods
- This section explains default methods in Java interfaces and how they allow interfaces to provide a concrete
  implementation.

Overview
- Default methods are methods with a body defined in an interface using the "default" keyword.
- They allow adding new methods to interfaces without breaking existing implementations.
- Classes implementing the interface can either use the default implementation or override it.

Key Characteristics
- Declared with the "default" keyword inside an interface.
- Can provide common behavior for multiple implementing classes.
- Can be overridden in the implementing class to provide specific behavior.
- Help evolve interfaces without forcing changes in all implementing classes.

Usage
- Use default methods to provide shared behavior in interfaces.
- Avoid code duplication across multiple implementing classes.
- Useful for backward-compatible interface evolution.
- Can be combined with abstract methods for flexible API design.

Example:
- The example demonstrates an interface "Speaker" with a default method "greet".
- Classes "Dog" and "Cat" implement the interface and inherit or override the default behavior.
*/
public interface Speaker {
    // Default method
    default void sayHello() {
        IO.println("Hello!");
    }
}

public class Dog implements Speaker {
}

public class Cat implements Speaker {
    @Override
    public void sayHello() {
        IO.println("Cat says Hello!");
    }
}

void main() {
    Speaker s1 = new Dog();
    Speaker s2 = new Cat();
    s1.sayHello(); // Hello! (default method)
    s2.sayHello(); // Cat says Hello! (overridden default)
}