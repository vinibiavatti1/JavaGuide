/*
 * Methods
 * - This section explains how to define and use methods in Java to encapsulate behavior and organize program logic.
 *
 * Overview
 * - Methods define actions that a class or program can perform.
 * - They can accept parameters and optionally return a value.
 * - Methods improve code reuse, readability, maintainability, and modularity.
 *
 * Key Characteristics
 * - Parameters: inputs provided to the method.
 * - Return type: the value produced by the method; use void when no value is returned.
 * - Varargs: allow passing a variable number of arguments, handled internally as an array.
 * - Overloading: methods can be overloaded by changing the parameter list (number, type, or order of parameters).
 *
 * Usage
 * - Use methods to avoid code duplication and to group related logic.
 * - Apply parameters to customize method behavior.
 * - Use varargs when the number of arguments may vary.
 * - Return values when a result is required.
 */

/*
 * Method
 * - Simple method with no parameters and no return value.
 * - Demonstrates basic method structure.
 */
public void method() {
    IO.println("Hello World");
}

/*
 * Method With Parameters
 * - Accepts two integers as parameters and uses them inside the method.
 */
public void methodWithArguments(int a, int b) {
    IO.println("a=" + a + " b=" + b);
}

/*
 * Method With Varargs
 * - Accepts zero or more integers as arguments.
 * - Internally treated as an int array, allowing flexible number of parameters.
 */
public void methodWithVarargs(int... numbers) {
    IO.println(Arrays.toString(numbers));
}

/*
 * Method With Return Type
 * - Returns a single integer value.
 * - Demonstrates how to return a value from a method.
 */
public int methodWithReturn() {
    return 1;
}

/*
 * Real Method Example
 * - Returns the sum of two integers.
 * - Demonstrates a practical method that performs computation and returns a result.
 */
public int add(int a, int b) {
    return a + b;
}

/*
 * Calling Methods
 * - The example below shows how to call methods with different signatures.
 * - Demonstrates usage of methods with no parameters, parameters, varargs, and return values.
 */
void main() {
    /*
     * Calling Method
     * - Calls a method with no parameters and no return value.
     * - Output: Hello World
     */
    method();

    /*
     * Calling Method With Parameters
     * - Calls a method with two integer arguments.
     * - Output: a=5 b=3
     */
    methodWithArguments(5, 3);

    /*
     * Calling Method With Varargs
     * - Calls a method that accepts a variable number of integer arguments.
     * - Demonstrates that an array can also be passed directly.
     * - Output: [1] | [1, 2, 3] | [1, 2, 3]
     */
    methodWithVarargs(1);
    methodWithVarargs(1, 2, 3);
    methodWithVarargs(new int[] {1, 2, 3});

    /*
     * Calling Method With Return Type
     * - Calls a method that returns an integer value.
     * - Output: 1
     */
    int x = methodWithReturn();
    IO.println(x);

    /*
     * Calling Real Example Method
     * - Calls a method that calculates and returns the sum of two integers.
     * - Output: 8
     */
    int sum = add(5, 3);
    IO.println(sum);
}
