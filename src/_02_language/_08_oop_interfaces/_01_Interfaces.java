/*
Interfaces
This section explains what interfaces are in Java and how they are used to define contracts for classes.

Overview
- An interface is an abstract type that defines a set of methods without implementations.
- Classes that implement the interface must provide concrete implementations for all its methods.
- Interfaces are used to define behavior that can be shared across multiple classes, regardless of their class 
  hierarchy.

Key Characteristics
- Interfaces cannot have instance fields (except constants declared as "public static final").
- Methods are implicitly "public" and abstract.
- A class can implement multiple interfaces (supports multiple inheritance of type).
- Provides a way to achieve polymorphism and decoupling.

Usage
- Define a contract that multiple classes can follow.
- Enable polymorphic behavior without forcing a class hierarchy.
- Commonly used for callbacks, event listeners, service APIs, and strategy patterns.
*/
@SuppressWarnings("all")
public interface Speaker {
    // Abstract method (must be implemented by any class implementing this interface)
    void say(String message);
}

/*
Implementing Interface
This example demonstrates how classes implement the Speaker interface.
*/
@SuppressWarnings("all")
public class Dog implements Speaker {
    @Override
    public void say(String message) {
        IO.println("Dog says: " + message);
    }
}

/*
Implementing Interface
This example demonstrates how classes implement the Speaker interface.
*/
@SuppressWarnings("all")
public class Cat implements Speaker {
    @Override
    public void say(String message) {
        IO.println("Cat says: " + message);
    }
}

/*
Usage Example
This example demonstrates how classes implement the Speaker interface.
*/
@SuppressWarnings("all")
void main() {
    Speaker s1 = new Dog();
    Speaker s2 = new Cat();
    s1.say("Woof!"); // Dog says: Woof!
    s2.say("Meaw!"); // Cat says: Meaw!
}