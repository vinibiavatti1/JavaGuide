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
- Static initializer sets a static constant.
- Instance initializer sets a default value for instance fields.
*/
@SuppressWarnings("all")
public class Person {
    public static int instanceCounter;

    // Static Initializer
    static {
        instanceCounter = 0;
        IO.println("Static initializer executed: class loaded");
    }

    // Instance Initializer
    {
        instanceCounter++;
        IO.println("Instance initializer executed: object created");
    }
}

/*
Class Initializers Example
In this example:
- The static initializer runs once when the Person class is loaded.
- The instance initializer runs every time a new Person object is created.
- This demonstrates automatic setup for class-level and object-level fields.
*/
@SuppressWarnings("all")
void main() {
    IO.println("Total instances: " + Person.instanceCounter); // 0
    Person p = new Person();
    IO.println("Total instances: " + Person.instanceCounter); // 1
}