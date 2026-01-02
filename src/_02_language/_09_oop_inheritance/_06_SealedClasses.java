/*
Sealed Classes
This section explains sealed classes in Java and how they restrict which classes can extend or implement them.

Overview
- A sealed class or interface limits which other classes or interfaces may inherit or implement it.
- Declared using the "sealed" keyword along with the "permits" clause.
- Promotes controlled inheritance and a well-defined type hierarchy.

Key Characteristics
- Only the classes explicitly listed in the "permits" clause can extend the sealed class.
- Subclasses must be either "final", "non-sealed", or "sealed".
- Supports better reasoning about inheritance and exhaustive pattern matching.
- Helps maintain security, consistency, and clear API contracts.

Usage
- Use sealed classes when you want to restrict and control extension.
- Useful in APIs where you want a fixed set of known implementations.
- Works well with pattern matching and switch expressions.
- Prevents uncontrolled subclassing that may break invariants.

Example:
- The example demonstrates a sealed class "Animal" with a fixed set of permitted subclasses.
- The child classes are "final" and "non-sealed", otherwise a compile error will be raised.
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