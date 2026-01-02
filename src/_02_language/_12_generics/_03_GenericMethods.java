/*
Generic Methods
This section explains how to define and use generic methods in Java, allowing methods to operate on different types
while maintaining type safety.

Overview
- Generic methods declare type parameters (e.g., <T>, <R>) for their arguments and/or return types.
- Methods can infer types automatically from arguments or the target variable.
- Supports type safety, reusability, and flexible API design independent of classes.
- Generic types are specified by placing type parameters inside angle brackets <...> after the access keyword and before
  the return type.

Key Characteristics
- Type parameters can be used in method arguments, return types, and local variables.
- Methods can have multiple type parameters.
- Type parameters can be bounded with extends/super for additional constraints.
- Types can be inferred by the compiler or specified explicitly using the syntax ".<Type>method(...)".

Usage
- Use generic methods to write reusable, type-safe code for operations on multiple types.
- Useful for collections, utilities, and API methods where types vary per call.

Example:
- The example shows generic methods with generic arguments and return types.
- Type safety is enforced at compile time, no casting needed when used correctly.
*/

/*
Method (with generic arguments)
- Accepts parameters of any type T.
- T can be inferred by the compiler from the argument or specified explicitly.
*/
public <T1, T2> void methodWithGenericArguments(T1 a, T2 b) {
    return;
}

/*
Method (with generic varargs)
- Accepts zero or more arguments of a generic type T.
- T can be inferred by the compiler from the arguments or specified explicitly using <T> before the method name.
- Internally, the arguments are treated as an array of T.
*/
public <T> void methodWithGenericVarArgs(T... arguments) {
    return;
}

/*
Method (with generic return)
- Returns a value of type R.
- Without explicit type context, R defaults to Object.
*/
public <R> R methodWithGenericReturn() {
    return null;
}

/*
Method (with generic return and argument)
- Accepts an argument of type T and returns a value of type R.
- Both types can be inferred or explicitly specified when calling the method.
*/
public <T, R> R methodWithGenerics(T element) {
    return null;
}

/*
Calling Generic Methods
- The example below shows the usage of generic methods.
*/
void main() {
    /*
    Calling Method (with generic arguments)
    - Demonstrates type inference and explicit type specification for arguments.
    - 1º call: passing "null", the compiler cannot infer the type, so T1 and T2 default to Object.
    - 2º call: the types are inferred by the compiler from the argument ("test" -> T = String, 1 -> T = Integer).
    - 3º call: the types are explicitly specified using <String, Integer> before the method name.
    */
    methodWithGenericArguments(null, null);                      // T1, T2 inferred as Object (cannot infer from null)
    methodWithGenericArguments("test", 1);                       // T1, T2 inferred as String and Integer
    this.<String, Integer>methodWithGenericArguments("test", 1); // T1, T2 explicitly specified as String and Integer

    /*
    Calling Method (with generic varargs)
    - Demonstrates type inference and explicit type specification for a generic varargs method.
    - 1º call: the compiler infers T = String from the arguments.
    - 2º call: T is explicitly specified using <String> before the method name.
    */
    methodWithGenericVarArgs("A", "B", "C");         // T inferred as String
    this.<String>methodWithGenericVarArgs("X", "Y"); // T explicitly specified as String

    /*
    Calling Method (with generic return type)
    - Demonstrates type inference and explicit type specification for a generic return type.
    - 1º call: using "var", the compiler infers the return type as Object because there is no context to determine R.
    - 2º call: assigning directly to a "String" variable allows the compiler to infer R = String.
    - 3º call: the return type is explicitly specified using <String> before the method name.
    */
    var x1 = methodWithGenericReturn();                 // R inferred as Object
    String x2 = methodWithGenericReturn();              // R inferred as String
    String x3 = this.<String>methodWithGenericReturn(); // R explicitly specified as String

    /*
    Calling Method (with generic return and argument types)
    - Demonstrates type inference and explicit type specification when a method has generic arguments and return type.
    - 1º call: using "var", the compiler infers T and R = Object because there is no explicit type context.
    - 2º call: assigning the result to a String and the String argument allows the compiler to infer R and T = String
    - 3º call: both T and R are explicitly specified using <Integer, String> before the method name.
    */
    var x4 = methodWithGenerics(null);                       // T inferred as Object, R inferred as Object
    String x5 = methodWithGenerics("test");                  // T inferred as String, R inferred as String
    String x6 = this.<Integer, String>methodWithGenerics(1); // T explicitly Integer, R explicitly String
}