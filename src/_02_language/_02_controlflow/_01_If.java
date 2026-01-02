/*
Conditional Statements (if)
The "if" statement is used to execute a block of code only when a specified condition evaluates to true.

In Java, the condition must be a boolean expression and is evaluated at runtime. Based on the result, the program can
follow different execution paths using if, else if, and else clauses.

Key characteristics:
- Conditions must evaluate to a boolean value.
- Code blocks are executed conditionally, controlling program flow.
- Multiple conditions can be chained using else if.
- Logical and comparison operators are commonly used in conditions.
- Braces are optional for single statements but recommended for clarity and safety.
*/
void main() {
    /*
    Conditional Statement (if)
    The "if" statement evaluates a boolean expression and executes the associated code block only when the condition is
    true.
    Output: x is positive
    */
    int x = 1;
    if (x > 0) {
        IO.println("x is positive");
    }

    /*
    Conditional Statement (if without block)
    The if statement can be written without braces when it controls a single statement.
    In this form, only the immediately following statement is conditionally executed.
    Although valid, this style should be used with caution, as it can reduce readability
    and lead to errors when the code is later modified.
    Output: x is positive
    */
    x = 1;
    if (x > 0) IO.println("x is positive");

    /*
    Conditional Statement (if else)
    The if-else statement allows a program to choose between two execution paths based on the evaluation of a boolean
    condition.
    If the condition is true, the code in the if block is executed. Otherwise, the code in the else block is executed.
    Output: x is negative
    */
    x = -1;
    if (x > 0) {
        IO.println("x is positive");
    } else {
        IO.println("x is negative");
    }

    /*
    Conditional Statement (else if)
    The else-if construct allows chaining multiple conditions in sequence.
    Each condition is evaluated in order, and the first one that evaluates to true determines which block is executed.
    If none of the conditions are true, the optional else block is executed.
    Output: x is zero
    */
    x = 0;
    if (x > 0) {
        IO.println("x is positive");
    } else if (x < 0) {
        IO.println("x is negative");
    } else {
        IO.println("x is zero");
    }

    /*
    Conditional Statement (if instanceof)
    The if instanceof statement allows a program to execute code based on the runtime type of an object.
    If the object matches the specified type, the condition evaluates to true and the corresponding block is executed.
    In its traditional form, a manual cast is required to access type-specific behavior.
    Output: obj is Integer
    */
    Object obj = 1;
    if (obj instanceof Integer) {
        IO.println("obj is Integer");
    }

    /*
    Conditional Statement (if instanceof with auto cast)
    This form of the if instanceof statement uses pattern matching to automatically cast the object to the target type.
    If the object matches the specified type, it is safely bound to a variable and can be used directly inside the
    block.
    Output: obj is Integer: 1
    */
    obj = 1;
    if (obj instanceof Integer i) {
        IO.println("obj is Integer: " + i);
    }
}