/*
Conditional Statements (switch)
The "switch" statement is used to select and execute one code block from multiple possible options based on the value
of a single expression.

In Java, the switch expression is evaluated once, and its result is compared against predefined case labels. When a
matching case is found, the corresponding block is executed. Control flow can optionally continue to subsequent cases
unless explicitly terminated.

Key characteristics:
- The switch expression must evaluate to a compatible type (such as int, enum, String, or certain wrapper types).
- Each case represents a possible execution path.
- The "break" statement is commonly used to prevent fall-through to the next case.
- A "default" case can be defined to handle unmatched values.
- Improves readability when handling multiple discrete values compared to long if-else chains.
- Since modern Java versions, switch supports enhanced syntax and can be used as an expression.
*/
@SuppressWarnings("all")
void main() {
    /*
    Conditional Statement (switch)
    The switch statement allows a program to select one execution path from multiple options based on the value of an
    expression.
    Each case represents a possible match, and the corresponding block is executed when a match is found.
    The break statement is used to prevent execution from continuing into the next case.
    Output: Success
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
    The switch statement allows multiple values to be handled by a single case block using comma-separated labels.
    When the expression matches any of the listed values, the corresponding block is executed.
    Output: Error
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
    This switch statement demonstrates the fall-through behavior, where multiple case labels share the same block.
    When the expression matches any of the listed cases, the corresponding block is executed.
    Output: Error
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
    Conditional Statement (switch wtih default)
    The switch statement allows a program to choose between multiple execution paths based on the value of an
    expression.
    If none of the defined cases match the expression value, the default block is executed.
    The default block should be always the last block in a switch statement.
    Output: Unknown
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
    This form of the switch statement is used as an expression, allowing the result of the switch to be assigned
    directly to a variable.
    Each case produces a value, and the switch evaluates to that value.
    This avoids mutable variables and makes the control flow more concise and expressive.
    In a switch expression, the default case is required unless all possible values of the expression are explicitly
    covered.
    Output: Error
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
    This switch expression uses a block for one of the cases, allowing multiple statements to be executed before
    producing a value.
    The "yield" statement is used to return a value from the block for the switch expression.
    Output: Default executed | Unknown
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
    This switch statement uses pattern matching to test the runtime type of an object.
    To use pattern matching, a variable must be defined in the case label; this variable is automatically cast and bound
    to the matched type, allowing it to be used directly inside the case block.
    Output: Integer: 1
    */
    Object obj = 1;
    switch (obj) {
        case Integer i:
            IO.println("Integer: " + i);
            break;
        default:
            IO.println("Unknown");
    }

    /*
    Pattern Matching (switch with null case)
    This switch statement uses pattern matching to handle different types, including null values.
    The case for null explicitly matches a null reference, while other cases can match specific types using a variable.
    If the value of a binding variable is not needed, a wildcard "_" can be used to ignore it.
    Output: Null
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
    This switch statement uses pattern matching combined with guard conditions (when) to add extra boolean checks to
    each case.
    A case is executed only if both the type matches and the guard condition evaluates to true.
    Output: i is positive: 1
    */
    obj = 1;
    switch (obj) {
        case Integer i when i < 0:
            IO.println("i is negative: " + i);
            break;
        case Integer i when i > 0:
            IO.println("i is positive: " + i);
            break;
        case Integer i:
            IO.println("i is zero: " + i);
            break;
        default:
            IO.println("Unknown");
    }

    /*
    Pattern Matching (switch expression)
    This switch statement uses pattern matching combined with guards and is used as an expression, allowing the result
    of the switch to be assigned directly to a variable.
    Each case evaluates both the type and an optional guard condition, and the switch expression produces the
    corresponding value.
    In a switch expression, the default case is required unless all possible values of the expression are explicitly
    covered.
    Output: i is positive: 1
    */
    obj = 1;
    message = switch(obj) {
        case Integer i when i < 0 -> "i is negative: " + i;
        case Integer i when i > 0 -> "i is positive: " + i;
        case Integer i -> "i is zero: " + i;
        default -> "Unknown";
    };
    IO.println(message);
}