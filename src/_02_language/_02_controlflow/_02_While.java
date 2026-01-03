/*
Looping Statements (while)
- This section explains how to use the "while" loop in Java to repeatedly execute a block of code while a condition
  remains true.

Overview
- The "while" loop executes its body as long as the specified boolean condition evaluates to true.
- The condition is evaluated **before each iteration**.
- If the condition is false at the first check, the loop body is skipped entirely.

Key Characteristics
- The condition must result in a boolean value.
- The loop may execute zero or more times depending on the condition.
- The condition is re-evaluated before every iteration.
- Commonly used when the number of iterations is not known in advance.
- Improper updates to the condition may result in infinite loops.

Usage
- Use "while" loops for tasks that require repeated execution until a certain condition changes.
- Ensure the condition will eventually become false to avoid infinite loops.
- Can be combined with "break" or "continue" for more control over loop execution.
*/
void main() {
    /*
    Looping Statement (while)
    - Executes a block of code repeatedly while the given condition evaluates to true.
    - The condition is checked before each iteration, meaning the loop may execute zero or more times depending on the
      initial state.
    - Output: 0 | 1 | 2
    */
    int i = 0;
    while (i < 3) {
        IO.println(i);
        i++;
    }

    /*
    Looping Statement (while without block)
    - Executes a single statement repeatedly while the condition remains true.
    - When braces are omitted, only the immediately following statement is considered part of the loop. This form is
      valid but should be used with care to avoid readability and logic errors.
    - Output: 0 | 1 | 2
    */
    i = 0;
    while (i < 3) IO.println(i++);

    /*
    Looping Statement (infinite while)
    - A while loop can create an infinite loop if the condition always evaluates to true.
    - Infinite loops are often used in scenarios that require continuous processing, such as servers or event listeners,
      but care must be taken to include a proper exit condition or break statement to avoid unintentional application
      hangs.
    */
    while(true) {
        break;
    }

    /*
    Looping Statement (do-while)
    - The do-while loop executes a block of code at least once before checking the condition at the end of the loop. The
      loop will continue executing as long as the condition evaluates to true.
    - Output: 0 | 1 | 2
    */
    i = 0;
    do {
        IO.println(i);
        i++;
    } while(i < 3);
}