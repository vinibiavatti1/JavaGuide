/*
 * Sealed Classes
 * - This section explains sealed classes in Java and how they restrict which classes can extend or implement them.
 *
 * Overview
 * - A sealed class or interface restricts which other classes or interfaces are allowed to inherit from or implement
 *   it.
 * - Declared using the "sealed" keyword along with the "permits" clause, which lists the allowed subclasses.
 * - Promotes controlled inheritance, clear API contracts, and a well-defined type hierarchy.
 *
 * Key Characteristics
 * - Only the classes explicitly listed in the "permits" clause can extend the sealed class or implement the sealed
 *   interface.
 * - Subclasses must be declared as "final", "non-sealed", or "sealed".
 * - Supports exhaustive pattern matching and better reasoning about inheritance in code.
 * - Helps maintain security, consistency, and predictable behavior across a class hierarchy.
 *
 * Usage
 * - Use sealed classes when you want to restrict and control which classes can extend or implement a type.
 * - Ideal for APIs where a fixed set of known implementations is required.
 * - Works well with pattern matching and enhanced "switch" expressions.
 * - Prevents uncontrolled subclassing that could break invariants or internal logic.
 */

/*
 * Sealed Class Declaration
 * - The example below shows a class declaration marked as sealed.
 * - Only the classes listed in the "permits" clause are allowed to extend this class.
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

/*
 * Subclasses Declaration
 * - Subclasses must be declared as "final", "non-sealed", or "sealed" as mandatory.
 */
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

/*
 * Usage Example
 * - Demonstrates creating instances of subclasses of a sealed superclass.
 */
void main() {
    Animal dog = new Dog("Rex");
    Animal cat = new Cat("Tom");

    IO.println(dog.getName()); // Output: Rex
    IO.println(cat.getName()); // Output: Tom
}