/*
Method Overloading
This section explains method overloading in Java, which allows multiple methods in the same class to have the same
name but different parameter lists.

Overview
- Overloaded methods have the same method name but differ in:
  - Number of parameters
  - Types of parameters
  - Order of parameters
- The return type alone is not sufficient to distinguish overloaded methods.
- Overloading provides flexibility and improves code readability by using the same method name for similar operations.

Usage
- Use method overloading to provide multiple ways to perform an operation based on different input types or counts.
- Overloaded methods should perform conceptually similar actions to avoid confusion.
- Method selection occurs at compile time based on the arguments provided.

Example
- "add(int a, int b)" adds two integers.
- "add(double a, double b)" adds two doubles.
*/
@SuppressWarnings("all")
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

/*
Method Overloading Example
In this example, the "add" method is overloaded to handle different types and numbers of arguments.
The compiler selects the correct method based on the argument types and count.
*/
@SuppressWarnings("all")
void main() {
    Calculator calc = new Calculator();
    IO.println(calc.add(2, 3));        // 5
    IO.println(calc.add(2.5, 3.5));    // 6.0
}