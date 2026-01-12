/*
Method Reflection
- This section explains how to inspect, access, and invoke methods of classes dynamically at runtime using the
  java.lang.reflect.Method class.

Overview
- The "Method" class is part of the java.lang.reflect package.
- Represents a single method of a class or interface, including instance and static methods.
- Allows invoking methods dynamically, retrieving method metadata, and inspecting parameters and return types.
- Supports both public and non-public methods using reflection.

Key Characteristics
- Methods can be retrieved using getDeclaredMethod(name, paramTypes) or getMethods(), with differences in access and
  inheritance.
- setAccessible(true) can bypass Java access control to invoke private or protected methods.
- Provides metadata such as method name, return type, parameter types, exceptions thrown, modifiers, and annotations.
- Supports invoking methods with invoke(instance, args), passing null for static methods.
- Can inspect generic return types and parameter types via getGenericReturnType() and getGenericParameterTypes().

Usage
- Use Method reflection when method names or signatures are not known at compile time or for generic frameworks.
- Useful for dynamic proxies, testing, dependency injection, object mappers, and framework APIs.
- Supports invoking static and instance methods, including overloaded and generic methods.
- Enables inspection and execution of private logic or methods without modifying the class source.
*/
public static class Person {
    private String name = "John";

    public static void staticGreet() {
        IO.println("Static Greet!");
    }

    public void greet() {
        IO.println("Public Greet!");
    }

    private void privateGreet() {
        IO.println("Private Greet!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

void main() throws Exception {
    //==================================================================================================================
    // Method Introspection
    //==================================================================================================================

    /*
    Get Declared Method
    - The "getDeclaredMethod()" method retrieves a specific method declared in the class, regardless of its access
      modifier.
    - The "getMethod()" only retrieves public methods, including inherited ones.
    - Can be used to access private, protected, or public methods.
    - Specify the method name and parameter types to disambiguate overloaded methods.
    - Output: public void _03_MethodReflection$Person.greet()
    */
    Method method = Person.class.getDeclaredMethod("greet");
    IO.println(method);

    /*
    Get Method Modifiers
    - The "getModifiers()" method returns an integer representing the Java language modifiers (public, private,
      protected, static, final, etc.) of the method.
    - Use the "Modifier" class to interpret the integer value (e.g., Modifier.isPublic(modifiers)).
    - Output: public
    */
    method = Person.class.getDeclaredMethod("greet");
    IO.println(Modifier.toString(method.getModifiers()));

    /*
    Get Method Parameters
    - The "getParameters()" method returns an array of Parameter objects representing
      all parameters of the method, including names, types, and modifiers.
    - Parameter names are available only if compiled with the "-parameters" flag; otherwise, only types are accessible.
    - Output: [java.lang.String arg0]
    */
    method = Person.class.getDeclaredMethod("setName", String.class);
    IO.println(Arrays.toString(method.getParameters()));

    /*
    Get Method Return Type
    - The "getReturnType()" method returns a Class object representing the return type of the method.
    - Output: class java.lang.String
    */
    method = Person.class.getDeclaredMethod("getName");
    IO.println(method.getReturnType());

    /*
    Set Method Accessible
    - The "setAccessible(true)" method allows bypassing Java's access control checks for private or protected methods.
    - After calling this, "canAccess(Object)" can be used to verify if the method is accessible on a given instance.
    - Output: true
    */
    method = Person.class.getDeclaredMethod("privateGreet");
    method.setAccessible(true);
    IO.println(method.canAccess(new Person()));

    //==================================================================================================================
    // Method Invocation
    //==================================================================================================================

    /*
    Invoke Methods
    - To call an instance method via reflection, pass the target object to "invoke(Object, Object...)".
    - Output: Public Greet!
    */
    Person person = new Person();
    method = Person.class.getDeclaredMethod("greet");
    method.invoke(person);

    /*
    Invoke Methods with Parameters
    - To call a method with parameters via reflection, pass the target object as the first argument to
      "invoke(Object, Object...)" followed by the method arguments.
    - Output: Anna
    */
    person = new Person();
    method = Person.class.getDeclaredMethod("setName", String.class);
    method.invoke(person, "Anna");
    IO.println(person.getName());

    /*
    Invoke Methods with Return Type
    - To call a method with a return value via reflection, pass the target object to "invoke(Object, Object...)" and
      cast the result to the expected type.
    - Output: John
    */
    person = new Person();
    method = Person.class.getDeclaredMethod("getName");
    String name = (String) method.invoke(person);
    IO.println(name);

    /*
    Invoke Static Methods
    - To call a static method via reflection, pass null as the target object in "invoke(Object, Object...)".
    - Useful for dynamically executing utility or class-level behavior, testing, or framework operations.
    - Output: Static Greet!
    */
    method = Person.class.getDeclaredMethod("staticGreet");
    method.invoke(null);
}