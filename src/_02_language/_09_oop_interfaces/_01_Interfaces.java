/*
Interfaces
This section explains interfaces in Java and how they define a contract for classes without providing full
implementation.

Overview
- An interface is a reference type that can contain abstract methods, default methods, and static methods.
- Declared using the "interface" keyword.
- Classes implement interfaces to agree to provide implementations for the abstract methods.
- Supports multiple inheritance of type, unlike classes which only support single inheritance.

Key Characteristics
- All abstract methods in an interface are implicitly public (the public keyword can be hidden).
- Default methods can provide a concrete implementation.
- Static methods belong to the interface and can be called without an instance.
- Fields are implicitly public, static, and final.
- A class can implement multiple interfaces to achieve multiple inheritance of behavior.

Usage
- Use interfaces to define a common contract for unrelated classes.
- Enable polymorphism and flexible design.
- Decouple code from concrete implementations.
- Commonly used for callbacks, strategy patterns, and API definitions.

Example:
- The example demonstrates an interface "Speaker" with an abstract method "say".
- Classes "Dog" and "Cat" implement the interface and provide their own behavior.
*/
public interface Speaker {
    // Abstract method (public as default)
    void say();
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