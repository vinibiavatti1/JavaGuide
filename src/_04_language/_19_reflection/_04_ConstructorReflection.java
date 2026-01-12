/*
Constructor Reflection
- This section explains how to inspect, access, and invoke constructors of classes dynamically at runtime using the
  java.lang.reflect.Constructor class.

Overview
- The "Constructor" class is part of the java.lang.reflect package.
- Represents a single constructor of a class, including parameterized and no-argument constructors.
- Allows creating new instances dynamically by invoking constructors with specified arguments.
- Supports both public and non-public constructors using reflection.

Key Characteristics
- Constructors can be retrieved using getDeclaredConstructor(paramTypes) or getDeclaredConstructors(), with access to
  private constructors.
- setAccessible(true) can bypass Java access control to invoke private or protected constructors.
- Provides metadata such as constructor name, parameter types, modifiers, and annotations.
- Supports creating objects dynamically with newInstance(args).
- Can inspect generic parameter types via getGenericParameterTypes() for type-safe operations.

Usage
- Use Constructor reflection when the class type or constructor parameters are not known at compile time.
- Useful for dependency injection, object mappers, serialization frameworks, and dynamic object creation.
- Supports invoking both no-argument and parameterized constructors, including private ones.
- Enables generic frameworks to instantiate objects without hardcoding class types.
*/
public static class Person {
    private String name = "John";

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

void main() throws Exception {
    //==================================================================================================================
    // Constructor Introspection
    //==================================================================================================================

    /*
    Get Declared Constructor
    - The "getDeclaredConstructor()" method retrieves a specific constructor declared in the class, including private
      ones.
    - The "getConstructor()" only retrieves public constructors.
    - If the constructor takes parameters, their types must be provided in the method arguments.
    - Output: public _04_ConstructorReflection$Person()
    */
    Constructor constructor = Person.class.getDeclaredConstructor();
    IO.println(constructor);

    /*
    Get Constructor Modifiers
    - The "getModifiers()" method returns an integer representing the Java language modifiers (public, private,
      protected, static, final, etc.) of the constructor.
    - Use the "Modifier" class to interpret the integer value (e.g., Modifier.isPublic(modifiers)).
    - Output: public
    */
    constructor = Person.class.getDeclaredConstructor();
    IO.println(Modifier.toString(constructor.getModifiers()));

    /*
    Get Constructor Parameters
    - The "getParameters()" method returns an array of Parameter objects representing the constructor's formal
      parameters.
    - Each Parameter object provides information such as name, type, and modifiers.
    - Output: [String arg0]
    */
    constructor = Person.class.getDeclaredConstructor(String.class);
    IO.println(Arrays.toString(constructor.getParameters()));

    /*
    Set Method Accessible
    - The "setAccessible(true)" method allows bypassing Java's access control checks for private or protected
      constructors.
    - After calling this, "canAccess(Object)" can be used to verify if the method is accessible on a given instance.
    - Output: true
    */
    constructor = Person.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    IO.println(constructor.canAccess(null));

    //==================================================================================================================
    // Create New Instances
    //==================================================================================================================

    /*
    Create New Instance
    - Use "newInstance()" to create a new instance dynamically; the arguments must match the constructor parameters.
    - For generic classes, the type parameter is not enforced at runtime due to type erasure; the returned object must
      be cast to the appropriate type.
    - Output: John
    */
    constructor = Person.class.getDeclaredConstructor();
    Person person = (Person) constructor.newInstance();
    IO.println(person.getName());

    /*
    Create New Instance With Parameters
    - Use "newInstance()" to create a new instance dynamically; arguments must match the constructor's parameter types.
    - For generic classes, type parameters are erased at runtime; the returned object must be cast to the appropriate
      type.
    - Output: Anna
    */
    constructor = Person.class.getDeclaredConstructor(String.class);
    person = (Person) constructor.newInstance("Anna");
    IO.println(person.getName());
}