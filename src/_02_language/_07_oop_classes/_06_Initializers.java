/*
Class Initializers
This section explains initializers in Java, which allow code to run automatically during class loading or object
creation.

Overview
- Static Initializers (`static { ... }`):
  - Executed once when the class is first loaded.
  - Typically used to initialize static fields or perform setup for the class.
- Instance Initializers (`{ ... }`):
  - Executed every time a new object is created, before the constructor.
  - Typically used to initialize instance fields with complex logic.

Usage
- Static initializers are useful for setting up shared class-level state.
- Instance initializers are useful when multiple constructors share common initialization code.
- Both provide a way to run code automatically without explicitly calling a method.

Example
- The static initializer runs once when the Person class is loaded.
- The instance initializer runs every time a new Person object is created.
- This demonstrates automatic setup for class-level and object-level fields.
*/
public class Person {
    // Static Initializer
    static {
        IO.println("Static initializer executed: class loaded");
    }

    // Instance initializer
    {
        IO.println("Instance initializer executed: object created");
    }
}

void main() {
    Person p1 = new Person(); // Static and Instance initializers executed
    Person p2 = new Person(); // Only Instance initializer executed
}