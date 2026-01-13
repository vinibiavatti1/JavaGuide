/*
 * Records
 * - This section explains what records are in Java and their purpose as concise, immutable data carriers.
 *
 * Overview
 * - Records are a special type of class introduced to model immutable data.
 * - Declared using the "record" keyword.
 * - Automatically generate:
 *   - A canonical constructor
 *   - Getters for all components (without the "get" prefix, not following JavaBeans naming)
 *   - "equals()", "hashCode()", and "toString()" methods
 * - Fields in records are called "components" and are implicitly "private" and "final".
 *
 * Key Characteristics
 * - Immutable by default: once created, the component values cannot be changed.
 * - Ideal for data carrier classes such as DTOs, value objects, or simple aggregates.
 * - Compact syntax reduces boilerplate while providing standard methods automatically.
 * - Records cannot extend other classes (they implicitly extend "java.lang.Record") but can implement interfaces.
 *
 * Usage
 * - Use records for simple, immutable objects that primarily hold data.
 * - Avoid using records when mutable state, inheritance, or complex behavior is required.
 * - Provides a clean, concise way to create classes that focus on data rather than behavior.
 *
 * Example
 * - The example shows a declaration of a record with a method.
 * - The main method shows the usage.
 */
public record Person(String name, int age) {
    // Record Method
    public void greet() {
        IO.println(String.format("Hello, my name is %s, and I am %d years old", name, age));
    }
}

void main() {
    Person p1 = new Person("Alice", 30);
    Person p2 = new Person("Bob", 25);
    IO.println(p1.name()); // Alice
    IO.println(p2.age());  // 25
    p1.greet(); // Hello, my name is Alice, and I am 30 years old.
    p2.greet(); // Hello, my name is Bob, and I am 25 years old.
}