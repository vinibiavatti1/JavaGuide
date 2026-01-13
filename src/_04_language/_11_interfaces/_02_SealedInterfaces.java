/*
 * Sealed Interfaces
 * - This section explains sealed interfaces in Java and how they restrict which classes or interfaces can implement
 *   them.
 *
 * Overview
 * - A sealed interface limits which classes or interfaces may implement it.
 * - Declared using the "sealed" keyword along with the "permits" clause.
 * - Promotes controlled implementation and a clear, fixed hierarchy.
 * - Subclasses must be either "final", "sealed", or "non-sealed".
 *
 * Key Characteristics
 * - Only the classes listed in the "permits" clause can implement the sealed interface.
 * - Supports better reasoning about type hierarchies.
 * - Works well with pattern matching and switch expressions.
 * - Prevents uncontrolled or accidental implementations outside the intended set.
 *
 * Usage
 * - Use sealed interfaces to define a fixed set of implementations.
 * - Useful in APIs or domain models where you want to restrict extensions.
 * - Helps maintain invariants and predictable behavior.
 *
 * Example:
 * - The example demonstrates a sealed interface "Speaker" with permitted implementations "Dog" and "Cat".
 * - Each class provides its own implementation of the "speak" method.
 */
public sealed interface Speaker permits Dog, Cat {
    void say();
}

public final class Dog implements Speaker {
    @Override
    public void say() {
        IO.println("woof!");
    }
}

public non-sealed class Cat implements Speaker {
    @Override
    public void say() {
        IO.println("meow!");
    }
}

@SuppressWarnings("all")
void main() {
    Speaker a1 = new Dog();
    Speaker a2 = new Cat();
    a1.say(); // woof!
    a2.say(); // meow!
}