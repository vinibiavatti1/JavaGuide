/*
Final Methods
- This section explains final methods in Java and how they prevent overriding in subclasses.

Overview
- A final method cannot be overridden by any subclass.
- Declared using the "final" keyword before the method name.
- Useful when you want to lock the behavior of a method while still allowing the class to be extended.

Key Characteristics
- Final methods can coexist with non-final methods in the same class.
- Final methods can be static, instance, or private.
- Prevents subclasses from modifying critical behavior while preserving polymorphism for other methods.
- Promotes consistency, security, and reliability in method design.

Usage
- Use final methods to enforce invariant behavior that should not change in subclasses.
- Commonly applied in libraries, frameworks, or security-sensitive code to prevent accidental overrides.
- Helps maintain predictable behavior in inheritance hierarchies.

Example:
- The example shows a class with a final method "speak".
- Any attempt to override "speak" in a subclass would result in a compile-time error.
*/
public class Animal {
    public final void speak() {
        IO.println("The animal makes a sound");
    }
}
public class Dog extends Animal {
    // public final void speak() {...} - Not Allowed: cannot override a final method
}

void main() {}