/*
Sealed Interfaces
This section explains sealed interfaces in Java, introduced in Java 17. 
A sealed interface restricts which classes or interfaces can implement it, providing more control over hierarchy design.

Overview
- Declared with the "sealed" keyword followed by "interface".
- Use the "permits" clause to list the allowed implementing classes or interfaces.
- Only the permitted classes/interfaces can implement the sealed interface.
- Permitted implementers must be declared as "final", "sealed", or "non-sealed".

Key Characteristics
- Improves encapsulation and hierarchy safety.
- Allows the compiler to know all possible implementations.
- Useful for pattern matching and controlled polymorphism.

Example:
- The "Shape" interface is sealed and only allows "Circle" and "Square" to implement it.
- "Circle" is final, so no further subclassing is allowed.
- "Square" is non-sealed, allowing other classes to extend it.
*/
@SuppressWarnings("all")
public sealed interface Animal permits Dog, Cat {
    void say();
}

/*
Implementing Interface
This example demonstrates how classes implement the Speaker interface.
*/
@SuppressWarnings("all")
public final class Dog implements Animal {
    @Override
    public void say() {
        IO.println("woof!");
    }
}

/*
Implementing Interface
This example demonstrates how classes implement the Speaker interface.
*/
@SuppressWarnings("all")
public non-sealed class Cat implements Animal {
    @Override
    public void say() {
        IO.println("meaw!");
    }
}

/*
Usage Example
- Demonstrates creating instances of `Dog` and `Cat` and calling their `say()` methods.
- Only the permitted classes can implement the sealed interface `Animal`.
*/
@SuppressWarnings("all")
void main() {
    Animal a1 = new Dog();
    Animal a2 = new Cat();
    a1.say(); // woof!
    a2.say(); // meaw!
}