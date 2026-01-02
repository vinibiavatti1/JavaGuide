/*
Enums
This section explains enums in Java and how they represent a fixed set of constants.

Overview
- An enum (short for "enumeration") is a special type that defines a collection of named constants.
- Declared using the "enum" keyword.
- Provides type safety and readability compared to using plain integers or strings.
- Can include fields, methods, and constructors for more complex behavior.

Key Characteristics
- Each constant is a public static final instance of the enum type.
- Enums can implement interfaces but cannot extend other classes (implicitly final).
- Methods like "values()", "valueOf(String)", and "ordinal()" are automatically provided.
- Supports usage in switch statements and comparisons.

Usage
- Use enums to represent a fixed set of known values (e.g., days of the week, states, colors).
- Avoid using arbitrary strings or integers for predefined categories.
- Can include additional properties and behavior if needed.

Example:
- The example shows an enum "Color" with three constants: RED, GREEN, and BLUE.
- Demonstrates how to access enum constants and print them.
*/
public enum Color {
    RED,
    GREEN,
    BLUE
}

void main() {
    /*
    Constants
    Prints the enum constant directly. Shows the name of the constant as defined.
    */
    IO.println(Color.RED);   // RED
    IO.println(Color.GREEN); // GREEN
    IO.println(Color.BLUE);  // BLUE

    /*
    Values
    Returns an array of all enum constants in declaration order.
    Output: RED | GREEN | BLUE
    */
    for (Color c : Color.values()) {
        IO.println(c);
    }

    /*
    Value Of
    Returns the enum constant matching the given string name.
    Throws an exception if the name does not exist.
    Output: RED
    */
    Color c = Color.valueOf("RED");
    IO.println(c);

    /*
    Ordinal
    Returns the zero-based position of the constant in the enum declaration.
    */
    IO.println(Color.RED.ordinal());   // 0
    IO.println(Color.GREEN.ordinal()); // 1
    IO.println(Color.BLUE.ordinal());  // 2
}