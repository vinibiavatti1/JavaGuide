/*
 * Class Initializers
 * - This section explains initializers in Java, which allow code to run automatically during class loading or object
 *   creation.
 *
 * Overview
 * - Static Initializers ("static { ... }"):
 *   - Executed once when the class is first loaded.
 *   - Typically used to initialize static fields or perform setup for the class.
 * - Instance Initializers ("{ ... }"):
 *   - Executed every time a new object is created, before the constructor.
 *   - Typically used to initialize instance fields with complex logic.
 *
 * Usage
 * - Static initializers are useful for setting up shared class-level state.
 * - Instance initializers are useful when multiple constructors share common initialization code.
 * - Both provide a way to run code automatically without explicitly calling a method.
 */

/*
 * Class Declaration With Initializers
 * - This example demonstrates the use of static and instance initializers in a class "Person".
 */
public class Person {
    // Static Initializer
    static {
        IO.println("Static Initializer");
    }

    // Instance initializer
    {
        IO.println("Instance initializer");
    }
}

/*
 * Usage Example
 * - Demonstrates the order of execution:
 *   1. Static initializer runs once when the class is loaded.
 *   2. Instance initializer runs every time a new object is created, before the constructor.
 */
void main() {
    Person person1 = new Person(); // Output: Static Initializer | Instance initializer
    Person person2 = new Person(); // Output: Instance initializer
    Person person3 = new Person(); // Output: Instance initializer
}