/*
Records
This section explains what records are in Java and their purpose.

Overview
- Records are a special kind of class introduced to model immutable data.
- Declared using the "record" keyword.
- Automatically generate constructor, getters, "equals()", "hashCode()", and "toString()" methods.
- Fields in records are called "components" and are implicitly "private" and "final".
- Getters doesn't follow the JavaBeans spec. They don't have the "get" prefix.

Key Characteristics
- Immutable by default: values cannot be changed after creation.
- Designed for data carrier classes (DTOs, value objects, etc.).
- Supports compact syntax while providing standard methods automatically.

Usage
- Use records when you need simple classes to carry immutable data.
- Avoid records for classes that require mutable state or complex behavior.

Example
- The example shows a declaration of a record with a method
- The main method shows the usage.
*/
public record Person(String name, int age) {
    // Record Method
    public void greet() {
        IO.println("Hello, my name is " + name + ", and I am " + age + " years old.");
    }
}

void main() {
    Person p1 = new Person("Alice", 30);
    Person p2 = new Person("Bob", 25);
    IO.println(p1.name()); // Alice
    IO.println(p2.age());  // 25
    p1.greet();            // Hello, my name is Alice, and I am 30 years old.
    p2.greet();            // Hello, my name is Bob, and I am 25 years old.
}