/*
 * Fields
 * - This section explains what fields are in Java and their role in representing the state of a class or its objects.
 *
 * Overview
 * - Fields are variables declared within a class to store data representing the state of an object or the class itself.
 * - They form the properties or attributes of objects and can be accessed or modified through methods to enforce
 *   encapsulation.
 * - Fields can be initialized at declaration, in constructors, or via methods depending on design needs.
 * - Access modifiers (public, protected, package-private, private) determine visibility and enforce encapsulation.
 * - Fields not explicitly initialized receive default values based on their type (0, false, null, etc.).
 * - Fields can be marked "final" to prevent reassignment after initialization, ensuring immutability.
 *
 * Field Types
 * - Instance fields:
 *   - Belong to individual objects.
 *   - Each object has its own copy of the field, maintaining independent state.
 * - Static fields:
 *   - Belong to the class itself and are shared across all instances.
 *   - Useful for constants, counters, or shared configuration.
 * - Final fields:
 *   - Cannot be reassigned after initialization, providing immutability for constants.
 *
 * Usage
 * - Store object-specific data or class-level properties.
 * - Maintain encapsulation by keeping fields private and providing getters/setters for controlled access.
 * - Fields are the data foundation upon which methods operate and implement behavior.
 * - Use static final fields for constants to improve code readability and maintainability.
 * - Avoid exposing mutable public fields to prevent unintended external modifications.
 *
 * Important Note
 * - Public instance fields are discouraged; always use private fields with getters/setters.
 */

/*
 * Class Declaration With Fields
 * - This example demonstrates the declaration of a class named "Person" with both instance and static fields.
 * - Instance Fields: Each object has its own copy of these fields, maintaining independent state per instance.
 * - Static Fields: Belong to the class itself and are shared among all instances.
 */
public class Person {
    // Static Fields
    public static final int MIN_AGE = 0;
    public static String defaultName = "Unknown";

    // Instance Fields
    public String name;
    public int age;
}

/*
 * Usage Example
 * - The example below demonstrates creating instances of the "Person" class and manipulating both
 *   instance and static fields.
 * - Each object maintains its own state, while static fields are accessed via the class itself.
 */
void main() {
    // Creating the first Person instance
    Person person = new Person();
    person.name = "John";
    person.age = 35;

    // Creating another Person instance
    Person otherPerson = new Person();
    otherPerson.name = "Anna";
    otherPerson.age = 32;

    // Each instance maintains independent state
    IO.println(person.name);      // Output: John
    IO.println(otherPerson.name); // Output: Anna

    // Static fields are shared and accessed via the class itself
    IO.println(Person.MIN_AGE);     // Output: 0
    IO.println(Person.defaultName); // Output: Unknown
}
