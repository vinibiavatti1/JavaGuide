/*
Enum Reflection
- This section explains how to inspect and interact with Java enums dynamically at runtime using reflection.

Overview
- Enums in Java are classes that extend java.lang.Enum, and can be manipulated using standard reflection APIs.
- Reflection allows access to enum constants, methods, fields, and metadata without compile-time knowledge of the
  specific enum type.
- The Class API provides enum-specific methods to facilitate dynamic inspection and usage.

Key Characteristics
- Class.isEnum() returns true if the class represents an enum.
- Class.getEnumConstants() returns all enum constants in declaration order as an array.
- Enum.valueOf(Class<T>, String) returns the enum constant corresponding to the given name.
- Standard reflection methods (getFields, getDeclaredFields, getMethods, getDeclaredMethods) work on enums, including
  their constants and custom methods.
- getSuperclass() on any enum class returns java.lang.Enum.
- Useful for iterating over constants, dynamic configuration, and generic frameworks that need to work with enums.

Usage
- Use enum reflection when the specific enum type is unknown at compile time.
- Useful for iterating over all constants of an enum dynamically.
- Supports dynamic string-to-enum conversion for configuration or deserialization.
- Can inspect or invoke custom methods defined within enum classes.
- Enables frameworks and libraries to handle enums generically without hard-coded references.
*/
public enum Color {
    RED,
    GREEN,
    BLUE;
}

void main() {
    /*
    Get Enum Constants
    - The "getEnumConstants()" method on a Class object returns an array of all enum constants in declaration order.
    - Returns null if the class is not an enum.
    - Useful for dynamically iterating over all constants without hardcoding names.
    - Can be combined with reflection to invoke methods or access fields on each enum constant.
    - Output: [RED, GREEN, BLUE]
    */
    Color[] constants = Color.class.getEnumConstants();
    IO.println(Arrays.toString(constants));

    /*
    Get Enum Constant
    - The "Enum.valueOf(Class<T>, String)" method returns the enum constant of the specified enum type with the given name.
    - Throws IllegalArgumentException if no constant with the specified name exists.
    - Useful for converting dynamic input (e.g., configuration or user input) into enum instances.
    - Works only for enum types; cannot be used with regular classes.
    - Output: RED
    */
    Color constant = Enum.valueOf(Color.class, "RED");
    IO.println(constant);

    /*
    Check Enum
    - The "isEnum()" method on a Class object returns true if the class represents an enum type.
    - Returns false for regular classes, interfaces, and arrays.
    - Useful for generic code that needs to handle enums differently from other types.
    - Output: true
    */
    IO.println(Color.class.isEnum());
}