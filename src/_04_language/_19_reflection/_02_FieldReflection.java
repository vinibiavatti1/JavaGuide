/*
Field Reflection
- This section explains how to inspect, access, and manipulate fields of classes dynamically at runtime using the
  java.lang.reflect.Field class.

Overview
- The "Field" class is part of the java.lang.reflect package.
- It represents a single field (member variable) of a class or interface.
- Allows reading and writing field values, including private or protected fields, using reflection.
- Supports both instance and static fields, including primitives and object types.

Key Characteristics
- Fields can be retrieved with getDeclaredField(name) or getFields(), with differences in access and inheritance.
- setAccessible(true) can bypass Java access control to access private or protected fields.
- Provides methods to get the field's name, type, modifiers, and annotations.
- Supports reading values with get(instance) and writing values with set(instance, value); for static fields, the
  instance parameter is ignored.
- Can determine if a field is static, final, or volatile via its modifiers.

Usage
- Use Field reflection when field names or types are not known at compile time or for generic frameworks.
- Useful for serialization, deserialization, object mappers, testing, and inspecting internal state.
- Can combine with Array reflection to manipulate array fields dynamically.
- Supports reading and writing configuration values, constants, and private internal fields without modifying the class
  source.
*/
public static class Person {
    public static String defaultName = "Unknown";
    private String name = "John";
}

void main() throws Exception {
    //==================================================================================================================
    // Fields Introspection
    //==================================================================================================================

    /*
    Get Declared Field
    - The "getDeclaredField(String name)" method retrieves a specific field declared in the class, regardless of its
      access modifier (private, protected, package-private, or public).
    - The "getField()" only retrieves public fields, including inherited ones.
    - Throws NoSuchFieldException if the field with the given name does not exist in the class.
    - Output: private java.lang.String _02_FieldReflection$Person.name
    */
    Field field = Person.class.getDeclaredField("name");
    IO.println(field);

    /*
    Get Field Modifiers
    - The "getModifiers()" method returns an integer representing the field's modifiers (public, private, protected,
      static, final, etc.).
    - Use the Modifier class (java.lang.reflect.Modifier) to interpret the integer, e.g., Modifier.isPrivate(modifiers).
    - Output: private
    */
    field = Person.class.getDeclaredField("name");
    IO.println(Modifier.toString(field.getModifiers()));

    /*
    Get Field Type
    - The "getType()" method returns the Class object representing the declared type of the field.
    - For example, a field declared as "private String name;" will return "class java.lang.String".
    - Output: class java.lang.String
    */
    field = Person.class.getDeclaredField("name");
    IO.println(field.getType());

    /*
    Set Field Accessible
    - The "setAccessible(true)" method overrides Java access checks for reflection, allowing access to private or
      protected fields.
    - Use "canAccess(Object obj)" to check if the field is accessible on a given instance.
    - Must provide a valid instance for non-static fields; static fields can pass null.
    - Output: true
    */
    field = Person.class.getDeclaredField("name");
    field.setAccessible(true);
    IO.println(field.canAccess(new Person()));

    //==================================================================================================================
    // Value Manipulation
    //==================================================================================================================

    /*
    Get Field Value
    - The "get()" method retrieves the value of a field from a given instance.
    - For private or protected fields, "setAccessible(true)" is required to bypass access checks.
    - Works for both instance and static fields (pass null for static fields).
    - Output: John
    */
    Person person = new Person();
    field = Person.class.getDeclaredField("name");
    field.setAccessible(true); // Required due to private field
    String name = (String) field.get(person);
    IO.println(name);

    /*
    Set Field Value
    - The "set()" method updates the value of a field on a given instance.
    - For private or protected fields, "setAccessible(true)" is required to bypass access checks.
    - Works for both instance and static fields (pass null for static fields).
    - Output: Anna
    */
    person = new Person();
    field = Person.class.getDeclaredField("name");
    field.setAccessible(true); // Required due to private field
    field.set(person, "Anna");
    IO.println(field.get(person));

    /*
    Get Static Field Value
    - The "get()" method retrieves the value of a static field.
    - The parameter passed to "get()" is ignored for static fields; use null.
    - Output: Unknown
    */
    field = Person.class.getDeclaredField("defaultName");
    String defaultName = (String) field.get(null);
    IO.println(defaultName);

    /*
    Set Static Field Value
    - The "set()" method updates the value of a static field.
    - The first parameter is ignored for static fields; pass null.
    - Output: Someone
    */
    field = Person.class.getDeclaredField("defaultName");
    field.set(null, "Someone");
    IO.println(field.get(null));
}