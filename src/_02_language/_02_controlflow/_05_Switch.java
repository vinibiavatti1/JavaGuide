/*
Conditional Statements (switch)
- This section explains how to use the "switch" statement in Java to select and execute a code block from multiple
  options based on the value of a single expression.

Overview
- The "switch" statement evaluates an expression once and executes the block corresponding to a matching case label.
- Control flow can optionally continue to subsequent cases unless explicitly terminated with "break".
- Modern Java allows using "switch" both as a statement and as an expression.

Key Characteristics
- The switch expression must evaluate to a compatible type (int, enum, String, or certain wrapper types).
- Each "case" represents a possible execution path.
- "break" is commonly used to prevent fall-through to the next case.
- A "default" case can handle unmatched values.
- Improves readability compared to long chains of "if-else" statements.
- Enhanced syntax in modern Java versions supports concise expressions and yields values.

Usage
- Use "switch" when selecting among multiple discrete values for clear, readable branching.
- Always consider adding a "default" case for unmatched scenarios.
- Use "break" or modern expression syntax to control flow and prevent unintended fall-through.
*/
void main() {
    /*
    Conditional Statement (switch)
    - The switch statement allows a program to select one execution path from multiple options based on the value of an
      expression.
    - Each case represents a possible match, and the corresponding block is executed when a match is found.
    - The break statement is used to prevent execution from continuing into the next case.
    - Output: Success
    */
    int httpStatus = 200;
    switch (httpStatus) {
        case 200:
            IO.println("Success");
            break;
        case 500:
            IO.println("Error");
            break;
    }

    /*
    Conditional Statement (switch with multiple case labels)
    - The switch statement allows multiple values to be handled by a single case block using comma-separated labels.
    - When the expression matches any of the listed values, the corresponding block is executed.
    - Output: Error
    */
    httpStatus = 500;
    switch (httpStatus) {
        case 200:
            IO.println("Success");
            break;
        case 300, 400, 500:
            IO.println("Error");
            break;
    }

    /*
    Conditional Statement (switch with fall-through)
    - This switch statement demonstrates the fall-through behavior, where multiple case labels share the same block.
    - When the expression matches any of the listed cases, the corresponding block is executed.
    - Output: Error
    */
    httpStatus = 400;
    switch (httpStatus) {
        case 200:
            IO.println("Success");
            break;
        case 300:
        case 400:
        case 500:
            IO.println("Error");
            break;
    }

    /*
    Conditional Statement (switch with default)
    - The switch statement allows a program to choose between multiple execution paths based on the value of an
      expression.
    - If none of the defined cases match the expression value, the default block is executed.
    - The default block should be always the last block in a switch statement.
    - Output: Unknown
    */
    httpStatus = 300;
    switch (httpStatus) {
        case 200:
            IO.println("Success");
            break;
        case 500:
            IO.println("Error");
            break;
        default:
            IO.println("Unknown");
    }

    /*
    Conditional Statement (switch expression)
    - This form of the switch statement is used as an expression, allowing the result of the switch to be assigned
      directly to a variable.
    - Each case produces a value, and the switch evaluates to that value.
    - This avoids mutable variables and makes the control flow more concise and expressive.
    - In a switch expression, the default case is required unless all possible values of the expression are explicitly
      covered.
    - Output: Error
    */
    httpStatus = 500;
    String message = switch(httpStatus) {
        case 200 -> "Success";
        case 500 -> "Error";
        default -> "Unknown";
    };
    IO.println(message);

    /*
    Conditional Statement (switch expression with block)
    - This switch expression uses a block for one of the cases, allowing multiple statements to be executed before
      producing a value.
    - The "yield" statement is used to return a value from the block for the switch expression.
    - Output: Default executed | Unknown
    */
    httpStatus = 999;
    message = switch(httpStatus) {
        case 200 -> "Success";
        case 500 -> "Error";
        default -> {
            IO.println("Default executed");
            yield "Unknown";
        }
    };
    IO.println(message);

    /*
    Pattern Matching (switch)
    - This switch statement uses pattern matching to test the runtime type of object.
    - To use pattern matching, a variable must be defined in the case label; this variable is automatically cast and
      bound to the matched type, allowing it to be used directly inside the case block.
    - Output: Integer: 1
    */
    Object obj = 1;
    switch (obj) {
        case Integer x:
            IO.println("Integer: " + x);
            break;
        default:
            IO.println("Unknown");
    }

    /*
    Pattern Matching (switch with null case)
    - This switch statement uses pattern matching to handle different types, including null values.
    - The case for null explicitly matches a null reference, while other cases can match specific types using a
      variable.
    - If the value of a binding variable is not needed, a wildcard "_" can be used to ignore it.
    - Output: Null
    */
    obj = null;
    switch (obj) {
        case Integer _:
            IO.println("Integer");
            break;
        case null:
            IO.println("Null");
            break;
        default:
            IO.println("Unknown");
    }

    /*
    Pattern Matching (switch with guards)
    - This switch statement uses pattern matching combined with guard conditions (when) to add extra boolean checks to
      each case.
    - A case is executed only if both the type matches and the guard condition evaluates to true.
    - Output: x is positive: 1
    */
    obj = 1;
    switch (obj) {
        case Integer x when x < 0:
            IO.println("x is negative: " + x);
            break;
        case Integer x when x > 0:
            IO.println("x is positive: " + x);
            break;
        case Integer x:
            IO.println("x is zero: " + x);
            break;
        default:
            IO.println("Unknown");
    }

    /*
    Pattern Matching (switch expression)
    - This switch statement uses pattern matching combined with guards and is used as an expression, allowing the result
      of the switch to be assigned directly to a variable.
    - Each case evaluates both the type and an optional guard condition, and the switch expression produces the
      corresponding value.
    - In a switch expression, the default case is required unless all possible values of the expression are explicitly
      covered.
    - Output: x is positive: 1
    */
    obj = 1;
    message = switch(obj) {
        case Integer x when x < 0 -> "x is negative: " + x;
        case Integer x when x > 0 -> "x is positive: " + x;
        case Integer x -> "x is zero: " + x;
        default -> "Unknown";
    };
    IO.println(message);
}