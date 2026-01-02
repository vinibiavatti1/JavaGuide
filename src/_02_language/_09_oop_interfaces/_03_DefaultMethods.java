/*
Interfaces with Default Methods
This section explains what default methods are in Java interfaces and how they allow adding behavior without breaking
existing implementations.

Overview
- Default methods are methods in interfaces that provide a default implementation.
- Classes implementing the interface can use the default implementation or override it.
- Default methods help evolve interfaces by adding new functionality without forcing all implementing classes to
  implement the new methods.

Key Characteristics
- Declared using the "default" keyword in the interface.
- Can have a method body, unlike regular abstract interface methods.
- Classes can override default methods to provide specific behavior.
- Support polymorphism and code reuse in interfaces.

Usage
- Add new functionality to interfaces without breaking existing code.
- Provide common behavior to multiple implementing classes.
- Combine default methods with abstract methods for flexible contracts.
*/
@SuppressWarnings("all")
public interface Speaker {
    // Default method
    default void sayHello() {
        IO.println("Hello!");
    }
}

/*
Implementing Interface Example: Dog
This class implements the Speaker interface. It uses the default sayHello method without overriding it.
*/
@SuppressWarnings("all")
public class Dog implements Speaker {}

/*
Implementing Interface Example: Cat
This class implements the Speaker interface and overrides the default sayHello method.
*/
@SuppressWarnings("all")
public class Cat implements Speaker {
    @Override
    public void sayHello() {
        IO.println("Cat says Hello!");
    }
}

/*
Usage Example
This example demonstrates polymorphic behavior with default methods in interfaces.
*/
@SuppressWarnings("all")
void main() {
    Speaker s1 = new Dog();
    Speaker s2 = new Cat();
    s1.sayHello(); // Hello! (default method)
    s2.sayHello(); // Cat says Hello! (overridden default)
}