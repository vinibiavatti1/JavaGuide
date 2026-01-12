/*
Final Classes
- This section explains final classes in Java and how they prevent inheritance.

Overview
- A final class cannot be subclassed; no other class can extend it.
- Declared using the "final" keyword before the class name.
- Useful when you want to prevent modification of class behavior or ensure immutability.

Key Characteristics
- Fields and methods function normally within a final class.
- Final classes can have constructors, fields, and methods like any other class.
- Methods in a final class are implicitly non-overridable, since the class cannot be extended.
- Promotes security, consistency, and immutability in class design.

Usage
- Use final classes to lock down implementation details and prevent inheritance.
- Commonly applied to utility classes, constants, immutable objects, or security-sensitive classes.
- Prevents subclasses from altering critical behavior or internal logic.

Example:
- The example shows a final class declaration.
- Any attempt to extend it would result in a compile-time error.
*/
public final class Dog {}
// public class Labrador extends Dog {} - Not Allowed: cannot extend a final class

void main() {}