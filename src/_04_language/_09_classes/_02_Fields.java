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
 * Example:
 * - This example declares a public class named "Person" and illustrates the definition of an instance field.
 * - Each "Person" instance has its own "name" value, demonstrating that objects maintain independent state.
 * - NOTE: Public instance fields are discouraged; always use private fields with getters/setters.
 */
public class Person {
    public static String defaultName = "Unknown";
    public String name;
}

void main() {
    // Instance fields belong to objects.
    Person p1 = new Person();
    Person p2 = new Person();
    p1.name = "John";
    p2.name = "Jane";
    IO.println(p1.name); // John
    IO.println(p2.name); // Jane

    // Static fields belong to the class and are shared.
    IO.println(Person.defaultName); // Unknown
}