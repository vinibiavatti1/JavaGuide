/*
Final Classes
This section explains final classes in Java and how they prevent inheritance.

Overview
- A final class cannot be extended by any other class.
- Declared using the "final" keyword before the class name.
- Useful when you want to prevent modification of class behavior.

Key Characteristics
- Fields and methods can still exist normally inside the final class.
- Final classes can have constructors, fields, and methods like any other class.
- Methods inside a final class are implicitly non-overridable.
- Promotes immutability and security in class design.

Usage
- Use final classes when you want to lock the implementation.
- Often used for utility classes, constants, or security-sensitive classes.
- Prevents subclasses from changing critical behavior or internal logic.

Example:
- The example shows a final class declaration.
- Any attempt to extend it would result in a compile-time error.
*/
public final class Dog {
    public void say() {
        IO.println("woof!");
    }
}

void main() {
    Dog dog = new Dog();
    dog.say(); // woof!
}