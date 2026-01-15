/*
 * Sealed Interfaces
 * - This section explains sealed interfaces in Java and how they restrict which classes or interfaces can implement
 *   them.
 *
 * Overview
 * - A sealed interface limits which classes or interfaces may implement it.
 * - Declared using the "sealed" keyword along with the "permits" clause.
 * - Promotes controlled implementation and a clear, fixed hierarchy.
 * - Classes that implement a sealed interface must be declared as either "final", "sealed", or "non-sealed".
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
 */

/*
 * Sealed Interface Declaration
 * - The example below shows an interface declaration marked as sealed.
 * - Only the classes listed in the "permits" clause are allowed to implement the interface.
 */
public sealed interface Speaker permits Dog, Cat {
    void speak();
}

/*
 * Class Implementations
 * - Classes that implement a sealed interface must be declared as either "final", "sealed", or "non-sealed".
 */
public final class Dog implements Speaker {
    @Override
    public void speak() {
        IO.println("woof!");
    }
}
public non-sealed class Cat implements Speaker {
    @Override
    public void speak() {
        IO.println("meow!");
    }
}

/*
 * Usage Example
 * - Demonstrates creating instances of classes implementing a sealed interface.
 */
void main() {
    Speaker dog = new Dog();
    Speaker cat = new Cat();

    dog.speak(); // Output: woof!
    cat.speak(); // Output: meow!
}