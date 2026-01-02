/*
Methods
This section explains how to define and use methods in Java, allowing classes or programs to encapsulate behavior that
can accept parameters, return values, or handle variable-length arguments.

Overview
- Methods define operations or actions that a class or program can perform.
- They can accept parameters to customize behavior and optionally return values.
- Methods improve code reuse, readability, maintainability, and organization.

Key Characteristics
- Arguments: inputs that influence method behavior.
- Return type: the output of a method; use void if no value is returned.
- Varargs: allows passing zero or more arguments of the same type, treated internally as an array.
- Methods can be overloaded (same name, different arguments) for flexibility.

Usage
- Use methods to encapsulate behavior and avoid code duplication.
- Apply varargs for flexible argument lists.
- Return values when a result is needed; otherwise, use void.
- Common examples: utility methods, calculation methods, getters/setters, and main program logic.
*/

/*
Method
- A simple method with no arguments and no return value (void).
- Demonstrates basic method declaration.
*/
public void method() {
    IO.println("Hello World");
}

/*
Method (with arguments)
- Accepts two integers as parameters and prints them.
- Demonstrates declaring arguments to a method.
*/
public void methodWithArguments(int a, int b) {
    IO.println("a:" + a + " b:" + b);
}

/*
Method (with varargs)
- Accepts a variable number of integer arguments.
- Demonstrates how varargs are treated as an array internally.
*/
public void methodWithVarArgs(int... numbers) {
    IO.println(numbers[0] + " " + numbers[1]);
}

/*
Method (with return type)
- Returns an integer value.
- Demonstrates how to define a method with a return type.
*/
public int methodWithReturn() {
    return 1;
}

/*
Method Example
- Returns the sum of two integers.
- Demonstrates a practical example of a method performing a computation.
*/
public int add(int a, int b) {
    return a + b;
}

/*
Calling Methods
- The example below shows how to call methods with different signatures.
- Demonstrates output for simple, arguments, varargs, and return-value methods.
*/
void main() {
    /*
    Calling Method
    Output: Hello World
    */
    method();

    /*
    Calling Method (with arguments)
    Output: a:5 b:3
    */
    methodWithArguments(5, 3);

    /*
    Calling Method (with varargs)
    Output: 1 2
    */
    methodWithVarArgs(1, 2);

    /*
    Calling Method (with return type)
    Output: 1
    */
    int x = methodWithReturn();
    IO.println(x);

    /*
    Calling Example
    Output: 8
    */
    int sum = add(5, 3);
    IO.println(sum);
}