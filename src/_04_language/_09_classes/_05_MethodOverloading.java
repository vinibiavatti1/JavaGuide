/*
Method Overloading
- This section explains method overloading in Java, which allows multiple methods in the same class to share the same
  name but differ in their parameter lists.

Overview
- Overloaded methods have identical names but differ in at least one of the following:
  - Number of parameters
  - Types of parameters
  - Order of parameters
- The return type alone is not enough to distinguish overloaded methods.
- Overloading improves code readability and flexibility by allowing the same method name for conceptually similar
  actions with different inputs.
- Overloaded methods are resolved at compile time, based on the arguments provided in a method call.

Usage
- Use method overloading to offer multiple ways to perform an operation depending on input types or counts.
- Ensure that overloaded methods perform similar or related actions to maintain clarity.
- Avoid overloading with completely unrelated functionality, as it can confuse readers and maintainers.

Example
- The example demonstrates the use of method overloading and shows how calls to these overloaded methods are resolved
  based on the arguments provided.
*/
public class Printer {
    // Base method
    public void print(String a, int b) {
        IO.println(a + b);
    }

    // Overload by number of parameters
    public void print(String a, int b, int c) {
        IO.println(a + b + c);
    }

    // Overload by type of parameters
    public void print(String a, double b) {
        IO.println(a + b);
    }

    // Overload by order of parameters
    public void print(int b, String a) {
        IO.println(a + b);
    }
}

void main() {
    Printer calc = new Printer();
    calc.print("x=", 1);    // x=1
    calc.print("x=", 1, 2); // x=12
    calc.print("x=", 3.14); // x=3.14
    calc.print(1, "x=");    // x=1
}