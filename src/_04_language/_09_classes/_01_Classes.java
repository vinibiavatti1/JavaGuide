/*
Classes
- This section explains what classes are in Java and their central role in object-oriented programming (OOP).
- Classes are the blueprint for creating objects, encapsulating data (fields) and behavior (methods) in a single unit.

Overview
- A class defines a new reference type in Java.
- It specifies:
  - Fields: represent the state or attributes of objects.
  - Methods: define behavior or operations objects can perform.
  - Constructors: special methods used to initialize new instances.
- Classes support core OOP principles:
  - Encapsulation: hiding internal state and exposing controlled access.
  - Inheritance: creating new classes based on existing ones to reuse code.
  - Polymorphism: allowing objects to be treated as instances of their parent types.
- Introduced in Java from the very beginning (Java 1.0) and remain fundamental for structuring programs.

Key Characteristics
- Fields store object-specific or class-wide data.
- Methods implement functionality and define how objects interact.
- Constructors allow proper initialization of objects with specific values.
- Access modifiers (public, protected, package-private, private) control visibility and enforce encapsulation.
- Classes can implement interfaces or extend other classes to define relationships and enable polymorphic behavior.
- Can include nested classes, static or non-static, to logically group related functionality.

Usage
- Use classes to model real-world entities, conceptual abstractions, or domain-specific structures.
- Encapsulate related data and behavior, promoting organized and maintainable code.
- Serve as the foundation for object creation, inheritance hierarchies, and interface implementations.
- Ideal for defining reusable, modular, and extensible components in an application.

Example:
- The example shows a class declaration that defines a new reference type in Java using the "class" keyword.
- The main method shows how to create instances (objects) of the new class using the "new" keyword.
*/
public class Person {}

void main() {
    Person p1 = new Person();
    Person p2 = new Person();
}