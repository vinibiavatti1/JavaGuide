/*
Class Fields
- This section explains what fields are in Java and how they represent the state of a class or its objects.

Overview
- Fields are variables declared inside a class.
- They store data representing object or class state.
- Fields are usually accessed or modified via methods to enforce encapsulation.

Key Characteristics
- Instance fields belong to individual objects.
- Static fields belong to the class and are shared by all instances.
- Fields can have access modifiers (public, protected, package-private, private).
- Fields can be marked final to make their value immutable after initialization.

Usage
- Store object state, properties, or configuration values.
- Keep fields private and use getters/setters for controlled access.
- Fields provide the data that methods operate on.

Example:
- This example declares a public class named "Person" and illustrates the definition of an instance field.
- Each "Person" instance has its own "name" value, demonstrating that objects maintain independent state.
- NOTE: Public instance fields are discouraged; always use private fields with getters/setters.
*/
public class Person {
    public String name;
}

void main() {
    Person p1 = new Person();
    Person p2 = new Person();
    p1.name = "John";
    p2.name = "Jane";
    IO.println(p1.name); // John
    IO.println(p2.name); // Jane
}