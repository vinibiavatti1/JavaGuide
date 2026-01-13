/*
 * Methods
 * - This section explains how to define and use methods in Java to encapsulate behavior and organize program logic.
 *
 * Overview
 * - Methods define actions that a class or program can perform.
 * - They may accept parameters and optionally return a value.
 * - Methods improve code reuse, readability, and maintainability.
 *
 * Key Characteristics
 * - Parameters: inputs provided to the method.
 * - Return type: the value produced by the method; use void when no value is returned.
 * - Varargs: allow passing a variable number of arguments, handled internally as an array.
 * - Methods can be overloaded by changing their parameter list.
 *
 * Usage
 * - Use methods to avoid code duplication and group related logic.
 * - Apply parameters to customize behavior.
 * - Use varargs when the number of arguments may vary.
 * - Return values when a result is required.
 */

/*
 * Method
 * - Simple method with no parameters and no return value.
 */
public void method() {
    IO.println("Hello World");
}

/*
 * Method (with parameters)
 * - Accepts two integers and uses them inside the method.
 */
public void methodWithArguments(int a, int b) {
    IO.println("a:" + a + " b:" + b);
}

/*
 * Method (with varargs)
 * - Accepts zero or more integers.
 * - Internally treated as an int array.
 */
public void methodWithVarArgs(int... numbers) {
    IO.println(numbers[0] + " " + numbers[1]);
}

/*
 * Method (with return type)
 * - Returns a single integer value.
 */
public int methodWithReturn() {
    return 1;
}

/*
 * Method (example)
 * - Returns the sum of two integers.
 */
public int add(int a, int b) {
    return a + b;
}

/*
 * Calling Methods
 * - The example below shows how to call methods with different signatures.
 * - Demonstrates output for simple, arguments, varargs, and return-value methods.
 */
void main() {
    /*
     * Calling Method
     * - Output: Hello World
     */
    method();

    /*
     * Calling Method (with arguments)
     * - Output: a:5 b:3
     */
    methodWithArguments(5, 3);

    /*
     * Calling Method (with varargs)
     * - Output: 1 2
     */
    methodWithVarArgs(1, 2);

    /*
     * Calling Method (with return type)
     * - Output: 1
     */
    int x = methodWithReturn();
    IO.println(x);

    /*
     * Calling Example Method
     * - Output: 8
     */
    int sum = add(5, 3);
    IO.println(sum);
}