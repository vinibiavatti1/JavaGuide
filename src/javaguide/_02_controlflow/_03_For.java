/*
Looping Statements (for and for-each)
The "for" statement is used to repeatedly execute a block of code a specific number of times,
controlled by an initialization, a condition, and an update expression.

In Java, the initialization is executed once at the beginning, the condition is evaluated
before each iteration, and the update expression is executed after each iteration.
For loops can have multiple initializations, conditions, and update expressions, all separated by commas.

For Syntax: for(<initializations>; <conditions>; <updates>)

The "for-each" loop (enhanced for loop) is used to iterate over all elements of an array or Iterable,
without needing an explicit index. It is simpler and more readable when the index is not required.

For-each Syntax: for(<elementType> <element> : <arrayOrCollection>)

Key characteristics:
- The condition in a traditional for loop must evaluate to a boolean value.
- Both loops may execute zero or more times depending on the data or condition.
- Initialization, condition, and update can be customized in a traditional for loop.
- For-each loops automatically traverse all elements in order.
- Misconfigured traditional loops can result in infinite loops or skipped iterations.
- For-each is preferred for readability when only element access is needed.
*/
@SuppressWarnings("all")
void main() {
    /*
    Looping Statement (for)
    The for loop is used to execute a block of code repeatedly for a known number of iterations.
    It consists of an initialization, a condition, and an update expression.
    The loop executes the code block while the condition evaluates to true, updating
    variables as specified after each iteration.
    Output: 0 | 1 | 2
    */
    for (int i = 0; i < 3; i++) {
        IO.println(i);
    }

    /*
    Looping Statement (for without block)
    A for loop can be written without braces if it controls a single statement.
    In this form, only the immediately following statement is considered part of the loop.
    While valid, this style should be used with caution, as adding additional statements without braces can lead to
    logic errors or reduced readability.
    Output: 0 | 1 | 2
    */
    for (int i = 0; i < 3; i++) IO.println(i);

    /*
    Looping Statement (infinite for)
    A for loop can be made infinite by omitting the initialization, condition, and update expressions.
    Such loops are often used for continuous processing, like servers or event listeners.
    To prevent the program from hanging, an explicit exit condition or a break statement should be included inside the
    loop.
    */
    for (;;) {
        break;
    }

    /*
    Looping Statement (for with multiple configurations)
    A for loop can include multiple initializations, conditions, and updates, separated by commas.
    This allows controlling multiple variables simultaneously within a single loop.
    Output: i:0 j:6 | i:1 j:5 | i:2 j:4
    */
    for (int i = 0, j = 6; i < 3 && j > 3; i++, j--) {
        IO.println("i:" + i + " j:" + j);
    }

    /*
    Looping Statement (for each)
    The for-each loop (enhanced for loop) is used to iterate over all elements of an array or collection without needing
    an explicit index.
    It provides a simpler and more readable way to access each element in sequence.
    Syntax: for(<elementType> <element> : <arrayOrCollection>)
    Output: A | B | C
    */
    char[] arr = new char[] {'A', 'B', 'C'};
    for (char c : arr) {
        IO.println(c);
    }
}