/*
Static Fields
This section explains what static fields are in Java and how they represent class-level state.

Overview
- Static fields are variables declared inside a class with the "static" keyword.
- They belong to the class itself, not to any individual object, and are shared by all instances.
- They can be combined with "final" to define constants whose value cannot change after initialization.

Key Characteristics
- Static fields exist independently of any object instantiation.
- They can be accessed directly via the class name.
- Access modifiers (public, protected, package-private, private) control visibility.
- "static final" fields are commonly used to define constants.

Usage
- Use static fields for values shared across all instances, such as configuration constants.
- Access static fields directly through the class to avoid unnecessary object creation.
- "static final" constants improve readability and prevent accidental modification.

Example
- "public static final String DEFAULT_NAME = "Unknown";" defines a class-level constant.
*/
@SuppressWarnings("all")
public class Person {
    public static final String DEFAULT_NAME = "Unknown";
}

/*
Usage Example
In this example, the "DEFAULT_NAME" constant belongs to the class itself and is shared by all "Person" instances.
*/
@SuppressWarnings("all")
void main() {
    IO.println(Person.DEFAULT_NAME); // Unknown
}