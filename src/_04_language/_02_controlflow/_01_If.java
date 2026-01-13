/*
 * Conditional Statements (if)
 * - This section explains how to use the "if" statement in Java to execute code blocks conditionally based on boolean
 *   expressions.
 *
 * Overview
 * - The "if" statement executes a block of code only when a specified condition evaluates to true.
 * - Conditions must be boolean expressions evaluated at runtime.
 * - Can be combined with "else if" and "else" to handle multiple execution paths.
 *
 * Key Characteristics
 * - Conditions must result in a boolean value ("true" or "false").
 * - Code blocks are executed only if the condition is satisfied, controlling program flow.
 * - Multiple conditions can be chained using "else if".
 * - Logical ("&&", "||", "!") and comparison ("==", "!=", "<", ">", "<=", ">=") operators are commonly used.
 * - Braces "{}" are optional for single statements but recommended for readability and to prevent errors.
 *
 * Usage
 * - Use "if" to execute code selectively based on program state or user input.
 * - Combine with "else if" and "else" for more complex conditional logic.
 * - Ensure conditions are clear and boolean to avoid unexpected behavior.
 */
void main() {
    /*
     * Conditional Statement (if)
     * - The "if" statement evaluates a boolean expression and executes the associated code block only when the
     *   condition is true.
     * - Output: x is positive
     */
    int x = 1;
    if (x > 0) {
        IO.println("x is positive");
    }

    /*
     * Conditional Statement (if without block)
     * - The if statement can be written without braces when it controls a single statement.
     * - In this form, only the immediately following statement is conditionally executed.
     * - Although valid, this style should be used with caution, as it can reduce readability and lead to errors when
     *   the code is later modified.
     * - Output: x is positive
     */
    x = 1;
    if (x > 0) IO.println("x is positive");

    /*
     * Conditional Statement (if else)
     * - The if-else statement allows a program to choose between two execution paths based on the evaluation of a
     *   boolean condition.
     * - If the condition is true, the code in the if block is executed. Otherwise, the code in the else block is
     *   executed.
     * - Output: x is negative
     */
    x = -1;
    if (x > 0) {
        IO.println("x is positive");
    } else {
        IO.println("x is negative");
    }

    /*
     * Conditional Statement (else if)
     * - The else-if construct allows chaining multiple conditions in sequence.
     * - Each condition is evaluated in order, and the first one that evaluates to true determines which block is
     *   executed.
     * - If none of the conditions are true, the optional else block is executed.
     * - Output: x is zero
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
     * Conditional Statement (if instanceof)
     * - The if instanceof statement allows a program to execute code based on the runtime type of object.
     * - If the object matches the specified type, the condition evaluates to true and the corresponding block is
     *   executed.
     * - In its traditional form, a manual cast is required to access type-specific behavior.
     * - Output: obj is Integer
     */
    Object obj = 1;
    if (obj instanceof Integer) {
        IO.println("obj is Integer");
    }

    /*
     * Conditional Statement (if instanceof with auto cast)
     * - This form of the if instanceof statement uses pattern matching to automatically cast the object to the target
     *   type.
     * - If the object matches the specified type, it is safely bound to a variable and can be used directly inside the
     *   block.
     * - Output: obj is Integer: 1
     */
    obj = 1;
    if (obj instanceof Integer i) {
        IO.println("obj is Integer: " + i);
    }
}