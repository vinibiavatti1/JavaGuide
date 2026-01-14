/*
 * Generic Methods
 * - This section explains how to define and use generic methods in Java, allowing methods to work with different types
 *   while preserving compile-time type safety.
 *
 * Overview
 * - Generic methods declare their own type parameters (e.g., <T>, <R>).
 * - These types belong to the method, not to the class.
 * - The compiler can infer types from arguments or from the assignment context.
 * - Generic methods improve reusability and API flexibility.
 *
 * Key Characteristics
 * - Type parameters are declared before the return type.
 * - Can use generic types in parameters, return values, or both.
 * - Can declare multiple type parameters.
 * - Type parameters may be bounded using extends or super.
 *
 * Usage
 * - Use generic methods when logic is independent of a specific type.
 * - Ideal for utility methods, helpers, and reusable operations.
 * - Keeps code type-safe without casting.
 */

/*
 * Method With Generic Arguments
 * - Accepts arguments of different generic types.
 * - Types are inferred from the method arguments.
 */
public <T1, T2> void methodWithGenericArguments(T1 a, T2 b) {
    return;
}

/*
 * Method With Generic Varargs
 * - Accepts zero or more arguments of the same generic type.
 * - The compiler infers the type from the provided arguments.
 */
public <T> void methodWithGenericVarargs(T... arguments) {
    return;
}

/*
 * Method With Generic Return Type
 * - Returns a value of a generic type.
 * - The return type is inferred from the assignment context.
 */
public <R> R methodWithGenericReturn() {
    return null;
}

/*
 * Method With Generic Argument and Return
 * - Accepts a generic argument and returns a generic value.
 * - Types may be inferred or explicitly defined.
 * - Note: The same generic type can be used for both (arguments and return).
 */
public <T, R> R methodWithGenerics(T element) {
    return null;
}

void main() {
    // Generic arguments
    methodWithGenericArguments(null, null);                      // T1, T2 inferred as Object
    methodWithGenericArguments("test", 1);                       // T1 = String, T2 = Integer
    this.<String, Integer>methodWithGenericArguments("test", 1); // Explicit types

    // Generic varargs
    methodWithGenericVarargs("A", "B", "C");                     // T inferred as String
    this.<String>methodWithGenericVarargs("X", "Y");             // Explicit type

    // Generic return type
    var x1 = methodWithGenericReturn();                          // R inferred as Object
    String x2 = methodWithGenericReturn();                       // R inferred as String
    String x3 = this.<String>methodWithGenericReturn();          // Explicit type

    // Generic argument + return
    var x4 = methodWithGenerics(null);                           // T, R inferred as Object
    String x5 = methodWithGenerics("test");                      // T, R inferred as String
    String x6 = this.<Integer, String>methodWithGenerics(1);     // Explicit types
}