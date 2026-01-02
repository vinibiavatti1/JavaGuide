/*
Static Methods
This section explains static methods in Java and how they belong to the class rather than individual instances.

Overview
- Static methods are defined with the "static" keyword.
- They can be called directly on the class without creating an object.
- Static methods cannot access instance fields or methods directly; they operate on parameters or static fields.

Usage
- Use static methods for utility functions or operations that do not depend on instance state.
- They improve code clarity by indicating that no object context is required.

Example
- The static method "greet" is called directly on the class, demonstrating that no object instantiation is required.
*/
public class Person {
    public static void greet() {
        IO.println("Hello from Person class!");
    }
}

void main() {
    Person.greet(); // Hello from Person class!
}