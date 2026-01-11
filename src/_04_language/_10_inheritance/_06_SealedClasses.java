/*
Sealed Classes
- This section explains sealed classes in Java and how they restrict which classes can extend or implement them.

Overview
- A sealed class or interface restricts which other classes or interfaces are allowed to inherit from or implement it.
- Declared using the "sealed" keyword along with the "permits" clause, which lists the allowed subclasses.
- Promotes controlled inheritance, clear API contracts, and a well-defined type hierarchy.

Key Characteristics
- Only the classes explicitly listed in the "permits" clause can extend the sealed class or implement the sealed
  interface.
- Subclasses must be declared as "final", "non-sealed", or "sealed".
- Supports exhaustive pattern matching and better reasoning about inheritance in code.
- Helps maintain security, consistency, and predictable behavior across a class hierarchy.

Usage
- Use sealed classes when you want to restrict and control which classes can extend or implement a type.
- Ideal for APIs where a fixed set of known implementations is required.
- Works well with pattern matching and enhanced "switch" expressions.
- Prevents uncontrolled subclassing that could break invariants or internal logic.

Example:
- The example demonstrates a sealed class "Animal" with a fixed set of permitted subclasses.
- The child classes are "final" and "non-sealed"; any other declaration would cause a compile-time error.
*/
public sealed class Animal permits Dog, Cat {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public final class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

public non-sealed class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

void main() {
    Animal a1 = new Dog("Rex");
    Animal a2 = new Cat("Tom");
    IO.println(a1.getName()); // Rex
    IO.println(a2.getName()); // Tom
}